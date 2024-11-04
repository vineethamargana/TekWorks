/*
Question: Banking System Implementation with HashMap and Custom Exceptions

Problem Statement
1. You are tasked with creating a simple banking system that manages customer accounts, allowing operations such as account creation, 
balance inquiries, deposits, withdrawals, account deletion, and searching for accounts.

2. Your system should use HashMap to store accounts, allowing for quick access and management. Additionally, you need to implement 
custom exceptions to handle specific error scenarios in the banking operations.

Requirement
------------
I. Classes and Inheritance:

Create a base class named Account with the following attributes:
1. accNum (String): Account number.
2. accName (String): Account holder's name.
3. bankName (String): Name of the bank.
4. accountBalance (double): The balance of the account.

Create two subclasses:
CurrentAccount with an additional attribute:
1. tinNumber (int): Tax Identification Number.
2. It should maintain a minimum balance of ₹500.
SavingsAccount with an additional attribute:
1. orgName (String): Organization name for which the account is created.
2. It should maintain a minimum balance of ₹1000.


II. Custom Exceptions:

Implement the following custom exceptions:
1. InsufficientBalanceException: Thrown when a withdrawal is attempted that would result in a balance below the minimum required.
2. AccountNotFoundException: Thrown when attempting to perform an operation on an account that does not exist.
3. InvalidAmountException: Thrown when a deposit or withdrawal amount is invalid (e.g., negative or zero).

III. Account Management with HashMap:

1. Use a HashMap<String, Account> to store accounts, where the key is the account number (accNum) and the value is the Account object.


IV. Implement the following operations:
1. Create Account: Allow users to create both Current and Savings accounts.
2. View Account Details: Display details of a specific account using its account number.
3. Deposit: Allow users to deposit money into their accounts.
4. Withdraw: Allow users to withdraw money from their accounts, ensuring minimum balance constraints are met.
5. Delete Account: Remove an account from the system.
6. Search Account: Search for an account by account number and display its details if found.


V. User Interface:

Create a simple command-line interface that allows users to select from the available operations. The program should loop until the user chooses to exit.
Handle exceptions gracefully and display appropriate messages to the user.

Deliverables
The complete Java code implementing the above requirements.
A brief explanation of how your solution addresses the requirements, particularly regarding the use of HashMap and custom exceptions.
 */

package com.tap.bank;

import java.util.HashMap;
import java.util.Scanner;

class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super(message);
    }
}

class DuplicateAccountException extends Exception {
    public DuplicateAccountException(String message) {
        super(message);
    }
}


class Account{
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
            return super.withdraw(amount);
        } else {
            System.out.println("Insufficient funds to maintain minimum balance or invalid amount.");
            return false;
        }
    }

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
            return super.withdraw(amount);
        } else {
            System.out.println("Insufficient funds to maintain minimum balance or invalid amount.");
            return false;
        }
    }

    public String getOrgName() {
        return orgName;
    }
}


public class BankManagement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        HashMap<String, Account> accountMap = new HashMap<>();

        while (!exit) {
            System.out.println("Select an option: \n1. Set up your account. \n2. View account details \n3. Deposit \n4. Withdraw \n5. Deleting an account \n6. Searching an account \n7. Exit");
            int choose = sc.nextInt();
            sc.nextLine();

            switch (choose) {
                case 1:
                    try {
                        // Current Account
                        System.out.println("Enter details for the Current Account:");
                        System.out.print("Account Number: ");
                        String currentAccNum = sc.next();
                        if (accountMap.containsKey(currentAccNum)) {
                            throw new DuplicateAccountException("Account with number " + currentAccNum + " already exists.");
                        }
                        System.out.print("Account Holder Name: ");
                        String currentAccName = sc.next();
                        System.out.print("Bank Name: ");
                        String currentBankName = sc.next();
                        System.out.print("Initial Balance: ");
                        double currentInitialBalance = sc.nextDouble();
                        System.out.print("TIN Number: ");
                        int tinNumber = sc.nextInt();
                        CurrentAccount currentAccount = new CurrentAccount(tinNumber, currentAccNum, currentAccName, currentBankName, currentInitialBalance);
                        accountMap.put(currentAccNum, currentAccount);

                        // Savings Account
                        System.out.println("Enter details for the Savings Account:");
                        System.out.print("Account Number: ");
                        String savingsAccNum = sc.next();
                        if (accountMap.containsKey(savingsAccNum)) {
                            throw new DuplicateAccountException("Account with number " + savingsAccNum + " already exists.");
                        }
                        System.out.print("Account Holder Name: ");
                        String savingsAccName = sc.next();
                        System.out.print("Bank Name: ");
                        String savingsBankName = sc.next();
                        System.out.print("Initial Balance: ");
                        double savingsInitialBalance = sc.nextDouble();
                        sc.nextLine(); // Consume newline
                        System.out.print("Organization Name: ");
                        String orgName = sc.nextLine();
                        SavingsAccount savingsAccount = new SavingsAccount(orgName, savingsAccNum, savingsAccName, savingsBankName, savingsInitialBalance);
                        accountMap.put(savingsAccNum, savingsAccount);

                        System.out.println("Accounts set up successfully.");
                    } catch (DuplicateAccountException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter account number to view details: ");
                    String viewAccNum = sc.next();
                    try {
                        Account account = accountMap.get(viewAccNum);
                        if (account != null) {
                            account.display();
                        } else {
                            throw new AccountNotFoundException("Account with number " + viewAccNum + " not found.");
                        }
                    } catch (AccountNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3: 
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    System.out.print("Enter account number: ");
                    String depositAccNum = sc.next();
                    Account depositAccount = accountMap.get(depositAccNum);
                    if (depositAccount != null) {
                        depositAccount.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = sc.nextDouble();
                    System.out.print("Enter account number: ");
                    String withdrawAccNum = sc.next();
                    Account withdrawAccount = accountMap.get(withdrawAccNum);
                    if (withdrawAccount != null) {
                        withdrawAccount.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter account number to delete: ");
                    String deleteAccNum = sc.next();
                    if (accountMap.remove(deleteAccNum) != null) {
                        System.out.println("Account deleted successfully.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 6:
                    System.out.print("Enter account number to search: ");
                    String searchAccNum = sc.next();
                    if (accountMap.containsKey(searchAccNum)) {
                        accountMap.get(searchAccNum).display();
                    } else {
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
