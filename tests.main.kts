#!/usr/bin/env kotlin
@file:Repository("https://repo.maven.apache.org/maven2")
@file:DependsOn("com.lordcodes.turtle:turtle:0.7.0")

import com.lordcodes.turtle.ShellScript
import com.lordcodes.turtle.shellRun
import java.io.File

// DSL
fun ShellScript.gradle(vararg tasks: String) = command("./gradlew", tasks.toList())
fun inside(path: String, run: ShellScript.() -> String) = shellRun {
    val startDirectory = command("pwd")
    changeWorkingDirectory(path)
    println("Running in ${command("pwd")}")
    println("Local contents:\n${command("ls", listOf("-ahl"))}")
    val result = run()
    changeWorkingDirectory(startDirectory)
    result
}

inside("java${File.separator}basics") {
    gradle("compileJava")
}
