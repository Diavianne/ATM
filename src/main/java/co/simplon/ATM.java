package co.simplon;

import java.util.Scanner;

public class ATM {
    private User currentUser;
    private Bank bank;
    private Scanner scanner;

    public ATM(Bank bank) {
        this.bank = bank;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the ATM!");
        authenticateUser();
        showMenu();
    }

    private void showMenu() {
        int choice;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdrawMoney();
                    break;
                case 3:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    private void withdrawMoney() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        currentUser.withdraw(amount);
    }

    private void checkBalance() {
        System.out.println("Your balance is: " + currentUser.getBalance());
    }


    private void authenticateUser() {
        System.out.print("Enter Card: ");
        String userId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        if (bank.authenticateUser(userId, pin)) {
            currentUser = new User(pin, 1000.0);
            System.out.println("Authentication OK!");
        } else {
            System.out.println("Authentication failed.");
            System.exit(0);
        }
    }
}