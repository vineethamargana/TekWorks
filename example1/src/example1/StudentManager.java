package example1;

import java.util.Scanner;

public class StudentManager {
	public static void main(String[] args) {
        reception reception = new reception();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
//                    System.out.print("Enter Name: ");
//                    String name = scanner.nextLine();
//                    System.out.print("Enter Age: ");
//                    int age = scanner.nextInt();
//                    scanner.nextLine();
//                    System.out.print("Enter Grade: ");
//                    String grade = scanner.nextLine();
                    reception.addStudent();
                    break;

                case 2:
                    System.out.print("Enter Student ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter New Age: ");
                    age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Grade: ");
                    grade = scanner.nextLine();
                    reception.updateStudent(updateId, name, age, grade);
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
        scanner.close();
    }

}
