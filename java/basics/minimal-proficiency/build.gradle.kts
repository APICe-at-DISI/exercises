sourceSets {
    main {
        java {
            setSrcDirs(
                /**
                 * Add a line here if you add an exercise
                 */
                listOf(
                    "analysis-method-scope-with-multifile-compilation",
                    "command-line-arguments/src",
                    "compilation-and-packages/src",
                    "compilation-classpath/src",
                    "impl-calculator",
                    "impl-train-with-correlated-fields",
                    "impl-complex-num",
                    "impl-complex-num-calculator",
                    "complete-existing-class-student",
                    "hello-world",
                    "compilation-multifile/src",
                    "code-organization/src",
                    "reference-value/src",
                    "constructors/src",
                )
            )
        }
    }
}

/*
 * roughly matches classes with a main method
 */
val mainRegex = "public\\s+static\\s+void\\s+main\\s*\\(String(\\[\\]|\\.\\.\\.)\\s+\\w+\\)\\s*\\{"
val main = Regex(mainRegex)
/*
 * extracts the class names from files with a main method
 */
val classFinder = Regex("class\\s+(\\w+)\\s*\\{.*$mainRegex", RegexOption.DOT_MATCHES_ALL)

projectDir.walkTopDown() // For all the directories in this project
    .filter { it.isFile && it.extension == "java" } // find all java files
    .map { it.readText() } // whose text
    .filter { main.find(it) != null } // contains a main method
    .map { classFinder.findAll(it).toList() } // and search for the class names
    .onEach { require(it.size == 1) } // make sure there is only one
    .map { it.first().destructured.component1() } // pick it
    .forEach { className -> // create a task that launches the main
        val testTask = project.tasks.register<JavaExec>("run$className") {
            group = "test by plain java launch"
            description = "Runs $className"
            classpath = sourceSets["main"].runtimeClasspath
            mainClass.set(className)
        }
        tasks.test.get().dependsOn(testTask)
    }
