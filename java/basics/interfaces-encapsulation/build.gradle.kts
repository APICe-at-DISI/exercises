import Util.prepareTasksToRunMainMethods

sourceSets {
    main {
        java {
            setSrcDirs(
                /**
                 * Add a line here if you add an exercise
                 */
                listOf(
                    "public-to-private/src"
                )
            )
        }
    }
}

prepareTasksToRunMainMethods(sourceSets["main"], tasks.test)
