# Test-first

Use the *Test-Driven Development (TDD)* methodology to develop the following.

1. Observe the `DeathNote` interface, understand how it is supposed to work
2. Create an implementation of `DeathNote` in which each method throws an Exception
3. Write a test for the `DeathNote` implementation (the test will fail and that is okay) testing that:
   1. Rule number 0 and negative rules do not exist in the DeathNote rules.
   2. No rule is empty or null in the DeathNote rules.
   3. The human whose name is written in the DeathNote will eventually die.
   4. Only if the cause of death is written within the next 40 milliseconds of writing the person's name, it will happen.
   5. Only if the cause of death is written within the next 6 seconds and 40 milliseconds of writing the death's details, it will happen.

**Important notes**:
* the current time measured as seconds since the Unix epoch is available as `System.currentTimeMillis()`.
* the execution of a program can be paused for a given number of milliseconds using `Thread.sleep(long millis)`.
