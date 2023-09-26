import Util.prepareTasksToRunMainMethods

sourceSets {
    main {
        java {
            setSrcDirs(
                /**
                 * Add a line here if you add an exercise
                 */
                listOf("src")
            )
        }
    }
}

prepareTasksToRunMainMethods(sourceSets["main"], tasks.test)
