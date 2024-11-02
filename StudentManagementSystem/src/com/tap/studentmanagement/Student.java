package com.tap.studentmanagement;

public class Student {
	private int studentId;
	private String name;
	private int age;
	private String grade;
	
	
	public Student(int studentId,String name,int age,String grade)
	{
		this.studentId=studentId;
		this.name = name;
		this.age = age;
		this.grade = grade;
	}

	public Student(String name, int age, String grade) {
		super();
		this.name = name;
		this.age = age;
		this.grade = grade;
	}
   
	

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getStudentId() {
		return studentId;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
	public String getGrade() {
		return grade;
	}
	@Override
    public String toString() {
        return "ID: " + studentId + ", Name: " + name + ", Age: " + age + ", Grade: " + grade;
    }
	
}
