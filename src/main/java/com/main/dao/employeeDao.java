package com.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.entities.Employee;

@Repository
public interface employeeDao extends JpaRepository<Employee, Long>{

}
