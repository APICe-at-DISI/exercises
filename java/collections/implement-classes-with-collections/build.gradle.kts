plugins {
    java
}

val runOrderedWarehouse by tasks.registering(JavaExec::class) {
    mainClass.set("it.unibo.collections.design.UseOrderedWarehouse")
    classpath(sourceSets.main.get().runtimeClasspath)
}

tasks.run.get().dependsOn(runOrderedWarehouse)
