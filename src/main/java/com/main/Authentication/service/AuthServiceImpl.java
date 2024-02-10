package com.main.Authentication.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;


public class AuthServiceImpl {
	@Autowired
    private  AuthenticationManager authenticationManager;
    @Autowired
    private JwtServiceImpl jwtService;
    
    public Map<String, String> authRequest(String userName,String password) {
       final var authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
       final var userDetails =  (UserDetails) authenticate.getPrincipal();
       return   getToken(userDetails);
    }

    public Map<String, String> getToken( UserDetails userDetails) {
        final var roles = userDetails.getAuthorities();
        final var username = userDetails.getUsername();
        final var token = jwtService.generateToken(Map.of("role", roles), username);
        return Map.of("token", token);
    }
}
