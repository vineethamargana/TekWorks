package com.example.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.entity.Student;
import com.example.crud.repo.StudentRepo;

@RestController
public class StudentController {
    
	@Autowired
	StudentRepo studentrepo;
	
	@PostMapping("/api/students")
	public  ResponseEntity<String> saveStudent(@RequestBody Student student) //@requestbody is to ensures it is mandatory
	{
		studentrepo.save(student);
		String s = "success";
		return new ResponseEntity<>(s,HttpStatus.CREATED); //save the data to database
	}
	
	@GetMapping("/api/students")
	public ResponseEntity<List<Student>> getStudents()
	{
		return new ResponseEntity<>(studentrepo.findAll(),HttpStatus.OK); // return all the data from the db
	}
	
	
	
	@GetMapping("/api/students/{id}")
	public ResponseEntity<Student> getStudentbyID(@PathVariable long id)
	{
		Optional<Student> student = studentrepo.findById(id);
		if(student.isPresent())
		{
			return new ResponseEntity<>(student.get(),HttpStatus.OK); // return all the data from the d
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

	
	@PutMapping("/api/students/{id}")
	public ResponseEntity<Student> updateStudentbyID(@PathVariable long id,@RequestBody Student stud)
	{
		Optional<Student> student = studentrepo.findById(id);
		if(student.isPresent())
		{
			student.get().setStudentname(stud.getStudentname());
			student.get().setStudentEmail(stud.getStudentEmail());
			student.get().setStudentAddress(stud.getStudentAddress());
			return new ResponseEntity<>(studentrepo.save(student.get()),HttpStatus.OK); // return all the data from the d
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@DeleteMapping("/api/students/{id}")
	public ResponseEntity<Void> deletebyId(@PathVariable long id)
	{
		Optional<Student> student = studentrepo.findById(id);
		if(student.isPresent())
		{
			studentrepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); // return all the data from the d
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
