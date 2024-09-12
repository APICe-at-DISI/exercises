plugins {
    application
    java
    id("org.danilopianini.gradle-java-qa") version "1.65.2"
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
