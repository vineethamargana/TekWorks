package com.example.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.entity.Employee;
import com.example.crud.exception.EmployeeNotFoundException;
import com.example.crud.exception.ExceptionAlreadyExistsException;
import com.example.crud.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	public List<Employee> getAllEmployees()
	{
		return employeeRepo.findAll();
	}
	
	 public Employee getEmployeeById(int id) {
	        return employeeRepo.findById(id)
	            .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
	    }

	public Employee createEmployee(Employee emp)
	{
		if (employeeRepo.findById(emp.getId()).isPresent()) {
            throw new ExceptionAlreadyExistsException("Employee already exists with ID: " + employee.getId());
        }
        return employeeRepo.save(emp);
	}
	
	 public Employee updateEmployee(int id, Employee employeeDetails) {
	        Employee employee = employeeRepo.findById(id).orElseThrow();
	        employee.setName(employeeDetails.getName());
	        employee.setDepartment(employeeDetails.getDepartment());
	        employee.setEmail(employeeDetails.getEmail());
	        return employeeRepo.save(employee);
	    }

	    public void deleteEmployee(int id) {
	        employeeRepo.deleteById(id); 
	    }
}
