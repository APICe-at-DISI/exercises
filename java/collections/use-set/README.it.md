# Uso di `Collection` e `Set`

### Passo 0: leggere un esempio

Leggere ed eseguire la classe `it.unibo.collections.UseCollection`: è già completa e mostra le operazioni principali di `Collection`
(`add`, `addAll`, `remove`, `removeAll`, `retainAll`, `contains`).
Ogni `assertContentEqualsInAnyOrder` controlla se il contenuto della collezione è quello atteso.

Rispondere alle seguenti domande:

* Dopo le due chiamate `coll.add(15)`, quante volte compare `15` nella collezione? Perché?
* `coll.remove(7)` rimuove l'elemento `7` o l'elemento in posizione `7`? Perché?
* Se `coll` fosse dichiarata con `var` invece che con `Collection<Integer>`, che tipo avrebbe?

### Passo 1: usare un `Set`

Completare il metodo `main` della classe `it.unibo.collections.sets.UseSet` seguendo i passi indicati nei commenti:

1. Creare un `Set` di `String`.
   **Nota**: il commento chiede un `TreeSet`, che vedremo più avanti; usare invece un `LinkedHashSet`.
   Ricordarsi di dichiarare la variabile con l'interfaccia (`Set<String>`) e non con la classe concreta.
2. Inserire nel set tutte le stringhe che rappresentano i numeri da `"1"` a `"20"` (estremi inclusi).
3. Stampare il contenuto del set.
4. Rimuovere tutte le stringhe che rappresentano un numero divisibile per tre.
   Il metodo `removeIf` **non** è ammesso: usare esplicitamente un `Iterator` (`hasNext()`, `next()`, `remove()`).
   Per convertire una stringa in un numero si può usare `Integer.parseInt(String)`.
5. Stampare il contenuto del set usando un ciclo *for-each*.
6. Verificare se tutti i numeri rimasti nel set sono pari, e stampare il risultato.
   Suggerimento: scrivere un metodo di supporto che accetti una `Collection<String>`.

Rispondere alle seguenti domande:

* Cosa succede se si prova ad aggiungere al set una stringa già presente (ad esempio `"5"`)? Cosa cambia rispetto a `UseCollection`?
* Perché al punto 4 serve l'`Iterator`, e non si può semplicemente usare un ciclo *for-each*?
