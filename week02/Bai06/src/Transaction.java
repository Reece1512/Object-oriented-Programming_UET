public class Transaction {
    private String transactionId;
    private double amount;
    private String timestamp;

    public Transaction(String transactionId, double amount, String timestamp) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public String getTransactionId(){
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public String getTimestamp() {
        return timestamp;
    }
}

class Account {
    private String accountId;
    private double balance;
    private Transaction[] history;

    public Account(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
        this.history = new Transaction[0];
    }

    public Transaction[] addTransaction(Transaction t) {
        Transaction[] t1 = new Transaction[this.history.length + 1];
        for (int i = 0; i < this.history.length; i++) {
            t1[i] = this.history[i];
        }
        t1[this.history.length] = t;
        this.history = t1;
        return t1;
    }

    public Transaction[] getHistory() {
        Transaction[] t = new Transaction[this.history.length];
        for (int i = 0; i < this.history.length; i++) {
            t[i] = this.history[i];
        }
        return t;
    }

    public static void main(String[] args) {
        Transaction t1 = new Transaction("T01", 10, "12:15:02");
        Transaction t2 = new Transaction("T02", 1000, "23:57:15");
        Account acc = new Account("A01", 50000);
        acc.addTransaction(t1);
        acc.addTransaction(t2);
        Transaction[] his = acc.getHistory();
        his[0] = null;
        his[1] = new Transaction("T02", 99999, "23:57:15");
        for (int i = 0; i < his.length; i++) {
            if (his[i] == null) {
                System.out.println("Phan tu o vi tri " + i+1 + " da bi hack thanh cong");
            } else {
                System.out.println(his[i].getTransactionId());
                System.out.println(his[i].getAmount());
                System.out.println(his[i].getTimestamp());
            }
        }
        System.out.println();
        Transaction[] data = acc.getHistory();
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                System.out.println("Phan tu o vi tri " + i+1 + " da bi hack thanh cong");
            } else {
                System.out.println(data[i].getTransactionId());
                System.out.println(data[i].getAmount());
                System.out.println(data[i].getTimestamp());
            }
        }
    }
}