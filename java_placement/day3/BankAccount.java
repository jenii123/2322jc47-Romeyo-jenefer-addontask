package day3;

public class BankAccount {
    private String accountHolder;
    private double balance;

    
    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid or insufficient funds for withdrawal.");
        }
    }

    
    public void displayBalance() {
        System.out.println("Current balance: " + balance);
    }

    
    public static void main(String[] args) {
        BankAccount account = new BankAccount("John Doe", 1000.0);
        account.displayBalance();

        account.deposit(500.0);
        account.displayBalance();

        account.withdraw(200.0);
        account.displayBalance();

        account.withdraw(2000.0); 
    }
}
