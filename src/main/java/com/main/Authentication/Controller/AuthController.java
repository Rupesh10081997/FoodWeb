package com.main.Authentication.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.main.entities.Employee;


@RestController
public class AuthController {
	
	@PostMapping("/auth/login")
	public ResponseEntity<Employee> authRequest(@RequestBody Employee emp) {
		return new ResponseEntity<>(null);
	}
}
