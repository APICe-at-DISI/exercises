plugins {
    application
    java
    id("org.danilopianini.gradle-java-qa") version "1.134.0"
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("it.unibo.generics.utilities.UseUtilities")
}
