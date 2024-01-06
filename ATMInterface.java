import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    public void displayMenu() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void performTransaction(int option) {
        Scanner scanner = new Scanner(System.in);

        switch (option) {
            case 1:
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmount = scanner.nextDouble();
                if (userAccount.withdraw(withdrawAmount)) {
                    System.out.println("Withdrawal successful. Remaining balance: " + userAccount.getBalance());
                } else {
                    System.out.println("Insufficient funds or invalid amount for withdrawal.");
                }
                break;

            case 2:
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                userAccount.deposit(depositAmount);
                System.out.println("Deposit successful. Updated balance: " + userAccount.getBalance());
                break;

            case 3:
                System.out.println("Current balance: " + userAccount.getBalance());
                break;

            case 4:
                System.out.println("Thank you for using this ATM!");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);

        while (true) {
            atm.displayMenu();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            atm.performTransaction(choice);
 }
}
}