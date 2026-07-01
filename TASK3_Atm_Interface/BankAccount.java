import java.util.Scanner;

class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {

        if (amount <= balance) {
            balance -= amount;
            return true;
        }

        return false;
    }

    public void deposit(double amount) {
        balance += amount;
    }
}

class ATM {

    private BankAccount account;
    private Scanner sc = new Scanner(System.in);

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void showMenu() {

        int choice;

        do {

            System.out.println("\n==============================");
            System.out.println("        ATM MENU");
            System.out.println("==============================");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    checkBalance();
                    break;

                case 2:
                    System.out.print("Enter Amount to Deposit: ");
                    double deposit = sc.nextDouble();
                    deposit(deposit);
                    break;

                case 3:
                    System.out.print("Enter Amount to Withdraw: ");
                    double withdraw = sc.nextDouble();
                    withdraw(withdraw);
                    break;

                case 4:
                    System.out.println("Thank You for Using ATM.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);
    }

    public void checkBalance() {
        System.out.println("Current Balance : ₹" + account.getBalance());
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid Amount.");
            return;
        }

        account.deposit(amount);

        System.out.println("Deposit Successful.");
        System.out.println("Updated Balance : ₹" + account.getBalance());
    }

    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid Amount.");
            return;
        }

        if (account.withdraw(amount)) {

            System.out.println("Withdrawal Successful.");
            System.out.println("Remaining Balance : ₹" + account.getBalance());

        } else {

            System.out.println("Insufficient Balance.");
        }
    }
}

public class ATMInterface {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(10000);

        ATM atm = new ATM(account);

        atm.showMenu();
    }
}