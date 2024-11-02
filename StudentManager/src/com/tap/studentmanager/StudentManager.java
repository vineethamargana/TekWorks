package com.tap.studentmanager;

import java.util.Scanner;



public class StudentManager {
	public static void main(String[] args) {
        Reception reception = new Reception();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        
        while (!exit) {
        	System.out.println("*************************************\n1.Adding Students \n2.Updating Students \n3.Deleting Students \n4.Searching for students \n5.Displaying all Students \n6.exit \nchoose an option:");
    		int choice= scanner.nextInt();
    		scanner.nextLine(); 
    		
    		switch (choice) {
            case 1:
                reception.addStudent();
                break;
                
            case 2:
                System.out.print("Enter Student ID to update: ");
                int updateId = scanner.nextInt();
                reception.updateStudent(updateId);
                break;

            case 3:
                System.out.print("Enter Student ID to delete: ");
                int deleteId = scanner.nextInt();
                reception.deleteStudent(deleteId);
                break;

            case 4:
                System.out.print("Enter Student ID to search: ");
                int searchId = scanner.nextInt();
                reception.searchStudent(searchId);
                break;

            case 5:
                reception.displayAllStudents();
                break;

            case 6:
                exit = true;
                System.out.println("Exiting the system. Goodbye!");
                break;

            default:
                System.out.println("Invalid option. Please try again.");
             }
          }
        }
	}

