plugins {
    application
    java
    id("org.danilopianini.gradle-java-qa") version "1.82.2"
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("it.unibo.mvc.MiniGUI")
}
