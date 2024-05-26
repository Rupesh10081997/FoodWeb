package com.main.Authentication.ServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.main.Authentication.Entities.AuthRequestDto;
import com.main.Authentication.Service.AuthService;
import com.main.Authentication.Service.JwtService;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {
	@Autowired
    private  AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @Override
    public Map<String, String> authRequest(AuthRequestDto authRequestDto) {
    	
       final var authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDto.userName(), authRequestDto.password()));
       final var userDetails =  (UserDetails) authenticate.getPrincipal();
       return   getToken(userDetails);
    }

    public Map<String, String> getToken( UserDetails userDetails) {
        final var roles = userDetails.getAuthorities();
        final var username = userDetails.getUsername();
        final var token = jwtService.generateToken(Map.of("role", roles), username);
        return Map.of("token", "Bearer "+token);
    }
}
