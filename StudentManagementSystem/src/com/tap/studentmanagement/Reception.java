package com.tap.studentmanagement;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;



public class Reception {
	//adding student
	private Map<Integer, Student> hs = new HashMap<>();
	private int id = 1;
	Scanner sc = new Scanner(System.in);
	
	 public void addStudent(String name, int age, String grade)
	 {
		 Student s = new Student(id++,name,age,grade);
		 hs.put(s.getStudentId(), s);
		 System.out.println("Student added succesfully" +s);
		 StudentManagementSystem.display();
	 }
	//updating students
	 public void updateStudent(int id)
	 {
		 Student student = hs.get(id);
		 if(student != null)
		 {
			 System.out.print("enter the new name:");
			 String newName=sc.nextLine();
			 System.out.println("enter the age");
			 int newage = sc.nextInt();
			 System.out.print("enter the new grade:");
			 String newgrade=sc.nextLine();
			 Student s1= new Student(newName,newage,newgrade);
			 System.out.println("student updated successfully"); 
			 StudentManagementSystem.display();
			 
		 }
		 else
		 {
			 System.out.println("student doesnot exist");
			 StudentManagementSystem.display();
		 }
	 }
	// Deleting a student
	    public void deleteStudent(int id) {
	        if (hs.remove(id) != null) {
	            System.out.println("Student id" + id +" deleted successfully.");
	        } else {
	            System.out.println("Student id " + id +" not found.");
	        }
	    }

	    // Searching for a student by ID
	    public void searchStudent(int id) {
	        Student student = hs.get(id);
	        if (student != null) {
	            System.out.println("Student found: " + student);
	        } else {
	            System.out.println("Student with ID " + id + " not found.");
	        }
	    }

	    // Displaying all students
	    public void displayAllStudents() {
	        if (hs.isEmpty()) 
	        {
	            System.out.println("No students found.");
	        } 
	        else 
	        {
	            
	        	   for (Student student : hs.values()) 
	        	   {
	                System.out.println(student);
	               }
	        }
	    }

}
