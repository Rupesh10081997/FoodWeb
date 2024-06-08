package com.main.dao;

import com.main.entities.PrivilegeModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeDao extends JpaRepository<PrivilegeModule,Integer> {

}
