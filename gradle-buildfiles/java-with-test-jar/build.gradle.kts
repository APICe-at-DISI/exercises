plugins {
    java
    application
    id("com.gradleup.shadow") version "9.2.1"
}

repositories {
    mavenCentral()
}

dependencies {
    // The BOM (Bill of Materials) synchronizes all the versions of Junit coherently.
    testImplementation(platform("org.junit:junit-bom:5.13.4"))
    // The annotations, assertions and other elements we want to have access to when compiling our tests.
    testImplementation("org.junit.jupiter:junit-jupiter")
    // The engine that must be available at runtime to run the tests.
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
    testLogging { events(*TestLogEvent.values()) }
    testLogging.showStandardStreams = true
}

application {
    val mainClass: String by project
    mainClass.set(mainClass)
}
