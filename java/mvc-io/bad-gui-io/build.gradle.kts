plugins {
    application
    java
    id("org.danilopianini.gradle-java-qa") version "1.98.0"
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("it.unibo.mvc.BadIOGUI")
}
