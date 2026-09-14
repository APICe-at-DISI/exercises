class CallByValue {

    void increment(int a) {
        a++;
    }

    public static void main(final String[] args) {
        int x = 1;
        CallByValue cbv = new CallByValue();
        cbv.increment(x);
        IO.println("x=" + x);
    }
}
