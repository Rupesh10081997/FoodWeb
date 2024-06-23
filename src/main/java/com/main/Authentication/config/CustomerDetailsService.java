package com.main.Authentication.config;

import java.util.Collection;
import java.util.Collections;

import com.main.Authentication.Entities.Users;
import com.main.Authentication.dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.main.entities.Employee;

@Service
public class CustomerDetailsService implements UserDetailsService {
	@Autowired
    UsersDao dao;
	
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users user = dao.findByUserName(userName);
    	if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + userName);
        }
        Collection<? extends GrantedAuthority> authorities = getAuthoritiesForUser(user);
        
        //Encode the password using BCrypt
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        
        return new org.springframework.security.core.userdetails.User(user.getUserName(),
        		 hashedPassword, authorities);
    }
    
    private Collection<? extends GrantedAuthority> getAuthoritiesForUser(Users user) {
        return Collections.emptyList();
    }
}

