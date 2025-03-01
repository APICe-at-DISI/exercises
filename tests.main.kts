#!/usr/bin/env kotlin
@file:Repository("https://repo.maven.apache.org/maven2")
@file:DependsOn("com.lordcodes.turtle:turtle:0.10.0")

import com.lordcodes.turtle.GitCommands
import com.lordcodes.turtle.ShellScript
import com.lordcodes.turtle.shellRun
import java.io.File

// DSL
fun ShellScript.gradle(vararg tasks: String) = tasks.toList().let { tasksList ->
    command("bash", listOf("gradlew") + tasksList)
        .also { println("$ ./gradlew ${tasksList.joinToString(" ") }") }
}

fun File.inAllDirectories(run: ShellScript.() -> String) = requireNotNull(listFiles()) { "not a directory: $this" }
    .filter { it.isDirectory }
    .forEach { inside(it, run) }

fun inside(path: String, run: ShellScript.() -> String) = shellRun {
    val startDirectory = command("pwd")
    changeWorkingDirectory(path)
    println("Running in $path")
    val result = run()
    changeWorkingDirectory(startDirectory)
    result
}

fun inside(path: File, run: ShellScript.() -> String) = inside(path.absolutePath, run)

inside("java/basics") {
    gradle("compileJava", "test")
}

File("java/inheritance/").inAllDirectories {
    gradle("compileJava")
}

fun GitCommands.branchContains(name: String) = name in currentBranch() || name in System.getenv("BRANCH").orEmpty()

listOf("collections", "generics", "exceptions", "lambdas", "streams", "concurrency").forEach {
    File("java/$it").inAllDirectories {
        val tasks = arrayOf("build") + when {
            git.branchContains("exercises") -> arrayOf("-x", "test")
            else -> emptyArray()
        }
        gradle(*tasks)
    }
}

listOf(
    "mvc-io", "gui", "nested-enum", "io", "testing",
).forEach {
    File("java/$it").inAllDirectories {
        val tasks = arrayOf("assemble", "javadoc") +
            if (git.branchContains("master")) arrayOf("build") else emptyArray()
        gradle(*tasks)
    }
}
