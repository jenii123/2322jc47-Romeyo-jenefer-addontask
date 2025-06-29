package Main task;

public class BankApp {

    public static void main(String[] args) {
        BankAccount account = new BankAccount("Shared Account", 1000);

        // Creating multiple users trying to withdraw from the same account
        Thread user1 = new Thread(new WithdrawTask(account, 300), "User-A");
        Thread user2 = new Thread(new WithdrawTask(account, 400), "User-B");
        Thread user3 = new Thread(new WithdrawTask(account, 500), "User-C");

        user1.start();
        user2.start();
        user3.start();
    }
}

// BankAccount class with synchronized withdraw method
class BankAccount {
    private String accountName;
    private int balance;

    public BankAccount(String accountName, int balance) {
        this.accountName = accountName;
        this.balance = balance;
    }

    public synchronized void withdraw(int amount) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " is attempting to withdraw Rs." + amount);

        if (balance >= amount) {
            try {
                Thread.sleep(1000); // Simulate delay
            } catch (InterruptedException e) {
                System.out.println(threadName + " was interrupted.");
            }

            balance -= amount;
            System.out.println(threadName + " successfully withdrew Rs." + amount + ". Remaining balance: Rs." + balance);
        } else {
            System.out.println(threadName + " failed to withdraw Rs." + amount + " due to insufficient balance. Remaining balance: Rs." + balance);
        }
    }
}

// WithdrawTask class to be run by each thread
class WithdrawTask implements Runnable {
    private BankAccount account;
    private int amount;

    public WithdrawTask(BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(amount);
    }
}
