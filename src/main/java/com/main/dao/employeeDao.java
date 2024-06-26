package com.main.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.main.entities.Employee;

@Repository
public interface employeeDao extends JpaRepository<Employee, Long>{
/*
	Employee findByUserName(String username);
*/

	List<Employee> findByName(String name);
}
