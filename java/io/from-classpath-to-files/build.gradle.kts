plugins {
    application
    java
    id("org.danilopianini.gradle-java-qa") version "0.40.0"
    id("com.github.johnrengelman.shadow") version "8.1.0"
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("it.unibo.io.TarantulaNebula")
}
