package com.main.service;

import java.util.List;

import com.main.Authentication.Entities.Users;
import com.main.Authentication.Service.CommonService;
import com.main.Authentication.dao.UsersDao;
import com.main.dao.DepartmentDao;
import com.main.entities.Department;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.employeeDao;
import com.main.entities.Employee;

@Service
public class employeeServiceImpl implements employeeService {
	@Autowired
	employeeDao dao;

	@Autowired
	DepartmentDao departmentDao;

	@Autowired
	CommonService commonService;

	@Autowired
	UsersDao usersDao;
	
	@Override
	public List<Employee> getEmployee() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	@Transactional
	@Override
	public Employee createEmployee(Employee employee) {
		// Encode password
		employee.setPassword(commonService.encodeData(employee.getPassword()));
		Department department =null;
		department = departmentDao.findByDepartmentName(employee.getDepartment().getDepartmentName());
		if(department != null){
			employee.setDepartment(department);
		}
		Employee emp = dao.save(employee);

		//create users
		Users users = new Users();
		users.setUserName(employee.getUserName());
		users.setPassword(employee.getPassword());
		users.setStatus(employee.getStatus());
		usersDao.save(users);

		return emp;
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
