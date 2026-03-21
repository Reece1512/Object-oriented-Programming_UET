public class BankAccount {
    private String accountNumber;
    private double balance;
    private String ownerName;

    public BankAccount(String accNumber, String owner) {
        this.accountNumber = accNumber;
        this.ownerName = owner;
        this.balance = 0;
    }

    public BankAccount(String accNumber, String owner, double balance) {
        this.accountNumber = accNumber;
        this.ownerName = owner;
        if (balance < 0) {
            System.out.println("Error");
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    public void deposit(double amount) {
        if (amount < 0) {
            amount = 0;
        }
        this.balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return this.balance;
    }

    public static void main(String[] args) {
        BankAccount myacc = new BankAccount("08032026", "Ronaldo", 0);
        myacc.deposit(100.0);
        myacc.deposit(-50.00);
        System.out.println(myacc.withdraw(30.00));
        System.out.println(myacc.withdraw(150.0));
        System.out.println(myacc.getBalance());
    }
}
