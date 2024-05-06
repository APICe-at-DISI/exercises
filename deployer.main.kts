#!/usr/bin/env kotlin
@file:Repository("https://repo.maven.apache.org/maven2")
@file:DependsOn("com.uchuhimo:konf:1.1.2")
@file:DependsOn("com.lordcodes.turtle:turtle:0.10.0")
@file:OptIn(ExperimentalPathApi::class)

import com.lordcodes.turtle.shellRun
import com.uchuhimo.konf.Config
import com.uchuhimo.konf.ConfigSpec
import com.uchuhimo.konf.source.yaml
import java.io.File
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.Path
import kotlin.io.path.createTempDirectory

object Dirs {
    val workDir = "build"
    val workDirPath = Path(workDir)
    val workDirFile = File(workDir)

    fun mkTempDir(prefix: String): File = createTempDirectory(workDirPath, prefix).toFile()
}

/**
 * DSL / YAML parser
 */
data class Contents(val from: String, val to: String, val excluding: List<String> = emptyList())
data class Package(val format: List<String>, val destinations: List<String>, val contents: List<Contents>)
object Configuration : ConfigSpec("") {
    val branch by optional("exercises")
    val packages by required<Map<String, Package>>()
}

/**
 * Output model
 */
sealed interface DataPacker {

    fun packFor(owner: String, repo: String): List<Deployment>

    data class Zip(
        val packageName: String,
        val exerciseFolder: File,
        val solutionFolder: File,
        val version: String,
        val outputFolder: File = Dirs.mkTempDir("$packageName-zip"),
    ) : DataPacker {

        override fun packFor(owner: String, repo: String): List<Deployment> {
            val exerciseZip = File(outputFolder, "$packageName.zip")
            val solutionsZip = File(outputFolder, "$packageName-solutions.zip")
            check(
                !exerciseZip.exists() &&
                !solutionsZip.exists() &&
                exerciseFolder.exists() && exerciseFolder.isDirectory &&
                solutionFolder.exists() && solutionFolder.isDirectory
            )
            exerciseFolder.zipInTo(exerciseZip)
            solutionFolder.zipInTo(solutionsZip)
            val target = "${exerciseZip.absolutePath},${solutionsZip.absolutePath}"
            return listOf(Deployment("release", owner, repo, version, target))
        }

        companion object {
            fun File.zipInTo(zipFile: File) {
                ZipOutputStream(zipFile.outputStream()).use { output ->
                    walkTopDown().filter { it.isFile }.forEach { file ->
                        output.putNextEntry(ZipEntry(file.absolutePath.removePrefix("${absolutePath}/")))
                        file.inputStream().copyTo(output)
                    }
                }
            }
        }
    }

    data class Repo(
        val packageName: String,
        val exerciseFolder: File,
        val solutionFolder: File,
    ) : DataPacker {
        override fun packFor(owner: String, repo: String): List<Deployment> = listOf(
            Deployment("repo", owner, repo, "exercises", exerciseFolder.absolutePath),
            Deployment("repo", owner, repo, "solutions", solutionFolder.absolutePath),
        )
    }
}

data class Deployment(
    val type: String,
    val owner: String,
    val repo: String,
    val ref: String,
    val target: String,
) {
    fun toJson() = """{"type":"$type","owner":"$owner","repo":"$repo","ref":"$ref","target":"$target"}"""
}

fun File.cleanup() = apply {
    check(deleteRecursively() && mkdirs()) {
        "$absolutePath could not be reset"
    }
}

// Actual algorithm

val yamlFile = File("config.yml")
val configuration = Config { addSpec(Configuration) }.from.yaml.file(yamlFile)
val exerciseBranch = configuration[Configuration.branch]
shellRun { command("git", listOf("fetch")) }
Dirs.workDirFile.cleanup()
val exercisesDir = createTempDirectory(exerciseBranch).toFile().cleanup()
shellRun {
    command(
        "git",
        listOf(
            "--work-tree=${exercisesDir.absolutePath}",
            "checkout",
            "--recurse-submodules",
            "origin/$exerciseBranch",
            "--",
            "."
        )
    )
}
val version by lazy {
    val commitCount = shellRun {command("git", listOf("rev-list", "--count", "HEAD")) }
    val yearDotMonthDay = shellRun {
        command("git", listOf("show", "-s", "--format=%cd", "--date=format:%y.%-m%d", "HEAD"))
    }
    "$commitCount.$yearDotMonthDay"
}
val packages = configuration[Configuration.packages]
val matchSlug = Regex("^(?<owner>[^/]+)/(?<repo>[^/]+)$")
val deployments = packages.flatMap { (name, pack) ->
    check(name != exerciseBranch) {
        "the packages cannot share the name of the exercise branch: '$exerciseBranch'"
    }
    check(pack.contents.isNotEmpty())
    check(pack.format.isNotEmpty())
    check(pack.destinations.isNotEmpty())
    val exerciseFolder = Dirs.mkTempDir(name)
    val solutionFolder = Dirs.mkTempDir(name)
    pack.contents.forEach { descriptor ->
        val solFrom = File(descriptor.from)
        val solTo = File(solutionFolder, descriptor.to)
        solFrom.copyRecursively(solTo, overwrite = true)
        val exFrom = File(exercisesDir, descriptor.from)
        val exTo = File(exerciseFolder, descriptor.to)
        exFrom.copyRecursively(exTo, overwrite = true)
        descriptor.excluding.forEach { notIncluded ->
            listOf(exTo, solTo).forEach { folder ->
                File(folder, notIncluded).deleteRecursively()
            }
        }
    }
    pack.format.flatMap { format ->
        pack.destinations.flatMap { destination ->
            val groups = checkNotNull(matchSlug.matchEntire(destination)?.destructured) {
                "The destination must match regex $matchSlug"
            }
            val (owner, repo) = groups
            when (format) {
                "zip" -> DataPacker.Zip(name, exerciseFolder, solutionFolder, version)
                "repo" -> DataPacker.Repo(name, exerciseFolder, solutionFolder)
                else -> error("unknown format $format")
            }.packFor(owner, repo)
        }
    }
}
val json = """{"include":${deployments.map(Deployment::toJson)}}"""
println("::set-output name=matrix::$json")
