package com.tap.studentmanager;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student
{
	    private int studentId;
	    private String name;
	    private int age;
	    private String grade;

	    public Student(int studentId, String name, int age, String grade) {
	        this.studentId = studentId;
	        this.name = name;
	        this.age = age;
	        this.grade = grade;
	    }

	    public int getStudentId() {
	        return studentId;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public int getAge() {
	        return age;
	    }

	    public void setAge(int age) {
	        this.age = age;
	    }

	    public String getGrade() {
	        return grade;
	    }

	    public void setGrade(String grade) {
	        this.grade = grade;
	    }
	    
	    @Override
	    public String toString() {
	        return "ID: " + studentId + ", Name: " + name + ", Age: " + age + ", Grade: " + grade;
	    }

}
public class Reception {
  
	private Map<Integer, Student> hm = new HashMap<>();
    private int id = 1; 
    Scanner scanner = new Scanner(System.in);
    
    // Adding a student
    public void addStudent()
    {
    	 System.out.print("Enter Name: ");
         String name = scanner.nextLine();
         System.out.print("Enter Age: ");
         int age = scanner.nextInt();
         scanner.nextLine();
         System.out.print("Enter Grade: ");
         String grade = scanner.nextLine();
         Student student = new Student(id++, name, age, grade);
         hm.put(student.getStudentId(), student);
         System.out.println("Student added successfully: " + student);
    }
    
     public void updateStudent(int id) {
        Student student = hm.get(id);
        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter New Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter New Grade: ");
        String grade = scanner.nextLine();
        if (student != null) {
            student.setName(name);
            student.setAge(age);
            student.setGrade(grade);
            System.out.println("Student updated successfully: " + student);
        }  
        else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public void deleteStudent(int id) {
        if (hm.remove(id) != null) {
            System.out.println("Student with ID " + id + " deleted successfully.");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }


    public void searchStudent(int id) {
        Student student = hm.get(id);
        if (student != null) {
            System.out.println("Student found: " + student); 
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }
    
    public void displayAllStudents() {
        if (hm.isEmpty()) 
        {
            System.out.println("No students found.");
        }
        else 
        {
            System.out.println("All Students:");
//            for (int student : hm.keySet()) 
//            {
//            	//Student student1;
//                System.out.println(hm.get(student));
//            }
            for(Student student:hm.values())
            {
            	System.out.println(student);                                
            }
        }
    }



}
