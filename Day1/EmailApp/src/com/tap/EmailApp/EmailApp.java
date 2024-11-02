package com.tap.EmailApp;

import java.util.Scanner;

public class EmailApp {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first name:");
		String first = sc.nextLine();
		System.out.println("Enter the last name:");
		String last = sc.nextLine();
		Email e = new Email(first,last);
	
//		e.setAlternateEmail("vineetha@gmail.com");
//		System.out.println(e.getAlternateEmail());
		
		System.out.println(e.showInfo());
		
		
	}
}
