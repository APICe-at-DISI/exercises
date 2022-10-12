# Unified exercise management

This repository is meant to facilitate the development and maintenance of courses which:
* May change year-to-year
* May share some exercises

The idea is to manage all the exercises in a single place,
and have them deployed to the target repository of each course.

## How-to

### Add a new exercise

#### Phase 1: design a program

The initial development happens on the `master` branch, which contains the solutions.

**Make sure you are on the `master` branch!**

``git branch | grep '*'``

Develop your exercise *as a solution*.
When you are satisfied, commit and push.

#### Phase 2: design an exercise

Now, prepare the exercise.
Write the instructions and modify the code as you see fit.
Then, *only commit the instructions*, and push.
Once done, run `git stash`. Your edits will disappear from the worktree,
but that is okay (they are safe in the stash).

#### Phase 3: design an exercise

In a few seconds after the push, you should find a copy of your solution in the remote branch `exercises` on `origin`.
Remotely, there is in fact [a workflow](.github/workflows/branch-synch.yml) which keeps the branches syncronized.
Checkout the exercises branch:

``git checkout exercises``

pull from `origin/exercises`:

``git pull --rebase=true origin exercises``

(note: with a sane configuration of git `git pull` should suffice)

You should now see your exercise copied from `master` if you do not, there are two cases,
and you can figure out which one it is by taking a look at the [dashboard](https://github.com/APICe-at-DISI/exercises/actions):
1. The pipeline is not finished yet. Just wait until it's finished and then pull again.
2. The pipeline failed. In this case, run `git merge master`, fix the merge conflicts, and then push.

Either way, at this point you have your solution on exercises with instructions,
and it is just a matter of adding the changes to make your solution an exercise;
but you did that already! It's just matter of.

``git stash pop``

Fix any conflict that may arise (though none should),
then commit, and push to exercises.

### Modify an existing solution

Edit the solution on `master`, then commit and push.

### Modify an existing exercise's instructions file

Edit the instructions on `master`, then commit and push.

### Modify the structure of an exercise

1. Edit the instructions and the exercise on `master`
2. Commit *only the instructions*, push, and stash the remainder of the changes
3. Checkout `exercises`
4. `git pull` until you have the new instructions
5. `git stash pop`
6. Commit and push

### Prepare a new lab

A lab is a collection of exercises that is deployed with two zip files
(one for the exercises, one for the solution)
or as a repository (with a branch `exercises` and a branch `solutions`)

The labs are configured in [`config.yml`](config.yml).

