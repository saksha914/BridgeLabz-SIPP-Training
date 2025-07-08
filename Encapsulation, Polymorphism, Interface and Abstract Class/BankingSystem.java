// Banking System
// Demonstrates: Abstract Classes, Interfaces, Encapsulation, Polymorphism

// Interface for Loanable accounts
interface Loanable {
    boolean applyForLoan(double amount);
    double calculateLoanEligibility();
}

// Abstract class BankAccount with encapsulation
abstract class BankAccount {
    // Private fields - Encapsulation
    private String accountNumber;
    private String holderName;
    private double balance;
    private String accountType;
    private boolean isActive;
    
    // Constructor
    public BankAccount(String accountNumber, String holderName, double initialBalance, String accountType) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
        this.accountType = accountType;
        this.isActive = true;
    }
    
    // Getter methods - Encapsulation
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getHolderName() {
        return holderName;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public String getAccountType() {
        return accountType;
    }
    
    public boolean isActive() {
        return isActive;
    }
    
    // Setter methods with validation - Encapsulation
    public void setAccountNumber(String accountNumber) {
        if (accountNumber != null && !accountNumber.trim().isEmpty()) {
            this.accountNumber = accountNumber;
        } else {
            System.out.println("Account number cannot be empty");
        }
    }
    
    public void setHolderName(String holderName) {
        if (holderName != null && !holderName.trim().isEmpty()) {
            this.holderName = holderName;
        } else {
            System.out.println("Holder name cannot be empty");
        }
    }
    
    protected void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Balance cannot be negative");
        }
    }
    
    public void setAccountType(String accountType) {
        if (accountType != null && !accountType.trim().isEmpty()) {
            this.accountType = accountType;
        } else {
            System.out.println("Account type cannot be empty");
        }
    }
    
    public void setActive(boolean active) {
        this.isActive = active;
    }
    
    // Concrete methods - shared implementation
    public void deposit(double amount) {
        if (amount > 0 && isActive) {
            setBalance(getBalance() + amount);
            System.out.println("Deposited: $" + amount + " | New Balance: $" + getBalance());
        } else {
            System.out.println("Invalid deposit amount or account inactive");
        }
    }
    
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= getBalance() && isActive) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawn: $" + amount + " | New Balance: $" + getBalance());
            return true;
        } else {
            System.out.println("Invalid withdrawal amount, insufficient funds, or account inactive");
            return false;
        }
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract double calculateInterest();
    
    // Concrete method - shared implementation
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: $" + balance);
        System.out.println("Status: " + (isActive ? "Active" : "Inactive"));
        System.out.println("Interest Rate: " + calculateInterest() + "%");
    }
}

// SavingsAccount class extending BankAccount
class SavingsAccount extends BankAccount implements Loanable {
    private double minimumBalance;
    private static final double INTEREST_RATE = 4.5; // 4.5% annual interest
    private static final double LOAN_ELIGIBILITY_MULTIPLIER = 3.0; // 3x balance
    
    public SavingsAccount(String accountNumber, String holderName, double initialBalance) {
        super(accountNumber, holderName, initialBalance, "Savings");
        this.minimumBalance = 1000.0; // Minimum balance requirement
    }
    
    // Getter and setter methods
    public double getMinimumBalance() {
        return minimumBalance;
    }
    
    public void setMinimumBalance(double minimumBalance) {
        if (minimumBalance >= 0) {
            this.minimumBalance = minimumBalance;
        } else {
            System.out.println("Minimum balance cannot be negative");
        }
    }
    
    // Override withdraw method to check minimum balance
    @Override
    public boolean withdraw(double amount) {
        if (getBalance() - amount >= minimumBalance) {
            return super.withdraw(amount);
        } else {
            System.out.println("Withdrawal would violate minimum balance requirement");
            return false;
        }
    }
    
    // Implementation of abstract method
    @Override
    public double calculateInterest() {
        return INTEREST_RATE;
    }
    
    // Implementation of Loanable interface methods
    @Override
    public boolean applyForLoan(double amount) {
        if (amount <= calculateLoanEligibility() && getBalance() >= minimumBalance) {
            System.out.println("Loan application approved for: $" + amount);
            return true;
        } else {
            System.out.println("Loan application denied. Insufficient eligibility or balance");
            return false;
        }
    }
    
    @Override
    public double calculateLoanEligibility() {
        return getBalance() * LOAN_ELIGIBILITY_MULTIPLIER;
    }
    
    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Minimum Balance: $" + minimumBalance);
        System.out.println("Loan Eligibility: $" + calculateLoanEligibility());
        System.out.println("------------------------");
    }
}

// CurrentAccount class extending BankAccount
class CurrentAccount extends BankAccount implements Loanable {
    private double overdraftLimit;
    private static final double INTEREST_RATE = 1.5; // 1.5% annual interest
    private static final double LOAN_ELIGIBILITY_MULTIPLIER = 5.0; // 5x balance
    
    public CurrentAccount(String accountNumber, String holderName, double initialBalance) {
        super(accountNumber, holderName, initialBalance, "Current");
        this.overdraftLimit = 5000.0; // Overdraft limit
    }
    
    // Getter and setter methods
    public double getOverdraftLimit() {
        return overdraftLimit;
    }
    
    public void setOverdraftLimit(double overdraftLimit) {
        if (overdraftLimit >= 0) {
            this.overdraftLimit = overdraftLimit;
        } else {
            System.out.println("Overdraft limit cannot be negative");
        }
    }
    
    // Override withdraw method to allow overdraft
    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && getBalance() - amount >= -overdraftLimit && isActive()) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawn: $" + amount + " | New Balance: $" + getBalance());
            if (getBalance() < 0) {
                System.out.println("Overdraft used: $" + Math.abs(getBalance()));
            }
            return true;
        } else {
            System.out.println("Invalid withdrawal amount or exceeds overdraft limit");
            return false;
        }
    }
    
    // Implementation of abstract method
    @Override
    public double calculateInterest() {
        return INTEREST_RATE;
    }
    
    // Implementation of Loanable interface methods
    @Override
    public boolean applyForLoan(double amount) {
        if (amount <= calculateLoanEligibility()) {
            System.out.println("Loan application approved for: $" + amount);
            return true;
        } else {
            System.out.println("Loan application denied. Insufficient eligibility");
            return false;
        }
    }
    
    @Override
    public double calculateLoanEligibility() {
        return getBalance() * LOAN_ELIGIBILITY_MULTIPLIER;
    }
    
    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Overdraft Limit: $" + overdraftLimit);
        System.out.println("Loan Eligibility: $" + calculateLoanEligibility());
        System.out.println("------------------------");
    }
}

// Main class to demonstrate the system
public class BankingSystem {
    public static void main(String[] args) {
        System.out.println("=== Banking System ===\n");
        
        // Creating accounts
        SavingsAccount savings = new SavingsAccount("SA001", "John Doe", 5000.0);
        CurrentAccount current = new CurrentAccount("CA001", "Jane Smith", 3000.0);
        
        // Demonstrating polymorphism - using BankAccount reference
        BankAccount[] accounts = {savings, current};
        
        System.out.println("Account Details:");
        for (BankAccount account : accounts) {
            account.displayAccountDetails(); // Polymorphic method call
        }
        
        // Demonstrating transactions
        System.out.println("Transaction Demo:");
        for (BankAccount account : accounts) {
            System.out.println("\n" + account.getHolderName() + "'s transactions:");
            account.deposit(1000.0);
            account.withdraw(500.0);
            account.withdraw(2000.0); // This will fail for savings due to minimum balance
        }
        
        // Demonstrating interface usage
        System.out.println("\nLoan Applications:");
        for (BankAccount account : accounts) {
            if (account instanceof Loanable) {
                Loanable loanableAccount = (Loanable) account;
                System.out.println(account.getHolderName() + " applying for $10,000 loan:");
                loanableAccount.applyForLoan(10000.0);
            }
        }
        
        // Demonstrating encapsulation
        System.out.println("\n=== Testing Encapsulation ===");
        savings.setHolderName(""); // Should show validation message
        current.setOverdraftLimit(-1000); // Should show validation message
        savings.setHolderName("John Updated");
        current.setOverdraftLimit(7000.0);
        
        System.out.println("Updated account details:");
        savings.displayAccountDetails();
        current.displayAccountDetails();
    }
} 