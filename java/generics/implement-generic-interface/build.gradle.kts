import org.gradle.kotlin.dsl.registering

plugins {
    application
    java
    id("org.danilopianini.gradle-java-qa") version "0.40.0"
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("it.unibo.generics.graph.UseGraph")
}

spotbugs {
    omitVisitors.set(listOf("FindReturnRef"))
}
