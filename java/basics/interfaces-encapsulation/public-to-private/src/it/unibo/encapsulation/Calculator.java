package it.unibo.encapsulation;

public class Calculator {

    int operationsPerformed;
    double lastResult;

    public Calculator() {
        this.operationsPerformed = 0;
        this.lastResult = 0;
    }

    private double updateStatus(final double val) {
        this.lastResult = val;
        this.operationsPerformed++;
        return this.lastResult;
    }

    public double add(final double n1, final double n2) {
        return updateStatus(n1 + n2);
    }

    public double sub(final double n1, final double n2) {
        return updateStatus(n1 - n2);
    }

    public double mul(final double n1, final double n2) {
        return updateStatus(n1 * n2);
    }

    public double div(final double n1, final double n2) {
        return updateStatus(n1 / n2);
    }

    private static void printCalculatorStatus(final Calculator calc) {
        IO.println("operations performed: " + calc.operationsPerformed);
        IO.println("last result" + calc.lastResult + "\n");
    }

    public static void main(final String[] args) {
        final Calculator calc = new Calculator();
        IO.println("1+2=" + calc.add(1, 2));
        printCalculatorStatus(calc);
        IO.println("-1-(+2)=" + calc.sub(-1, 2));
        printCalculatorStatus(calc);
        IO.println("8*3=" + calc.mul(8, 3));
        printCalculatorStatus(calc);
        IO.println("8/4=" + calc.div(8, 4));
        printCalculatorStatus(calc);
    }
}
