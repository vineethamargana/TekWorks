package com.aishu.practise;

import java.util.Scanner;

class Account1
{
	protected String accNum;
	protected String accName;
	protected String bankName;
	protected double accountBalance; 
	
	public Account1(String accNum,String accName,String bankName,double initialBalance){
		this.accNum=accNum;
		this.accName=accName;
		this.bankName=bankName;
		this.accountBalance = initialBalance;
	}
	public void display()
	{
		System.out.println("Account num : "+accNum);
		System.out.println("Account name : "+accName);
		System.out.println("Bank name : "+bankName);
		System.out.println("Account balance: " + accountBalance);
	}
	public void deposit(double amount)
	{
		if(amount > 0)
		{
			accountBalance += amount;
			System.out.println("Deposit successful ! New Balance : "+ accountBalance);
		}
		else
		{
			System.out.println("invalid deposit amount");
		}
	}
	public boolean withdraw(double amount)
	{
		if(amount > 0 && amount <= accountBalance)
		{
			accountBalance -= amount;
			System.out.println("Withdrawal successful! New Balance :"+accountBalance);
			return true;
		}
		else
		{
			System.out.println("insufficient balance or invalid amount");
			return false;
		}
	}
}
class CurrentAccount1 extends Account1
{
	int tinNumber;
	private static final double MIN_BALANCE = 500;
	public CurrentAccount1(int tinNumber,String accNum, String accName, String bankName,double initialBalance) {
		super(accNum, accName, bankName,initialBalance); // calling superclass constructor
		this.tinNumber=tinNumber;	
	}
	
	@Override
	public void display()
	{
		super.display();
		System.out.println("Tiny Number:"+tinNumber);
	}
	
	 @Override
	    public boolean withdraw(double amount) {
	        if (amount > 0 && accountBalance - amount >= MIN_BALANCE) {
	            accountBalance -= amount;
	            System.out.println("Withdrawal successful! New balance: " + accountBalance);
	            return true;
	        } else {
	            System.out.println("Insufficient funds to maintain minimum balance or invalid amount.");
	            return false;
	        }
	    }
}
class SavingsAccount1 extends Account1
{ 
    String orgname;
    private static final double MIN_BALANCE = 1000;
	public SavingsAccount1(String orgname,String accNum, String accName, String bankName,double initialBalance) {
		super(accNum, accName, bankName,initialBalance);
		this.orgname= orgname;
	}
	
	@Override
	public void display()
	{
		super.display();
		System.out.println("Org name:"+orgname);
	}
	
	@Override
    public boolean withdraw(double amount) {
        if (amount > 0 && accountBalance - amount >= MIN_BALANCE) {
            accountBalance -= amount;
            System.out.println("Withdrawal successful! New balance: " + accountBalance);
            return true;
        } else {
            System.out.println("Insufficient funds to maintain minimum balance or invalid amount.");
            return false;
        }
    }
	
}
public class BankAccount {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	    boolean exit = false;
	    Account1 currentAccount = null;
        Account1 savingsAccount = null;
	    
	    while(!exit)
	    {
	    	System.out.println("select an option : \n1.set up your account. \n2. view account details \n3.deposit \n4.withdraw \n5.deleting an account \n6.searching an account \n7.exit");
		    int choose= sc.nextInt();
		    sc.nextLine();
		   
	    	switch(choose)
	    	{
	    	case 1:
	    		System.out.println("Enter details for the Current Acco unt:");
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
                currentAccount = new CurrentAccount1(tinNumber, currentAccNum, currentAccName, currentBankName, currentInitialBalance);

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
                savingsAccount = new SavingsAccount1(orgName, savingsAccNum, savingsAccName, savingsBankName, savingsInitialBalance);

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
                 if (currentAccount != null && currentAccount.accNum.equals(searchAccNum)) {
                     System.out.println("Current Account found:");
                     currentAccount.display();
                     found = true;
                 }

                 // Search in Savings Account
                 if (savingsAccount != null && savingsAccount.accNum.equals(searchAccNum)) {
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
