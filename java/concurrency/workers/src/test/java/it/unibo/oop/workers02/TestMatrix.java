package it.unibo.oop.workers02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

/**
 * TestMatrix for worker 2.
 */
@SuppressWarnings("PMD.SystemPrintln")
class TestMatrix {

    /*
     * Si fornisce l'interfaccia SumMatrix, con un metodo per calcolare la
     * somma degli elementi di una matrice.
     *
     * Realizzare una classe MultiThreadedSumMatrix, con costrutto che accetta
     * un intero positivo 'n', che implementa tale funzionalità in modo
     * "multi-threaded", con 'n' Worker che si dividano il compito in modo
     * sufficientemente omogeneo -- non è necessario che l'ammontare dei compiti
     * dei singoli Worker siano esattamente equivalenti.
     *
     * Si faccia stampare (su System.out) ad ogni Worker una indicazione di che
     * porzione del lavoro svolge.
     *
     * All'esecuzione del test qui sotto, le chiamate dovranno dare lo stesso
     * output, ad eccezione ovviamente dei tempi.
     */

    private static final int SIZE = 1_000;
    private static final double EXPECTED_DELTA = 0.01;
    private static final String MSEC = " msec";

    /**
     * Base test for a multithreaded matrix sum.
     */
    @Test
    void testBasic() {
        double sum = 0;
        final double[][] matrix = new double[SIZE][SIZE];
        for (final double[] d : matrix) {
            for (int i = 0; i < SIZE; i++) {
                d[i] = i;
                sum += i;
            }
        }
        System.out.println("BTW: the sum with " + SIZE + "*" + SIZE + " elements is: " + sum);
        long time;
        for (final int threads : new int[] {1, 2, 3, 8, 16, 32, 100}) {
            final SumMatrix sumList = new MultiThreadedSumMatrixWithFutures(threads);
            // final SumMatrix sumList = new MultiThreadedSumMatrixWithStreams(threads);
            // final SumMatrix sumList = new MultiThreadedSumMatrixClassic(threads);
            time = System.nanoTime();
            assertEquals(sum, sumList.sum(matrix), EXPECTED_DELTA);
            time = System.nanoTime() - time;
            System.out.println("Tried with " + threads + " thread"
                    + (threads == 1 ? "" : "s") + ": "
                    + TimeUnit.NANOSECONDS.toMillis(time) + MSEC);
        }
    }

}
