package it.unibo.es2;

public interface Logics {
    
    boolean hit(int row, int col);
    
    boolean isAnyRowFull();
    
    boolean isAnyColumnFull();
}
