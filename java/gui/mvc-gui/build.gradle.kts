plugins {
    application
    java
    id("org.danilopianini.gradle-java-qa") version "1.127.0"
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("it.unibo.mvc.LaunchApp")
}

tasks.javadoc {
    isFailOnError = false
}
