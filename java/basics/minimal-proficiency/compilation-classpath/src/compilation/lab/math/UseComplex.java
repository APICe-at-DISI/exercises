package compilation.lab.math;

public class UseComplex {

    void main() {
        final ComplexNum c1 = new ComplexNum();
        c1.build(1, -45);
        final ComplexNum c2 = new ComplexNum();
        c2.build(2, 8);

        IO.println(c1.toStringRep());
        IO.println(c2.toStringRep());

        c1.add(c2);
        IO.println("c1 new value is: " + c1.toStringRep() + "\n");
    }
}
