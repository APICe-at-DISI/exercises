#!/usr/bin/env kotlin
@file:Repository("https://repo.maven.apache.org/maven2")
@file:DependsOn("com.lordcodes.turtle:turtle:0.7.0")

import com.lordcodes.turtle.ShellScript
import com.lordcodes.turtle.shellRun
import java.io.File

// DSL
fun ShellScript.gradle(vararg tasks: String) = command("bash", listOf("gradlew") + tasks.toList())

fun inside(path: String, run: ShellScript.() -> String) = shellRun {
    val startDirectory = command("pwd")
    changeWorkingDirectory(path)
    val result = run()
    changeWorkingDirectory(startDirectory)
    result
}

inside("java/basics") {
    gradle("compileJava", "test")
}
