import Util.prepareTasksToRunMainMethods

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
                    "compilation-multifile/src",
                    "compilation-source-folder/src",
                    "complete-existing-class-student",
                    "constructors/src",
                    "hello-world",
                    "impl-calculator",
                    "impl-train-with-correlated-fields",
                    "impl-complex-num",
                    "impl-complex-num-calculator",
                    "reference-value/src",
                    "tostring/src"
                )
            )
        }
    }
}

prepareTasksToRunMainMethods(sourceSets["main"], tasks.test)
