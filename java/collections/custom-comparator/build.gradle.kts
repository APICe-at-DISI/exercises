plugins {
    application
    java
    id("org.danilopianini.gradle-java-qa") version "1.81.0"
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("it.unibo.collections.comparators.UseSetWithOrder")
}

spotbugs {
    omitVisitors.set(listOf("ComparatorIdiom"))
}
