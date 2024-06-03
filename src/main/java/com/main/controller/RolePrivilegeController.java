package com.main.controller;

import com.main.entities.RolePrivilege;
import com.main.service.RolePrivilegeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RolePrivilegeController {
    @Autowired
    RolePrivilegeService rolePrivilegeService;

    @PostMapping("/assignAssignPrivilegeRole")
    public ResponseEntity<RolePrivilege> assignAssignPrivilegeRole(@RequestBody @Valid RolePrivilege rolePrivilege){
        return new ResponseEntity<>(rolePrivilegeService.assignAssignPrivilegeRole(rolePrivilege), HttpStatus.CREATED);
    }

    @GetMapping("/getPrivilegeRole")
    public ResponseEntity<List<RolePrivilege>> getPrivilegeRole(){
        return new ResponseEntity<>(rolePrivilegeService.getPrivilegeRole(),HttpStatus.OK);
    }
}
