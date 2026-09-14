class TestCalculator {
  public static void main(String[] args) {

      IO.println("--- Test Calculator V1 ---\n");

      CalculatorV1 calc1 = new CalculatorV1();
      calc1.build();
      
      IO.println("1+2=" + calc1.add(1, 2));
      IO.println("-1-(+2)=" + calc1.sub(-1, 2));
      IO.println("6*3=" + calc1.mul(6, 3));
      IO.println("8/4=" + calc1.div(8, 4));

      IO.println("\n--- Test Calculator V2 ---\n");

      CalculatorV2 calc2 = new CalculatorV2();
      calc2.build();

      IO.println("1+2=" + calc2.add(1, 2));
      IO.println("nOpDone=" + calc2.nOpDone);
      IO.println("lastRes=" + calc2.lastRes + "\n");

      IO.println("-1-(+2)=" + calc2.sub(-1, 2));
      IO.println("nOpDone=" + calc2.nOpDone);
      IO.println("lastRes=" + calc2.lastRes + "\n");

      IO.println("6*3=" + calc2.mul(6, 3));
      IO.println("nOpDone=" + calc2.nOpDone);
      IO.println("lastRes=" + calc2.lastRes + "\n");

      IO.println("8/4=" + calc2.div(8, 4));
      IO.println("nOpDone=" + calc2.nOpDone);
      IO.println("lastRes=" + calc2.lastRes + "\n");
  }
}
