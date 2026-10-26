# Implementare un'interfaccia generica: `Graph<N>`

Osservare l'interfaccia generica `it.unibo.generics.graph.api.Graph<N>`: modella un grafo orientato i cui nodi sono di tipo `N`.
Leggere con attenzione la documentazione di ogni metodo.

## Parte 1: archi e grafo

1. Nel package `it.unibo.generics.graph.impl`, creare una classe generica `Edge<N>` che rappresenti un arco del grafo:
   * contiene un nodo sorgente e un nodo destinazione, entrambi di tipo `N`
   * i campi sono `private final`, e vengono inizializzati dal costruttore
   * espone due metodi getter, `getSource()` e `getTarget()`

   Prendere spunto dalla classe generica `Pair<X, Y>` vista a lezione.
2. Nello stesso package, creare una classe `GraphImpl<N> implements Graph<N>` che memorizzi:
   * i nodi in un `Set<N>`
   * gli archi in una `List<Edge<N>>`
3. Implementare i metodi:
   * `addNode`: aggiunge il nodo; non succede nulla se è `null`
   * `addEdge`: aggiunge l'arco; non succede nulla se `source` o `target` sono `null`, o se non sono nodi del grafo
   * `nodeSet`: restituisce l'insieme dei nodi. Restituire una *copia* del `Set` interno, per non esporre lo stato dell'oggetto
   * `linkedNodes`: restituisce l'insieme dei nodi raggiunti da un arco che parte dal nodo dato.
     Scorrere la lista degli archi con un for-each, e confrontare i nodi con `equals`
   * `getPath`: per ora restituire una lista vuota (vedi Parte 2)
4. In `it.unibo.generics.graph.UseGraph`, sostituire `testGraph(null)` con `testGraph(new GraphImpl<>())` ed eseguire `UseGraph`.
   I controlli su `nodeSet` e `linkedNodes` devono passare.
   L'ultimo controllo riguarda `getPath`: finché non svolgete la Parte 2, è normale che fallisca.

## Parte 2 (facoltativa): cercare un percorso

Implementare `getPath(source, target)`, che restituisce una sequenza di nodi che collega `source` a `target`
(o una lista vuota, se non esiste).

Suggerimento: usare una *visita in ampiezza*, tenendo una lista di percorsi da esplorare (`List<List<N>>`) e un `Set<N>` dei nodi già visitati.

1. All'inizio, la lista contiene un solo percorso: `[source]`
2. Finché la lista non è vuota, rimuoverne il primo percorso e guardarne l'ultimo nodo:
   * se è `target`, il percorso trovato è la risposta
   * altrimenti, se il nodo non è già stato visitato, segnarlo come visitato e, per ognuno dei suoi `linkedNodes`,
     aggiungere in fondo alla lista una *copia* del percorso con quel nodo in coda
3. Se la lista si svuota senza trovare `target`, non esiste alcun percorso

Eseguire di nuovo `UseGraph`: ora tutti i controlli devono passare.
