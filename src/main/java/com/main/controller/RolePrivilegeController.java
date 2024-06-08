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

    @PostMapping("/assignPrivilegeRole")
    public ResponseEntity<RolePrivilege> assignAssignPrivilegeRole(@RequestBody @Valid RolePrivilege rolePrivilege){
        return new ResponseEntity<>(rolePrivilegeService.assignPrivilegeRole(rolePrivilege), HttpStatus.CREATED);
    }

    @GetMapping("/getPrivilegeRole")
    public ResponseEntity<List<RolePrivilege>> getPrivilegeRole(){
        return new ResponseEntity<>(rolePrivilegeService.getPrivilegeRole(),HttpStatus.OK);
    }

    @PostMapping("/updatePrivilegeRole/{roleId}")
    public ResponseEntity<String> updatePrivilegeRole(@RequestBody @Valid List<RolePrivilege> rolePrivilege,@PathVariable int roleId){
        return new ResponseEntity<>(rolePrivilegeService.updatePrivilegeRole(rolePrivilege,roleId), HttpStatus.CREATED);
    }
}
