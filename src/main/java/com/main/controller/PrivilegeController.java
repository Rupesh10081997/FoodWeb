package com.main.controller;

import com.main.entities.PrivilegeModule;
import com.main.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PrivilegeController {

    @Autowired
    PrivilegeService service;

    @GetMapping("/fetchAllLink")
    public ResponseEntity<List<PrivilegeModule>> getAllLink(){
        return new ResponseEntity<>(service.getAllLink(),HttpStatus.OK);
    }

    @PostMapping("/createAcl")
    public ResponseEntity<String> createAcl(@RequestParam("file") MultipartFile file){
        try{
            String msg = service.createAcl(file);

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>("Acl created sucessfully", HttpStatus.CREATED);
    }
}
