package com.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.main.Exception.ResourceNotFoundException;
import com.main.dao.feeCategoryRepository;
import com.main.entities.FeeCategory;

@Service
public class feeCategoryServiceImpl implements feeCategoryService {
	@Autowired
	feeCategoryRepository fcr;
	
	@Override
	public List<FeeCategory> getFeeCategory() {
		// TODO Auto-generated method stub
		List<FeeCategory> feecatgory = fcr.findAll();
		return feecatgory;
	}

	@Override
	public FeeCategory createFeeCategory(FeeCategory feecategory) {
		// TODO Auto-generated method stub
		FeeCategory feeCategory = fcr.save(feecategory);
		return feeCategory;
	}

	@Override
	public void deleteFeeCategory(Long feeCategoryId) {
		// TODO Auto-generated method stub
		fcr.deleteById(feeCategoryId);
	}

	@Override
	public FeeCategory updateFeeCategory(FeeCategory feecategory) {
		// TODO Auto-generated method stub
		FeeCategory feeCategory = fcr.save(feecategory);
		return feeCategory;
	}

	@Override
	public FeeCategory getFeeCategoryByUsingId(Long feeCategoryId) {
		// TODO Auto-generated method stub
		FeeCategory feeCategory = fcr.findById(feeCategoryId).orElseThrow(() -> new ResourceNotFoundException("fee Category", "id", feeCategoryId));;
		return feeCategory;
	}

	@Override
	public List<FeeCategory> getFeeCategoryByUsingName(String feeCategory) {
		// TODO Auto-generated method stub
		List<FeeCategory> feecatgory = fcr.findByFeeCategoryUsingQuery(feeCategory);
		return feecatgory;
	}

	@Override
	public List<FeeCategory> getFeeCategoryListUsingQuery() {
		// TODO Auto-generated method stub
		List<FeeCategory> feecatgory = fcr.getFeeCategory();
		return feecatgory;
	}

}
