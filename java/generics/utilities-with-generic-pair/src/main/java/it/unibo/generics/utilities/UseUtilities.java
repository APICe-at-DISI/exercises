package it.unibo.generics.utilities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Simple class to test the {it.unibo.oop.lab05.Utilities} class.
 */
public final class UseUtilities {

    private static final String A = "a";
    private static final String B = "b";
    private static final String C = "c";
    private static final String D = "d";
    private static final String E = "e";

    private UseUtilities() { }

    /**
     * @param s
     *            unused
     */
    public static void main(final String[] s) {
        final var setA = Set.of(A, B, C, D);
        final var setB = Set.of(C, D, E);
        assertEquals(Set.of(A, B, C, D, E), Utilities.union(setA, setB));
        assertEquals(Set.of(C, D), Utilities.intersection(setA, setB));
        assertEquals(Set.of(A, B, E), Utilities.symmetricDifference(setA, setB));
        final var extractedA = new HashSet<String>();
        while (!extractedA.equals(setA)) {
            final var random = Utilities.randomElement(setA);
            assertContains(setA, random);
            extractedA.add(random);
        }
        extractedA.clear();
        final var extractedB = new HashSet<String>();
        while (!(extractedA.equals(setA) && extractedB.equals(setB))) {
            final var randomPair = Utilities.randomPair(setA, setB);
            extractedA.add(randomPair.getFirst());
            extractedB.add(randomPair.getSecond());
            assertContains(setA, randomPair.getFirst());
            assertContains(setB, randomPair.getSecond());
        }
    }

    private static void assertEquals(final Object expected, final Object actual) {
        Objects.requireNonNull(
            Objects.equals(expected, actual) ? new Object() : null,
            "ERROR! Expected " + expected + ", but got " + actual + "!"
        );
        System.out.println("OK: " + expected + " is the same of " + actual); // NOPMD
    }

    private static <T> void assertContains(final Collection<? super T> collection, final T element) {
        Objects.requireNonNull(
            collection.contains(element) ? new Object() : null,
            "ERROR! " + collection + " does not contain " + element + "!"
        );
        System.out.println("OK: " + collection + " contains " + element); // NOPMD
    }
}
