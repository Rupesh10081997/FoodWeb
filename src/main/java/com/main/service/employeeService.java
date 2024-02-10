package com.main.service;

import java.util.List;

import com.main.entities.Employee;

import jakarta.validation.Valid;

public interface employeeService {

	List<Employee> getEmployee();

	Employee createEmployee(@Valid Employee employee);

	void deleteEmployee(Long employeeId);

	Employee updateEmployee(Employee employee);

}
