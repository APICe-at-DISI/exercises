public class Calculator {

    int nOpDone;
    double lastRes;

    void build() {
        nOpDone = 0;
        lastRes = 0;
    }

    double add(final double n1, final double n2) {
        lastRes = n1 + n2;
        nOpDone++;
        return lastRes;
    }

    double sub(final double n1, final double n2) {
        lastRes = n1 - n2;
        nOpDone++;
        return lastRes;
    }

    double mul(final double n1, final double n2) {
        lastRes = n1 * n2;
        nOpDone++;
        return lastRes;
    }

    double div(final double n1, final double n2) {
        lastRes = n1 / n2;
        nOpDone++;
        return lastRes;
    }

    public static void main() {
        final Calculator calc = new Calculator();
        // Simple sum
        IO.println("1+2=" + calc.add(1, 2));
        IO.println("nOpDone=" + calc.nOpDone);
        IO.println("lastRes=" + calc.lastRes + "\n");
        // Subtraction
        IO.println("-1-(+2)=" + calc.sub(-1, 2));
        IO.println("nOpDone=" + calc.nOpDone);
        IO.println("lastRes=" + calc.lastRes + "\n");
        // Multiplication
        IO.println("6*3=" + calc.mul(6, 3));
        IO.println("nOpDone=" + calc.nOpDone);
        IO.println("lastRes=" + calc.lastRes + "\n");
        // Division
        IO.println("8/4=" + calc.div(8, 4));
        IO.println("nOpDone=" + calc.nOpDone);
        IO.println("lastRes=" + calc.lastRes + "\n");
    }
}
