package com.example.crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String studentname;
	private String StudentEmail;
	private String studentAddress;
	
	public Student() {
		super();
	}
	
	public Student(long id, String studentname, String studentEmail, String studentAddress) {
		super();
		this.id = id;
		this.studentname = studentname;
		StudentEmail = studentEmail;
		this.studentAddress = studentAddress;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getStudentEmail() {
		return StudentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		StudentEmail = studentEmail;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", studentname=" + studentname + ", StudentEmail=" + StudentEmail
				+ ", studentAddress=" + studentAddress + "]";
	}
	
}
