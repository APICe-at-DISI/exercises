package it.unibo.constructors;

class Smartphone {

    static final boolean DEF_HAS_GPS = true;
    static final boolean DEF_HAS_3G = true;
    static final boolean DEF_HAS_NFC = true;
    static final int DEF_SD_SIZE = 8192;
    static final int DEF_RAM_SIZE = 1024;
    static final int DEF_N_CPU = 2;

    int nCPU;
    int ram;
    int sdSize;
    String brand;
    String model;
    boolean hasGPS;
    boolean has3G;
    boolean hasNFC;

    void printStringRep() {
        IO.println("Smartphone info:");
        IO.println("n CPU(s): " + this.nCPU);
        IO.println("RAM amount: " + this.ram);
        IO.println("SD size: " + this.sdSize);
        IO.println("brand: " + this.brand);
        IO.println("model: " + this.model);
        IO.println("hasGPS: " + this.hasGPS);
        IO.println("has3G: " + this.has3G);
        IO.println("hasNFC: " + this.hasNFC + "\n");
    }

    public static void main() {
        // 1) Creare lo smarthpone HTC One sdSize:1024

        // 2) Creare lo smarthpone Samsung Galaxy Note 3 ram:2048 cpu:4
        // sdSize:8192 gps:true nfc:true 3g:true

        // 3) Creare lo smarthpone Apple iPhone 5S nfc:false

        // 4) Creare lo smarthpone Google Nexus 4 gps:true 3g:true

        // 5) Utilizzare il metodo printStringRep per stampare in standard
        // output le informazioni di ciascun telefono
    }
}
