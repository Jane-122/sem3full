public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Withdrawal amount exceeds current balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal of " + amount + " successful.");
            System.out.println("Remaining balance: " + balance);
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Current Balance: " + balance);
    }
}

public class BankingApplication {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("12345", "John Doe", 5000.00);
        System.out.println("Account Details Before Transaction:");
        account.displayAccountDetails();

        try {
            System.out.println("\nAttempting to withdraw 6000...");
            account.withdraw(6000.00);
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("\nAttempting to withdraw 3000...");
            account.withdraw(3000.00);
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nAccount Details After Transactions:");
        account.displayAccountDetails();
    }
}
