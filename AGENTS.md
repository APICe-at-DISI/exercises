# Repository instructions

This repository is a collection of exercises with a distribution system that can create repositories or
zip files, both delivered via GitHub.

The `master` branch contains solved exercises.
The `exercises` branch starts from `master` and removes the solutions.

## Branch workflow
- Always develop and solve exercises on `master`. `exercises` is kept in sync automatically by
  `.github/workflows/branch-synch.yml` after every push to `master` — never push solution code directly to
  `exercises`.
- To turn a solution into an exercise: commit *only the instructions* on `master` and push, then `git stash`
  the remaining solution edits. Once the sync workflow copies the instructions to `exercises`, check it out,
  pull, `git stash pop`, and commit/push the now-de-solved exercise there. See `README.md` for the full
  walkthrough.
- Preserve the existing exercise structure and instructional wording. Keep changes small and scoped to the
  requested exercise.

## Adding or moving exercises
- Each exercise is its own standalone Gradle project (own `gradlew`, `build.gradle.kts`,
  `settings.gradle.kts`) under `java/<category>/<exercise>`. There is no root Gradle build — reuse the
  templates in `gradle-buildfiles/` when scaffolding a new one instead of hand-writing the QA plugin setup.
- A new exercise (or a new top-level category under `java/`) must be registered in `tests.main.kts`, or CI
  will silently skip building/testing it.
- If the exercise should ship as part of a course, also add an entry under the relevant lab in `config.yml`
  (content entries are applied in order; later entries win over earlier ones for the same destination path).

## Code conventions
- Use Java 25 APIs when the repository already targets them. Prefer the implicitly available
  `java.lang.IO.println` over the legacy standard-output API.
- Use compact source files only for standalone examples where the class wrapper is not part of the
  exercise; retain explicit classes for exercises that teach classes, packages, compilation, or reuse.
- Treat warning suppressions (checkstyle/PMD/SpotBugs, enforced via the `org.danilopianini.gradle-java-qa`
  plugin) as a last resort. If one is necessary, add a nearby comment explaining why.

## Verification
- Run `./tests.main.kts` (from the repo root) after Java changes, on the branch you're actually working on —
  its behavior differs by branch (e.g. it skips executing tests on `exercises`, since solutions are removed
  there).
- To iterate on a single exercise, `cd` into its directory and use its own `./gradlew`. If Gradle
  configuration or Kotlin build logic changes there, run `./gradlew ktlintFormat` when available and finish
  with `./gradlew build`.
- Do not commit, push, or alter unrelated user changes unless explicitly requested.
