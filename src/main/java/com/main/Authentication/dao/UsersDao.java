package com.main.Authentication.dao;

import com.main.Authentication.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDao extends JpaRepository<Users,Integer> {

    Users findByUserName(String userName);
}
