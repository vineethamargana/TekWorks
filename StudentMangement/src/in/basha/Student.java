package in.basha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Student {
	private String stuName;
	private int stuId;
	private int[] marks;
	public Student(String stuName, int stuId, int[] marks) {
		
		this.stuName = stuName;
		this.stuId = stuId;
		this.marks = marks;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public int[] getMarks() {
		return marks;
	}
	public void setMarks(int[] marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [stuName=" + stuName + ", stuId=" + stuId + ", marks=" + Arrays.toString(marks) + "]";
	}
	private static ArrayList<Student> students=new ArrayList<>();
	private static Scanner sc=new Scanner(System.in);
	
	public static void addStudent() {
		System.out.println("enter student name :");
		String stuName = sc.nextLine();
		sc.nextLine();
		System.out.println("enter student Id :");
		int stuId=sc.nextInt();
		System.out.println("enter number of subjects");
		int sub=sc.nextInt();
		int[] marks=new int[sub];
		System.out.println("enter marks for "+ sub +" subject");
		for(int i=0;i<sub;i++) {
			marks[i]=sc.nextInt();
		}
		sc.nextLine();
		Student student=new Student(stuName,stuId,marks);
		students.add(student);
		System.out.println("Student added Successfully");
	}
	
	public static Student searchById(int stuId) {
		for(Student student:students) {
			if(student.getStuId()==stuId) {
				return student;
			}
		}
		
		return null;
		
	}
	
	public static void updateStudent() {
		System.out.println("enter student Id :");
		int stuId = sc.nextInt();
		Student student = searchById(stuId);
		if(student!=null) {
			System.out.println("1.update name /n2.update marks");
			int choice = sc.nextInt();
			sc.nextLine();
			if(choice==1) {
				System.out.println("enter name to update");
				String newName = sc.nextLine();
				student.setStuName(newName);
				System.out.println("Name updated Succesfully");
			}else if(choice==2) {
				System.out.println("enter number of subjects :");
				int newSub = sc.nextInt();
				int[] newMarks=new int[newSub];
				System.out.println("Enter marks for"+ newSub +" subjects");
				for(int i=0;i<newSub;i++) {
					newMarks[i]=sc.nextInt();
				}
				student.setMarks(newMarks);
				System.out.println("Marks updated Succesfully");
			}else {
				System.out.println("INvalid choice try again");
			}
			
			}
		else {
			System.out.println("Student not found");
		}
	}
	
	public static void removeStudent() {
		System.out.println("enter student id");
		int stuId = sc.nextInt();
		Student student = searchById(stuId);
		if(student!=null) {
			students.remove(student);
		}else {
			System.out.println("Student not found");
		}
	}
	
	public static void displayAllStudents() {
		if(students.isEmpty()) {
			System.out.println("Students List is Empty");
		}else {
			for(Student student:students) {
				System.out.println(student);
			}
		}
	}
	
	public static void main(String[] args) {
	
		while(true) {
			System.out.println("STUDENT MANAGEMENT SYSTEM");
			System.out.println("1. ADD STUDENT");
			System.out.println("2. UPDATE STUDENT");
			System.out.println("3. REMOVE STUDENT");
			System.out.println("4. SHOW ALL STUDENTS");
			System.out.println("ENTER YOUR CHOICE : ");
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				addStudent();
				break;
			case 2:
				updateStudent();
				break;
			case 3:
				removeStudent();
				break;
			case 4:
				displayAllStudents();
				break;
			}
			}
		
	}
		
	}
		
			


