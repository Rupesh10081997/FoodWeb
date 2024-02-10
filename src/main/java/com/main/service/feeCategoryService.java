package com.main.service;

import java.util.List;
import com.main.entities.FeeCategory;


public interface feeCategoryService {

	List<FeeCategory> getFeeCategory();

	FeeCategory createFeeCategory(FeeCategory feecategory);

	void deleteFeeCategory(Long feeCategoryId);

	FeeCategory updateFeeCategory(FeeCategory feecategory);

	FeeCategory getFeeCategoryByUsingId(Long feeCategoryId);

	List<FeeCategory> getFeeCategoryByUsingName(String feeCategory);

	List<FeeCategory> getFeeCategoryListUsingQuery();

}
