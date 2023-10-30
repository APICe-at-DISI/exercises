plugins {
    application
    java
    id("org.danilopianini.gradle-java-qa") version "1.22.1"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("it.unibo.io.TarantulaNebula")
}
