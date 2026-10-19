# Progettazione con classi astratte

Creare da zero una `abstract class AbstractBankAccount implements BankAccount`:

* Deve contenere tutti gli elementi comuni a tutte le implementazioni di `BankAccount`
* Tutti i campi **devono** essere `private`
* La classe deve esporre come `public` tutti i metodi di `BankAccount`, e solo quelli
* La classe deve definire un metodo `protected abstract` `boolean isWithdrawAllowed(double)`, che restituisce `true` se è possibile prelevare dal conto la somma passata come parametro.
* La classe deve definire un metodo `protected abstract` `double computeFees()`, che restituisce l'importo corrente delle spese di gestione (non modifica lo stato di `AbstractBankAccount`).

Creare da zero una classe `ClassicBankAccount extends AbstractBankAccount`, con lo stesso comportamento di `SimpleBankAccount`.

Creare da zero una classe `RestrictedBankAccount extends AbstractBankAccount`, con lo stesso comportamento di `StrictBankAccount`.

Rispondere alla seguente domanda:

Secondo voi, questa soluzione è migliore o peggiore di quella ottenuta in precedenza? Perché?
