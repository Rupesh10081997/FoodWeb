package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.entities.FeeCategory;
import com.main.service.feeCategoryService;

import jakarta.validation.Valid;

@RestController
public class feeCategory {
	@Autowired
	feeCategoryService fcs;
	
	@GetMapping("/getFeeCategory")
	public List<FeeCategory> getFeeCategory() {
		return fcs.getFeeCategory();
	}
	
	@PostMapping("/createFeeCategory")
	public ResponseEntity<FeeCategory> createFeeCategory(@RequestBody @Valid FeeCategory feecategory) {
		return new ResponseEntity<>(fcs.createFeeCategory(feecategory),HttpStatus.CREATED);
	}
	
	@PostMapping("/deleteFeeCategory")
	public ResponseEntity<String> deleteFeeCategory(@RequestParam Long feeCategoryId){
		fcs.deleteFeeCategory(feeCategoryId);
		return new ResponseEntity<>("Fee Category Deleted Sucessfully ",HttpStatus.OK);
	}
	@PostMapping("/updateFeeCategory")
	public ResponseEntity<FeeCategory> updateFeeCategory(@RequestBody FeeCategory feecategory){
		return new ResponseEntity<>(fcs.updateFeeCategory(feecategory),HttpStatus.OK);
	}
	
	@GetMapping("/getFeeCategoryByUsingId")
	public ResponseEntity<FeeCategory> getFeeCategoryByUsingId(@RequestParam Long feeCategoryId) {
		return new ResponseEntity<>(fcs.getFeeCategoryByUsingId(feeCategoryId),HttpStatus.OK);
	}
	
	@GetMapping("/getFeeCategoryByUsingName")
	public List<FeeCategory> getFeeCategoryByUsingName(@RequestParam String feeCategory) {
		return fcs.getFeeCategoryByUsingName(feeCategory);
	}
	
	@GetMapping("/getFeeCategoryListUsingQuery")
	public List<FeeCategory> getFeeCategoryListUsingQuery(){
		return fcs.getFeeCategoryListUsingQuery();
	}
	
}
