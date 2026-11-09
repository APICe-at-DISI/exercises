# Test-first

Utilizzare la metodologia *Test-Driven Development (TDD)* per sviluppare quanto segue.

1. Osservare l'interfaccia `DeathNote` e capire come dovrebbe funzionare
2. Creare un'implementazione di `DeathNote` in cui ogni metodo lancia un'eccezione
3. Scrivere un test per l'implementazione di `DeathNote` (il test fallirà, ed è normale) che verifichi quanto segue:
   1. La regola numero 0 e le regole negative non esistono tra le regole del DeathNote.
      * verificare che le eccezioni vengano lanciate correttamente, che il loro tipo sia quello atteso e che il messaggio non sia null, vuoto o composto solo da spazi.
   2. Nessuna regola del DeathNote è vuota o null.
      * per tutte le regole valide, verificare che nessuna sia null o composta solo da spazi
   3. L'essere umano il cui nome viene scritto nel DeathNote prima o poi morirà.
      * verificare che l'essere umano non sia ancora stato scritto nel quaderno
      * scrivere l'essere umano nel quaderno
      * verificare che l'essere umano sia stato scritto nel quaderno
      * verificare che un altro essere umano non sia stato scritto nel quaderno
      * verificare che la stringa vuota non sia stata scritta nel quaderno
   4. Se la causa della morte viene scritta entro 40 millisecondi dalla scrittura del nome della persona, si verificherà.
   Se la causa della morte non viene specificata, la persona morirà semplicemente di infarto.
      * verificare che scrivere una causa di morte prima di aver scritto un nome lanci l'eccezione corretta
      * scrivere il nome di un essere umano nel quaderno
      * verificare che la causa della morte sia un infarto
      * scrivere il nome di un altro essere umano nel quaderno
      * impostare la causa della morte a "karting accident"
      * verificare che la causa della morte sia stata impostata correttamente (il metodo ha restituito true e la causa è effettivamente "karting accident")
      * attendere 100ms
      * provare a cambiare la causa della morte
      * verificare che la causa della morte non sia stata cambiata
   5. Dopo aver scritto la causa della morte, i dettagli della morte devono essere scritti entro 6 secondi e 40 millisecondi dalla scrittura della causa.
      * verificare che scrivere i dettagli della morte prima di aver scritto un nome lanci l'eccezione corretta
      * scrivere il nome di un essere umano nel quaderno
      * verificare che i dettagli della morte siano attualmente vuoti
      * impostare i dettagli della morte a "ran for too long"
      * verificare che i dettagli della morte siano stati impostati correttamente (il metodo ha restituito true e i dettagli sono effettivamente "ran for too long")
      * scrivere il nome di un altro essere umano nel quaderno
      * attendere 6100ms
      * provare a cambiare i dettagli
      * verificare che i dettagli non siano stati cambiati
4. Chiedere una correzione dei test
5. Verificare che tutti i test falliscano
6. Modificare l'implementazione di `DeathNote` in modo che tutti i test passino

**Note importanti**:
* il tempo corrente, misurato in millisecondi dalla Unix epoch, è disponibile tramite `System.currentTimeMillis()`.
* l'esecuzione di un programma può essere sospesa per un dato numero di millisecondi tramite `Thread.sleep(long millis)`.
