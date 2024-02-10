package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.main.Helper.FileUploadHelper;

@RestController
public class FileUpload {
	@Autowired
	FileUploadHelper fileUpload;
	
    @PostMapping("/uploadProfileStudent")
    public ResponseEntity<String> uploadProfileStudent(@RequestParam("file") MultipartFile file) {
    	try {
    		if(file.isEmpty()) {
            	return new ResponseEntity<>("File is Empty",HttpStatus.BAD_REQUEST);
            }
            if(!file.getContentType().equalsIgnoreCase("image/jpeg") && !file.getContentType().equalsIgnoreCase("image/png")) {
            	return new ResponseEntity<>("File must JPEG/PNG formate",HttpStatus.BAD_REQUEST);
            }
            boolean b = fileUpload.uploadFileNIo(file);
            if(b) {
            	return new ResponseEntity<>(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString(),HttpStatus.OK);
            }else {
            	return new ResponseEntity<>("Something went wrong..",HttpStatus.INTERNAL_SERVER_ERROR);
            }
    	}catch(Exception ex) {
    		ex.printStackTrace();
        	return new ResponseEntity<>("Something went wrong..",HttpStatus.INTERNAL_SERVER_ERROR);
    	}
        
        
    }
	
}
