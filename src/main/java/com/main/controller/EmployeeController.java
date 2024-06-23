package com.main.controller;

import java.util.List;

import com.main.dto.request.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.Authentication.Service.JwtService;
import com.main.Authentication.ServiceImpl.JwtServiceImpl;
import com.main.entities.Employee;
import com.main.service.employeeService;

import jakarta.validation.Valid;


@RestController
public class EmployeeController {
	@Autowired
	employeeService emp;
	
	@Autowired
    private JwtServiceImpl jwtUtil;


	
	@GetMapping("/getEmployee")
	public List<Employee> getEmployee(@RequestHeader("Authorization") String authorizationHeader) {
		/*
		 * String token = authorizationHeader.substring(7); // Remove "Bearer " prefix
		 * Object employeeId = jwtUtil.extractClaim(token, claims ->
		 * claims.get("userName", Long.class)); System.out.println("Hello "+employeeId);
		 */
		return emp.getEmployee();
	}
	
	@PostMapping("/createEmployee")
	public ResponseEntity<Employee> createEmployee(@RequestBody @Valid Employee Employee) {
		return new ResponseEntity<>(emp.createEmployee(Employee),HttpStatus.CREATED);
	}
	
	@PostMapping("/deleteEmployee")
	public ResponseEntity<String> deleteEmployee(@RequestParam Long EmployeeId){
		emp.deleteEmployee(EmployeeId);
		return new ResponseEntity<>("Fee Category Deleted Sucessfully ",HttpStatus.OK);
	}
	@PostMapping("/updateEmployee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee Employee){
		return new ResponseEntity<>(emp.updateEmployee(Employee),HttpStatus.OK);
	}
	
	@PostMapping("/findEmployeeUsingFirstName")
	public List<Employee> findEmployeeUsingFirstName(@RequestParam String name){
		return emp.findEmployeeUsingFirstName(name);
	}
	@PostMapping("/searchEmployee")
	public List<Employee> fillterEmployee(@RequestBody CustomerDto customerDto) {
		System.out.println("in search");
		return emp.getAllEmployeeFilter(customerDto);
	}
}
