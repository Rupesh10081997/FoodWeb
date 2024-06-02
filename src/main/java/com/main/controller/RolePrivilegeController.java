package com.main.controller;

import com.main.entities.RolePrivilege;
import com.main.service.RolePrivilegeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RolePrivilegeController {
    @Autowired
    RolePrivilegeService rolePrivilegeService;

    @PostMapping("/assignAssignPrivilegeRole")
    public ResponseEntity<RolePrivilege> assignAssignPrivilegeRole(@RequestBody @Valid RolePrivilege rolePrivilidge){
        return new ResponseEntity<>(rolePrivilegeService.assignAssignPrivilegeRole(rolePrivilidge), HttpStatus.CREATED);
    }
}
