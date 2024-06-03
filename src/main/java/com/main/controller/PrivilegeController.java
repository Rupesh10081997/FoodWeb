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
        String msg ="";
        try{
            msg = service.createAcl(file);
        }catch(Exception ex){
            System.out.println("Error : "+ex.getMessage());
            ex.printStackTrace();
        }
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    @GetMapping("/fetchLinkRoleWise")
    public ResponseEntity<List<PrivilegeModule>> fetchLinkRoleWise(){
        return new ResponseEntity<>(service.fetchLinkRoleWise(),HttpStatus.OK);
    }
}
