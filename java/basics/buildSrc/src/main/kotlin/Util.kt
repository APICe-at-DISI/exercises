import org.gradle.api.Project
import org.gradle.api.tasks.JavaExec
import org.gradle.api.tasks.SourceSet
import org.gradle.api.tasks.TaskProvider
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.register

/**
 * Build utilities.
 */
object Util {
    /*
     * roughly matches classes with a main method
     */
    private const val mainRegex = "public\\s+static\\s+void\\s+main\\s*\\(String(\\[\\]|\\.\\.\\.)\\s+\\w+\\)\\s*\\{"

    private val main = Regex(mainRegex)

    /*
     * extracts the class names from files with a main method
     */
    private val classFinder = Regex("class\\s+(\\w+)\\s*\\{.*$mainRegex", RegexOption.DOT_MATCHES_ALL)
    private val packageFinder = Regex("(^|\\s+)package (?<package>\\w+(\\.\\w+)*);\\s*")

    /**
     * Scans java files in search of main methods and creates tasks that launch them.
     */
    fun Project.prepareTasksToRunMainMethods(
        sourceSet: SourceSet,
        test: TaskProvider<Test>,
    ) = projectDir.walkTopDown() // For all the directories in this project
        .filter { it.isFile && it.extension == "java" } // find all java files
        .map { it.readText() } // whose text
        .filter { main.find(it) != null } // contains a main method
        .map { source ->
            val classNames = classFinder.findAll(source).toList()
            require(classNames.size == 1)
            val className = classNames.first().destructured.component1()
            val pkg = packageFinder.find(source)?.destructured?.component2()?.plus(".") ?: ""
            "$pkg$className"
        } // and search for the class names
        .forEach { className -> // create a task that launches the main
            val testTask = tasks.register<JavaExec>("run$className") {
                group = "test by plain java launch"
                description = "Runs $className"
                classpath = sourceSet.runtimeClasspath
                mainClass.set(className)
            }
            test.get().dependsOn(testTask)
        }
}
