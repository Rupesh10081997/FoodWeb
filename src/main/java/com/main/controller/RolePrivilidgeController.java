package com.main.controller;

import com.main.entities.RolePrivilidge;
import com.main.service.RolePrivilidgeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RolePrivilidgeController {
@Autowired
    RolePrivilidgeService rolePrivilidgeService;
    @PostMapping("/assignrolprivilidge")
    public ResponseEntity<RolePrivilidge> assignrole(@RequestBody @Valid RolePrivilidge rolePrivilidge)
    {
return new ResponseEntity<>(rolePrivilidgeService.AssignRole(rolePrivilidge), HttpStatus.CREATED);
    }
}
