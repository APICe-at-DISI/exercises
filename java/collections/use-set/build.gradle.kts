import org.gradle.kotlin.dsl.registering

plugins {
    application
    java
    id("org.danilopianini.gradle-java-qa") version "0.37.0"
}

repositories {
    mavenCentral()
}

val runSet = tasks.registering(JavaExec::class) {
    mainClass.set("it.unibo.collections.sets.UseSet")
}

val runCollection = tasks.registering(JavaExec::class) {
    mainClass.set("it.unibo.collections.collections.UseCollection")
}

tasks.run.get().dependsOn(runSet, runCollection)
