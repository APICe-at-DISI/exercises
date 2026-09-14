plugins {
    application
    java
    id("org.danilopianini.gradle-java-qa") version "1.187.0"
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("com.github.spotbugs:spotbugs-annotations:4.10.4")
}

application {
    mainClass.set("it.unibo.es1.Test")
}

tasks.javadoc {
    isFailOnError = false
}
