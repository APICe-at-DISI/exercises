plugins {
    application
    java
    id("com.gradleup.shadow") version "9.2.1"
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("it.unibo.io.TarantulaNebula")
}
