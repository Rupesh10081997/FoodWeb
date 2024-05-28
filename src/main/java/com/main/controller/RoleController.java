package com.main.controller;

import com.main.entities.Role;
import com.main.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {
@Autowired
RoleService roleService;
@PostMapping("/createRole")
    public ResponseEntity<Role>  createRole(@RequestBody Role role)
    {
        return new ResponseEntity<>(roleService.CretaeRole(role), HttpStatus.CREATED);
    }
@GetMapping("/getAllRole")
    public List<Role> getAllRole()
    {
       return  roleService.getAllRole();
    }
}
