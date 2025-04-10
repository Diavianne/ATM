package co.simplon;

public class User {
    private String pin;
    private double balance;


    public User(String pin, double balance) {
        this.pin = pin;
        this.balance = balance;
    }

    public boolean validatePin(String inputPin) {
        return this.pin.equals(inputPin);
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal ok. Remaining balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}
