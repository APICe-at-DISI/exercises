plugins {
    application
    java
    id("com.gradleup.shadow") version "9.0.2"
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("it.unibo.io.TarantulaNebula")
}
