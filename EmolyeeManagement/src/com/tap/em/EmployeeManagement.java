package com.tap.em;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

abstract class Employee {
    private String employeeId;
    private String name;

    public Employee(String employeeId, String name) {
        this.employeeId = employeeId;
        this.name = name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateSalary();

    public String getDetails() {
        return "Employee ID: " + employeeId + ", Name: " + name + ", Salary: " + calculateSalary();
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String employeeId, String name, double monthlySalary) {
        super(employeeId, name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String employeeId, String name, double hourlyRate, int hoursWorked) {
        super(employeeId, name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

class EmployeeManagement {
    private Map<String, Employee> employees = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void addEmployee() {
        System.out.println("Enter employee type (FullTime/PartTime):");
        String type = scanner.nextLine();
        System.out.print("Enter employee ID: ");
        String employeeId = scanner.nextLine();
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        if ("FullTime".equalsIgnoreCase(type)) {
            System.out.print("Enter monthly salary: ");
            double salary = scanner.nextDouble();
            employees.put(employeeId, new FullTimeEmployee(employeeId, name, salary));
        } else if ("PartTime".equalsIgnoreCase(type)) {
            System.out.print("Enter hourly rate: ");
            double hourlyRate = scanner.nextDouble();
            System.out.print("Enter hours worked: ");
            int hoursWorked = scanner.nextInt();
            employees.put(employeeId, new PartTimeEmployee(employeeId, name, hourlyRate, hoursWorked));
        } else {
            System.out.println("Invalid employee type.");
        }

        scanner.nextLine(); // Consume newline
    }

    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee emp : employees.values()) {
                System.out.println(emp.getDetails());
            }
        }
    }

    public static void main(String[] args) {
        EmployeeManagement management = new EmployeeManagement();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Choose an option: \n1. Add Employee \n2. Display Employees \n3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    management.addEmployee();
                    break;
                case 2:
                    management.displayEmployees();
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
