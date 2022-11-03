#!/usr/bin/env kotlin
@file:Repository("https://repo.maven.apache.org/maven2")
@file:DependsOn("com.lordcodes.turtle:turtle:0.8.0")

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

listOf("collections", "generics", "exceptions").forEach {
    File("java/$it").inAllDirectories {
        val tasks = arrayOf("build") + if (git.currentBranch() == "master") arrayOf("run") else emptyArray()
        gradle(*tasks)
    }
}

listOf(
    "gui",
    // "mvc-io" Temporarily disabled, Roby enable it for lab08
).forEach {
    File("java/$it").inAllDirectories {
        val tasks = arrayOf("build", "javadoc") // Don't run, as it would open a GUI and stall
        gradle(*tasks)
    }
}

inside("java/nested-enum/month-comparator") { gradle("build") }
