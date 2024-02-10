package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FdWebApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(FdWebApplication.class, args);
	}

}
