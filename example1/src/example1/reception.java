package example1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student {
    private int studentId;
    private String name;
    private int age;
    private String grade;

    // Constructor
    public Student(int studentId, String name, int age, String grade) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getters and Setters
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


public class reception {
	private Map<Integer, Student> studentRecords = new HashMap<>();
    private int currentId = 1; 
    

    public void addStudent(String name, int age, String grade) {
        Student student = new Student(currentId++, name, age, grade);
        studentRecords.put(student.getStudentId(), student);
        System.out.println("Student added successfully: " + student);
    }


    public void updateStudent(int id, String name, int age, String grade) {
        Student student = studentRecords.get(id);
        if (student != null) {
            student.setName(name);
            student.setAge(age);
            student.setGrade(grade);
            System.out.println("Student updated successfully: " + student);
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public void deleteStudent(int id) {
        if (studentRecords.remove(id) != null) {
            System.out.println("Student with ID " + id + " deleted successfully.");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }


    public void searchStudent(int id) {
        Student student = studentRecords.get(id);
        if (student != null) {
            System.out.println("Student found: " + student);
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }
    
    public void displayAllStudents() {
        if (studentRecords.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("All Students:");
            for (Student student : studentRecords.values()) {
                System.out.println(student);
            }
        }
    }


	public void addStudent() {
		// TODO Auto-generated method stub
		
	}



}
