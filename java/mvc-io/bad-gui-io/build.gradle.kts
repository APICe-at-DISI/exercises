plugins {
    application
    java
    id("org.danilopianini.gradle-java-qa") version "1.121.0"
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("it.unibo.mvc.BadIOGUI")
}
