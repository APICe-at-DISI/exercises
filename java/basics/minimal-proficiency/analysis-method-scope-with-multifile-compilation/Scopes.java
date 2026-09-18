class Scopes {
    int a;
    int b;

    void build(int a, int b) {
        this.a = a;
        this.b = b;
        IO.println("[build method:] I can access the field a (" + this.a + "),");
        IO.println(" the field b (" + this.b + "),");
        IO.println(" the input parameter a (" + a + ")");
        IO.println(" and the input parameter b (" + b + ").");
    }

    void dummyMethod(int c) {
        IO.println("[dummyMethod:] I can access the field a (" + this.a + "),");
        IO.println(" the field b (" + this.b + ")");
        IO.println(" and the input parameter c (" + c + ").");
    }

    void dummyMethod2(int a) {
        int b = 0;
        IO.println("[dummyMethod2:] I can access the field a (" + this.a + "),");
        IO.println(" the field b (" + this.b + "),");
        IO.println(" the input parameter a (" + a + "),");
        IO.println(" and the local variable b (" + b + ").");
        IO.println("I have no access to c, dummyMethod's input parameter.");
    }
}
