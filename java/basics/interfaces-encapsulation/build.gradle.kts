import Util.prepareTasksToRunMainMethods

sourceSets {
    main {
        java {
            setSrcDirs(
                /**
                 * Add a line here if you add an exercise
                 */
                listOf(
                    "implement-interfaces/src",
                    "public-to-private/src",
                )
            )
        }
    }
}

prepareTasksToRunMainMethods(sourceSets["main"], tasks.test)
