package it.unibo.encapsulation.interfaces;

public class SimpleBankAccount implements BankAccount {

    private double balance;
    private int transactions;
    private final int id;

    private static final double ATM_TRANSACTION_FEE = 1;
    private static final double MANAGEMENT_FEE = 5;

    public SimpleBankAccount(final int id, final double balance) {
        this.id = id;
        this.balance = balance;
        this.transactions = 0;
    }

    private void transactionOp(final int id, final double amount) {
        if (checkUser(id)) {
            this.balance += amount;
            this.incTransactions();
        }
    }

    public void deposit(final int id, final double amount) {
        this.transactionOp(id, amount);
    }

    public void withdraw(final int id, final double amount) {
        this.transactionOp(id, -amount);
    }

    public void depositFromATM(final int id, final double amount) {
        this.deposit(id, amount - SimpleBankAccount.ATM_TRANSACTION_FEE);
    }

    public void withdrawFromATM(final int id, final double amount) {
        this.withdraw(id, amount + SimpleBankAccount.ATM_TRANSACTION_FEE);
    }

    private void incTransactions() {
        this.transactions++;
    }

    public void chargeManagementFees(final int id) {
        if (checkUser(id)) {
            this.balance -= SimpleBankAccount.MANAGEMENT_FEE;
        }
    }

    public int getid() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    public int getTransactionsCount() {
        return this.transactions;
    }

    private boolean checkUser(final int id) {
        return this.id == id;
    }
}
