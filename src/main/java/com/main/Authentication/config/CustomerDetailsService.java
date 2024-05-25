package com.main.Authentication.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.main.dao.employeeDao;
import com.main.entities.Employee;

@Service
public class CustomerDetailsService implements UserDetailsService {
	@Autowired
	employeeDao dao;
	
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    	Employee user = dao.findByUserName(userName);
    	if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + userName);
        }
        Collection<? extends GrantedAuthority> authorities = getAuthoritiesForUser(user);
        
        //Encode the password using BCrypt
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        
        return new org.springframework.security.core.userdetails.User(user.getUserName(),
        		 hashedPassword, authorities);
    }
    
    private Collection<? extends GrantedAuthority> getAuthoritiesForUser(Employee user) {
        return Collections.emptyList();
    }
}

