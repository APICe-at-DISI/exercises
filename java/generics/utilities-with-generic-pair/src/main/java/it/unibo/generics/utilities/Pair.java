package it.unibo.generics.utilities;

import java.util.Objects;

/**
 * A class used to enclose two objects.
 * 
 * Important note: when creating real projects, it is much, much, much better
 * to rely on widely used libraries than to write tons of boilerplate code
 * yourself (or copy the code we provide you). Good implementations of mutable
 * and immutable pairs are available in Apache Commons Lang, Apache Commons
 * Math, and Jool (joo-lambda by Jooq).
 *
 * @param <X>
 *            type of the first {@link Object}
 * @param <Y>
 *            type of the second {@link Object}
 */
public final class Pair<X, Y> {

    private final X first;
    private final Y second;

    /**
     * @param o1
     *            the first object
     * @param o2
     *            the second object
     */
    public Pair(final X o1, final Y o2) {
        this.first = o1;
        this.second = o2;
    }

    /**
     * @return the first object
     */
    public X getFirst() {
        return this.first;
    }

    /**
     * @return the second object
     */
    public Y getSecond() {
        return this.second;
    }

    /**
     * Returns a string representation of the pair.
     * 
     * @return a string representing this pair's state
     */
    @Override
    public String toString() {
        return "Pair [first=" + first + ", second=" + second + "]";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        /*
         * Library hashing function. Decent, but not particularly good.
         * However, for performance-critical use cases, a good hashing library and algorithm is
         * warmly recommended. For instance, Google Guava provides a number of
         * good and fast hashing algorithms (Murmur 3 is a perfect solution).
         */
        return Objects.hash(first, second);
    }

    /**
     * Compares this pair to the specified object. The result is true if and
     * only if the argument is not null and is a Pair object containing the same
     * pair of object.
     * 
     * @param other the object to compare this pair against
     * 
     * @return true if the given pair is equal to this pair
     */
    @Override
    public boolean equals(final Object other) {
        return this == other
            || other instanceof final Pair<?, ?> otherPair
            && Objects.equals(first, otherPair.first)
            && Objects.equals(second, otherPair.second);
    }
}
