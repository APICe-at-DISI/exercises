# INSTRUCTIONS

1. Implement the `IterableWithPolicy<T>` interface via a generic class that accepts two constructors (`constructor(T[])` and `constructor(T[], Predicate<T>)`):
    1. The first constructor takes only **one** parameter which is the array of elements to iterate over. When this constructor is used, all the elements must be iterated.
    2. The second constructor takes **two** parameters: `T[]` the array to iterate over and a [`Predicate`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/Predicate.html) that will be used to skip all the elements of the array that do not match the given predicate.
2. The method `setIterationPolicy(Predicate<T>)` must be implemented in such a way that it allows to change the iteration policy. The iteration policy is represented by the `Predicate` that is used to filter the elements of the array that do not match the given predicate.
3. Implement the `iterator()` method in such a way that it returns an instance of the `Iterator` interface that iterates over the elements of the array that match the iteration policy. (Hint: use an inner class)
