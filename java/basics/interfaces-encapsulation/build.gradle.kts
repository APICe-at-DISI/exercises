import Util.prepareTasksToRunMainMethods

sourceSets {
    main {
        java {
            setSrcDirs(
                /**
                 * Add a line here if you add an exercise
                 */
                listOf(
                    "from-scratch/src",
                    "implement-interfaces/src",
                    "interface-composition/src",
                    "public-to-private/src",
                )
            )
        }
    }
}

prepareTasksToRunMainMethods(sourceSets["main"], tasks.test)
