package com.boot.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.rest.model.Employee;
import com.boot.rest.service.EmployeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping("/saveEmployee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
		Employee saveEmployee= employeeService.saveEmployee(emp);
		return new ResponseEntity<>(saveEmployee,HttpStatus.CREATED);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<Employee> findAllByEmployee(){
		List<Employee> allEmployees=employeeService.getAllEmployees();
		return new ResponseEntity(allEmployees,HttpStatus.OK);
	}

}
