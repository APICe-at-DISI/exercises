plugins {
    application
    java
    id("org.danilopianini.gradle-java-qa") version "1.199.0"
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("it.unibo.es3.Test")
}

tasks.javadoc {
    isFailOnError = false
}
