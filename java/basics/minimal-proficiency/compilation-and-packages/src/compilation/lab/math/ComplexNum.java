package compilation.lab.math;

class ComplexNum {

    double re;
    double im;

    void build(final double re, final double im) {
        this.re = re;
        this.im = im;
    }

    boolean isEqualTo(final ComplexNum num) {
        return re == num.re && im == num.im;
    }

    void add(final ComplexNum num) {
        re += num.re;
        im += num.im;
    }

    String toStringRep() {
        return re + (im > 0 ? "+" : "") + im + "i";
    }

    public static void main() {
        final ComplexNum c1 = new ComplexNum();
        c1.build(3, 5);
        final ComplexNum c2 = new ComplexNum();
        c2.build(7, -4);
        final ComplexNum c3 = new ComplexNum();
        c3.build(-2, 3);
        final ComplexNum c4 = new ComplexNum();
        c4.build(-2, 3);
        IO.println(c1.toStringRep());
        IO.println(c2.toStringRep());
        IO.println(c3.toStringRep());
        IO.println(c4.toStringRep() + "\n");
        c1.add(c2);
        c2.add(c4);
        IO.println(c1.toStringRep());
        IO.println(c2.toStringRep());
        IO.println(c3.toStringRep());
        IO.println(c4.toStringRep() + "\n");
        IO.println(c3.isEqualTo(c1));
        IO.println(c3.isEqualTo(c2));
        IO.println(c3.isEqualTo(c4));
    }
}
