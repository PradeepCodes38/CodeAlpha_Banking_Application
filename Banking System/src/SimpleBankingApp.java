
import java.util.Scanner;

public class SimpleBankingApp {
    // Variables to store account balance and account holder's name
    private double balance;
    private String accountHolderName;

    // Constructor
    public SimpleBankingApp(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! New balance: ₹" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful! New balance: ₹" + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("Current balance: ₹" + balance);
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get account holder's name and initial deposit
        System.out.println("Welcome to the Simple Banking App!");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter an initial deposit amount: ");
        double initialDeposit = scanner.nextDouble();

        // Create a new account
        SimpleBankingApp account = new SimpleBankingApp(name, initialDeposit);

        // Display menu
        int choice;
        do {
            System.out.println("\nBanking Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the Banking App. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
