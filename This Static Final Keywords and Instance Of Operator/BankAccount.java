public class BankAccount {
    private static String bankName = "ABC Bank";
    private static int totalAccounts = 0;
    private final String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static String getBankName() {
        return bankName;
    }

    public String getAccountHolderName() { return accountHolderName; }
    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }

    public void displayDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: " + balance);
        }
    }

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Alice", "123456", 1000.0);
        BankAccount acc2 = new BankAccount("Bob", "654321", 2000.0);
        acc1.displayDetails();
        System.out.println();
        acc2.displayDetails();
        System.out.println("\nTotal Accounts: " + BankAccount.getTotalAccounts());
    }
} 