package com.tap.studentmanagement;

import java.util.Scanner;

public class StudentManagementSystem {
	public static void display()
	{
		Reception r = new Reception();
		System.out.println("******************************");
		System.out.println("Please choose one: \n1.Adding Students \n2.Updating Students \n3.Deleting Students \n4.Searching for students \n5.Displaying all Students");
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		 sc.nextLine();
		if(n==1)
		{
			 System.out.println("enter the name:");
			 String name = sc.nextLine();
			 System.out.println("enter the age:");
			 int age = sc.nextInt();
			 sc.nextLine();
			 System.out.println("enter the grade:");
			 String grade = sc.nextLine();
			 
			r.addStudent(name, age, grade);
		} 
		else if(n==2)
		{
			System.out.println("updating student");
			System.out.println("enter the id of the student whose details u want to update:");
			int id= sc.nextInt();
			sc.nextLine();
			r.updateStudent(id);
		}
		else if(n==3)
		{
			System.out.println("enter the id of the student ");
			int id= sc.nextInt();
			r.deleteStudent(id);
		}
		else if(n==4)
		{

			System.out.println("enter the id of the student ");
			int id= sc.nextInt();
			r.searchStudent(n);
		}
		else if(n==5)
		{
			r.displayAllStudents();
		}
	}
	public static void main(String[] args) {
		
		display();
		
	}

}
