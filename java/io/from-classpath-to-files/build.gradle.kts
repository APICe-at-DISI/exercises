plugins {
    application
    java
    id("com.gradleup.shadow") version "9.1.0"
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("it.unibo.io.TarantulaNebula")
}
