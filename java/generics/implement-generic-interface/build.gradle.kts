plugins {
    java
    id("org.danilopianini.gradle-java-qa") version "1.197.0"
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("it.unibo.generics.graph.UseGraph")
}

spotbugs {
    omitVisitors.set(listOf("FindReturnRef"))
}
