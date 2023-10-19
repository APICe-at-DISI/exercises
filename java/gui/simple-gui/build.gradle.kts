plugins {
    application
    java
    id("org.danilopianini.gradle-java-qa") version "1.22.0"
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("it.unibo.mvc.MiniGUI")
}
