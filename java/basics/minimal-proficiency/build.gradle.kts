sourceSets {
    main {
        java {
            setSrcDirs(
                /**
                 * Add a line here if you add an exercise
                 */
                listOf(
                    "impl-calculator",
                    "impl-train-with-correlated-fields",
                    "complete-existing-class-student",
                    "hello-world",
                    "compilation-multifile",
                    "compilation-classpath",
                    "compilation-and-packages",
                    "analysis-method-scope-with-multifile-compilation"
                )
            )
        }
    }
}

val mainRegex = "public\\s+static\\s+void\\s+main\\s*\\(String(\\[\\]|\\.\\.\\.)\\s+\\w+\\)\\s*\\{"
val main = Regex(mainRegex)
val classFinder = Regex("class\\s+(\\w+)\\s*\\{.*$mainRegex", RegexOption.DOT_MATCHES_ALL)

projectDir.walkTopDown()
    .filter { it.isFile && it.extension == "java" }
    .map { it.readText() }
    .filter { main.find(it) != null }
    .map { classFinder.findAll(it).toList() }
    .onEach { require(it.size == 1) }
    .map { it.first().destructured.component1() }
    .forEach { className ->
        val testTask = project.tasks.register<JavaExec>("run$className") {
            group = "test by plain java launch"
            description = "Runs $className"
            classpath = sourceSets["main"].runtimeClasspath
            mainClass.set(className)
        }
        tasks.test.get().dependsOn(testTask)
    }
