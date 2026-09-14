# Repository instructions

- Preserve the existing exercise structure and instructional wording. Keep changes small and scoped to the requested exercise.
- Use Java 25 APIs when the repository already targets them. Prefer the implicitly available `java.lang.IO.println` over the legacy standard-output API.
- Use compact source files only for standalone examples where the class wrapper is not part of the exercise; retain explicit classes for exercises that teach classes, packages, compilation, or reuse.
- Treat warning suppressions as a last resort. If one is necessary, add a nearby comment explaining why.
- Run `./tests.main.kts` after Java changes.
- Do not commit, push, or alter unrelated user changes unless explicitly requested.
