import java.util.Scanner;

class ATM {
    private double balance;
    private final int PIN;

    public ATM(double initialBalance, int userPIN) {
        this.balance = initialBalance;
        this.PIN = userPIN;
    }

    public boolean authenticate(int enteredPIN) {
        return this.PIN == enteredPIN;
    }

    public void checkBalance() {
        System.out.printf("Your current balance is: ₹%.2f%n", balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        }
    }
}

public class ATMSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Set initial balance and PIN
        ATM userATM = new ATM(10000.00, 1234);

        System.out.print("Welcome to the ATM.\nPlease enter your 4-digit PIN: ");
        int enteredPIN = scanner.nextInt();

        if (!userATM.authenticate(enteredPIN)) {
            System.out.println("Invalid PIN. Access denied.");
            return;
        }

        while (true) {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    userATM.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    userATM.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    userATM.withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}