package Chapter10_Threads.Synchronizing_Code;

public class BankAccountExample implements Runnable {
    private Account acct = new Account();
    public static void main(String[] args) {
        BankAccountExample r = new BankAccountExample();
        Thread one = new Thread(r);
        Thread two = new Thread(r);
        one.setName("Fred");
        two.setName("Lucy");
        one.start();
        two.start();
    }
    public void run() {
        for(int x = 0; x < 5; x++) {
            makeWithdrawal(10);
            if (acct.getBalance() < 0) {
                System.out.println("account is overdrawn!");
            }
        }
    }
    private void makeWithdrawal(int amt) {
        if (acct.getBalance() >= amt) {
            System.out.println(Thread.currentThread().getName() + " is going to withdraw");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {}
            acct.withdraw(amt);
            System.out.println(Thread.currentThread().getName() + " completes the withdrawal");
        } else {
            System.out.println("Not enough in account for " + Thread.currentThread().getName() + " to withdraw "
            + acct.getBalance());
        }
    }
}

class Account {
    private int balance = 50;
    public int getBalance(){
        return balance;
    }
    public void withdraw(int amount) {
        balance = balance - amount;
    }
}

// Produced for me:

//Lucy completes the withdrawal
//Lucy is going to withdraw
//Fred is going to withdraw
//Lucy completes the withdrawal
//account is overdrawn!
//Fred completes the withdrawal
//account is overdrawn!
//Not enough in account for Lucy to withdraw -10
//account is overdrawn!
//Not enough in account for Lucy to withdraw -10
//account is overdrawn!
//Not enough in account for Fred to withdraw -10
//account is overdrawn!
//Not enough in account for Fred to withdraw -10
//account is overdrawn!
