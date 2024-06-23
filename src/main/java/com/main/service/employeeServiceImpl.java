package com.main.service;

import java.util.List;

import com.main.Authentication.Service.CommonService;
import com.main.dao.DepartmentDao;
import com.main.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.employeeDao;
import com.main.entities.Employee;

import jakarta.validation.Valid;
@Service
public class employeeServiceImpl implements employeeService {
	@Autowired
	employeeDao dao;

	@Autowired
	DepartmentDao departmentDao;

	@Autowired
	CommonService commonService;
	
	@Override
	public List<Employee> getEmployee() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Employee createEmployee(Employee employee) {
		// Encode password
		employee.setPassword(commonService.encodeData(employee.getPassword()));
		Department department =null;
		department = departmentDao.findByDepartmentName(employee.getDepartment().getDepartmentName());
		if(department != null){
			employee.setDepartment(department);
		}
		return dao.save(employee);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		// TODO Auto-generated method stub
		dao.deleteById(employeeId);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return dao.save(employee);
	}

	@Override
	public List<Employee> findEmployeeUsingFirstName(String name) {
		// TODO Auto-generated method stub
		return dao.findByName(name);
	}

}
