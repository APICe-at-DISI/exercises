import org.gradle.kotlin.dsl.registering

plugins {
    application
    java
    id("org.danilopianini.gradle-java-qa") version "1.97.2"
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("it.unibo.exceptions.UseArithmeticService")
}
