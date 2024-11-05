package com.example.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
