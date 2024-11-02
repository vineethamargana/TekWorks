package com.aishu.practise;

import java.util.Scanner;

class Account {
    // Make fields private
    private String accNum;
    private String accName;
    private String bankName;
    private double accountBalance; 

    public Account(String accNum, String accName, String bankName, double initialBalance) {
        this.accNum = accNum;
        this.accName = accName;
        this.bankName = bankName;
        this.accountBalance = initialBalance;
    }

    public void display() {
        System.out.println("Account num: " + accNum);
        System.out.println("Account name: " + accName);
        System.out.println("Bank name: " + bankName);
        System.out.println("Account balance: " + accountBalance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            accountBalance += amount;
            System.out.println("Deposit successful! New Balance: " + accountBalance);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Withdrawal successful! New Balance: " + accountBalance);
            return true;
        } else {
            System.out.println("Insufficient balance or invalid amount");
            return false;
        }
    }

    // Getters
    public String getAccNum() {
        return accNum;
    }

    public String getAccName() {
        return accName;
    }

    public String getBankName() {
        return bankName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    // Setters
    public void setAccName(String accName) {
        this.accName = accName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}

class CurrentAccount extends Account {
    private int tinNumber;
    private static final double MIN_BALANCE = 500;

    public CurrentAccount(int tinNumber, String accNum, String accName, String bankName, double initialBalance) {
        super(accNum, accName, bankName, initialBalance);
        this.tinNumber = tinNumber;    
    }

    @Override
    public void display() {
        super.display();
        System.out.println("TIN Number: " + tinNumber);
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && getAccountBalance() - amount >= MIN_BALANCE) {
            double newBalance = getAccountBalance() - amount;
            // Use setter if you want to restrict direct access
            // setAccountBalance(newBalance);
            return true;
        } else {
            System.out.println("Insufficient funds to maintain minimum balance or invalid amount.");
            return false;
        }
    }

    // Getter for TIN number
    public int getTinNumber() {
        return tinNumber;
    }
}

class SavingsAccount extends Account { 
    private String orgName;
    private static final double MIN_BALANCE = 1000;

    public SavingsAccount(String orgName, String accNum, String accName, String bankName, double initialBalance) {
        super(accNum, accName, bankName, initialBalance);
        this.orgName = orgName;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Organization Name: " + orgName);
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && getAccountBalance() - amount >= MIN_BALANCE) {
            double newBalance = getAccountBalance() - amount;
            // Use setter if you want to restrict direct access
            // setAccountBalance(newBalance);
            return true;
        } else {
            System.out.println("Insufficient funds to maintain minimum balance or invalid amount.");
            return false;
        }
    }

    // Getter for organization name
    public String getOrgName() {
        return orgName;
    }
}

public class Oops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        Account currentAccount = null;
        Account savingsAccount = null;

        while (!exit) {
            System.out.println("Select an option: \n1. Set up your account. \n2. View account details \n3. Deposit \n4. Withdraw \n5. Deleting an account \n6. Searching an account \n7. Exit");
            int choose = sc.nextInt();
            sc.nextLine();

            switch (choose) {
                case 1:
                    System.out.println("Enter details for the Current Account:");
                    System.out.print("Account Number: ");
                    String currentAccNum = sc.next();
                    System.out.print("Account Holder Name: ");
                    String currentAccName = sc.next();
                    System.out.print("Bank Name: ");
                    String currentBankName = sc.next();
                    System.out.print("Initial Balance: ");
                    double currentInitialBalance = sc.nextDouble();
                    System.out.print("TIN Number: ");
                    int tinNumber = sc.nextInt();
                    currentAccount = new CurrentAccount(tinNumber, currentAccNum, currentAccName, currentBankName, currentInitialBalance);

                    // Set up Savings Account
                    System.out.println("Enter details for the Savings Account:");
                    System.out.print("Account Number: ");
                    String savingsAccNum = sc.next();
                    System.out.print("Account Holder Name: ");
                    String savingsAccName = sc.next();
                    System.out.print("Bank Name: ");
                    String savingsBankName = sc.next();
                    System.out.print("Initial Balance: ");
                    double savingsInitialBalance = sc.nextDouble();
                    sc.nextLine(); // Consume newline
                    System.out.print("Organization Name: ");
                    String orgName = sc.nextLine();
                    savingsAccount = new SavingsAccount(orgName, savingsAccNum, savingsAccName, savingsBankName, savingsInitialBalance);

                    System.out.println("Accounts set up successfully.");
                    break;

                case 2:
                    if (currentAccount != null) {
                        System.out.println("Current Account Details:");
                        currentAccount.display();
                    } else {
                        System.out.println("Current account not set up.");
                    }

                    if (savingsAccount != null) {
                        System.out.println("Savings Account Details:");
                        savingsAccount.display();
                    } else {
                        System.out.println("Savings account not set up.");
                    }
                    break;

                case 3: 
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    System.out.println("Choose account type: \n1. Current Account \n2. Savings Account");
                    int accountType = sc.nextInt();
                    if (accountType == 1 && currentAccount != null) {
                        currentAccount.deposit(depositAmount);
                    } else if (accountType == 2 && savingsAccount != null) {
                        savingsAccount.deposit(depositAmount);
                    } else {
                        System.out.println("Invalid account type selected or account not set up.");
                    }
                    break;

                case 4:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = sc.nextDouble();
                    System.out.println("Choose account type: \n1. Current Account \n2. Savings Account");
                    accountType = sc.nextInt();
                    if (accountType == 1 && currentAccount != null) {
                        currentAccount.withdraw(withdrawAmount);
                    } else if (accountType == 2 && savingsAccount != null) {
                        savingsAccount.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Invalid account type selected or account not set up.");
                    }
                    break;

                case 5:
                    System.out.println("Choose account type to delete: \n1. Current Account \n2. Savings Account");
                    accountType = sc.nextInt();
                    if (accountType == 1 && currentAccount != null) {
                        currentAccount = null;
                        System.out.println("Current Account deleted successfully.");
                    } else if (accountType == 2 && savingsAccount != null) {
                        savingsAccount = null;
                        System.out.println("Savings Account deleted successfully.");
                    } else {
                        System.out.println("Invalid account type selected or account not set up.");
                    }
                    break;

                case 6:
                    System.out.print("Enter account number to search: ");
                    String searchAccNum = sc.next();
                    boolean found = false;
                    if (currentAccount != null && currentAccount.getAccNum().equals(searchAccNum)) {
                        System.out.println("Current Account found:");
                        currentAccount.display();
                        found = true;
                    }

                    // Search in Savings Account
                    if (savingsAccount != null && savingsAccount.getAccNum().equals(searchAccNum)) {
                        System.out.println("Savings Account found:");
                        savingsAccount.display();
                        found = true;
                    }

                    if (!found) {
                        System.out.println("Account not found.");
                    }
                    break;

                case 7:
                    exit = true;
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
