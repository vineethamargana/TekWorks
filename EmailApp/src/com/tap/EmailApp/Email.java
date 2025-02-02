package com.tap.EmailApp;

import java.util.Scanner;

public class Email {
	    private String firstName;
	    private String lastName;
	    private String password;
	    private String department;
	    private String email;
	    private int mailboxCapacity = 500;
	    private int defaultPasswordLength = 10;
	    private String alternateEmail;
	    private String companySuffix = ".tekworks.com";

	    // constructor to receive the first name and last name
	    public Email(String firstName,String lastName)
	    {
	        this.firstName = firstName;
	        this.lastName = lastName;
	       // System.out.println("Email Created: "+this.firstName+" "+this.lastName);
	       
	        //call a method asking for the department - return the department
	        this.department = setDepartment();
	     //   System.out.println("Department: "+this.department);
	        
	        //call a method that returns a random password
	        this.password = randomPassword(defaultPasswordLength);
	        System.out.println("your password is : "+ this.password);
	        
	        //combine elements to generate email
	        email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+ department + companySuffix;
	     //   System.out.println("your email:"+ email);
	        
	    }

	    //ask for the department
	    private String setDepartment()
	    {
	    	System.out.print("New Worker "+firstName+"\nDepartment Codes:\n1.for sales \n2.for development \n3.for accounting \n4.none \nEnter the department code: ");
	    	Scanner sc = new Scanner(System.in);
	    	int depChoice = sc.nextInt();
	    	if(depChoice == 1) {
	    		return "sales";
	    	}
	    	else if(depChoice == 2)
	    	{
	    		return "Development";
	    	}
	    	else if(depChoice == 3)
	    	{
	    		return "accounting";
	    	}
	    	else
	    	{
	    		return "";
	    	}
	    }

	    //generate a random password
	    private String randomPassword(int length)
	    {
	    	String passwordSet = "ABCDEFGHIJKLMNOPRSTUVWXYZ0123456789!@#$%^&*";
	    	char[] password = new char[length];
	    	for(int i=0;i<length;i++)
	    	{
	    		int rand = (int)(Math.random()*passwordSet.length());
	    		password[i] = passwordSet.charAt(rand); 
	    	}
	    	return new String(password);
	    }

	    //set the mailbox capacity
	    public void setMailboxCapacity(int capacity)
	    {
	    	this.mailboxCapacity = capacity;
	    }

	    //set the alternate email
	    public void setAlternateEmail(String altEmail)
	    {
	    	this.alternateEmail = altEmail;
	    }

	    //change the password
	    public void changePassword(String password)
	    {
	    	this.password = password;
	    }
        
	    public int getMailboxCapacity() {
	    	return mailboxCapacity;
	    }
	    
	    public String getAlternateEmail() {
	    	return alternateEmail;
	    }
	    
	    public String getPassword() {
	    	return password;
	    }
	    
	    //showing the information 
	    public String showInfo()
	    {
	    	return "Display Name: " + firstName+" "+lastName+
	    			"\nCompany Email:" +email+
	    			"\nMailBox Capacity:" +mailboxCapacity+"mb";
	    }
}
