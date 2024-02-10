package com.main.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.main.entities.FeeCategory;

@Repository
public interface feeCategoryRepository extends JpaRepository<FeeCategory,Long> {

	List<FeeCategory> findByFeeCategory(String feeCategory);
	
	@Query("select f from FeeCategory f")
	List<FeeCategory> getFeeCategory();
	
	@Query("select f from FeeCategory f where f.feeCategory=	:n")
	List<FeeCategory> findByFeeCategoryUsingQuery(@Param("n") String feeCategory);
	
}
