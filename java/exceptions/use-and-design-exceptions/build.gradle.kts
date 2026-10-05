plugins {
    java
    id("org.danilopianini.gradle-java-qa") version "1.197.0"
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("it.unibo.exceptions.UseArithmeticService")
}
