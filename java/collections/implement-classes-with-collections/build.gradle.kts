plugins {
    application
    java
    id("org.danilopianini.gradle-java-qa") version "0.37.0"
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("it.unibo.collections.design.UseWarehouse")
}