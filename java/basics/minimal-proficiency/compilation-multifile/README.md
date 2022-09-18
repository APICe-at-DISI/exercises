# Compilazione di file multipli in diverse posizioni del filesystem

Obiettivo: comprende come funziona `javac`, i cui file sorgenti (.java) forniti in input al comando potrebbero trovarsi in posizioni diverse del filesystem.

1. Si posizioni il terminale nella directory che contiene `src`
2. Si compilino, con un solo comando, i file `Calculator.java` e `UseCalculator.java` dentro `bin`, tenendo presente che:
    - La classe `Calculator` è stata fornita in un esercizio precedente
    - ATTENZIONE: È proibito spostare i file forniti
    - NOTA: È possibile passare più file a `javac` semplicemente elencandoli
3. Si esegua `UseCalculator`
