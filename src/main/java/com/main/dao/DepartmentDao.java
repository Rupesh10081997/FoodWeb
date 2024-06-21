package com.main.dao;

import com.main.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDao extends JpaRepository<Department,Integer> {
    Department findByDepartmentName(String departmentName);
}
