plugins {
    application
    java
    id("org.danilopianini.gradle-java-qa") version "1.65.2"
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("it.unibo.mvc.LaunchApp")
}

spotbugs {
    omitVisitors.set(listOf("FindReturnRef", "DumbMethods"))
}

tasks.javadoc {
    isFailOnError = false
}
