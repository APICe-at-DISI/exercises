class CallByValue {

    void increment(int a) {
        a++;
    }

    void main() {
        int x = 1;
        CallByValue cbv = new CallByValue();
        cbv.increment(x);
        IO.println("x=" + x);
    }
}
