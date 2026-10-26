# Metodi generici: `Utilities`

Osservare la classe generica `it.unibo.generics.utilities.Pair<X, Y>`: è già completa e non va modificata.

La classe `it.unibo.generics.utilities.Utilities` contiene alcuni metodi `static` generici, di cui sono già fornite le firme e la documentazione.
Implementarli tutti, **senza cambiarne le firme**:

* `union(setA, setB)`: restituisce un *nuovo* `Set` con tutti gli elementi presenti in almeno uno dei due insiemi
* `intersection(setA, setB)`: restituisce un *nuovo* `Set` con gli elementi presenti in entrambi gli insiemi
* `symmetricDifference(setA, setB)`: restituisce un *nuovo* `Set` con gli elementi presenti in uno solo dei due insiemi.
  Suggerimento: si può ottenere riusando `union` e `intersection`
* `randomElement(coll)`: restituisce un elemento a caso della collezione.
  Una `Collection` non permette l'accesso per posizione: scegliere una posizione a caso con il `RANDOM_GENERATOR` già presente nella classe, e scorrere la collezione con un for-each fino a raggiungerla
* `randomPair(first, second)`: restituisce un `Pair` formato da un elemento a caso della prima collezione e uno a caso della seconda

Note:

* I `Set` ricevuti come parametri non vanno modificati: potrebbero anche essere immutabili, come quelli creati con `Set.of(...)`
* Per i nuovi `Set` si può usare un'implementazione a scelta, ad esempio `LinkedHashSet`

Eseguire `it.unibo.generics.utilities.UseUtilities` per verificare l'implementazione: ogni controllo superato stampa `OK`, il primo controllo fallito interrompe il programma con un messaggio di errore.
Se il programma non termina, controllare che `randomElement` possa restituire *tutti* gli elementi della collezione.

Rispondere alla seguente domanda:

Perché i parametri di `union`, `intersection` e `symmetricDifference` sono di tipo `Set<? extends X>` e non semplicemente `Set<X>`? Quali chiamate non sarebbero possibili con `Set<X>`?
