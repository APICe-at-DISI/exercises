public class Collatz {
    public static void main(String[] args) {
        // 670617279
        var number = args.length > 0 ? Integer.parseInt(args[0]) : 1;
        IO.println("Collatz sequence for " + number + ":");
        while (number != 1) {
            IO.print(number + " -> ");
            if (number % 2 == 0) {
                number /= 2;
            } else {
                // Attempt to generate an overflow by multiplying the number by 3
                // (this may result in overflow for large enough numbers)
                number = number * 3 + 1;
            }
        }
        IO.println("1");
    }
}
