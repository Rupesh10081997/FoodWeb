package com.main.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "fee_category")
public class FeeCategory {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long feeCategoryId;
	@NotNull(message="fee Category do not null")
	private String feeCategory;
	private String status="V";
	public Long getFeeCategoryId() {
		return feeCategoryId;
	}
	public void setFeeCategoryId(Long feeCategoryId) {
		this.feeCategoryId = feeCategoryId;
	}
	public String getFeeCategory() {
		return feeCategory;
	}
	public void setFeeCategory(String feeCategory) {
		this.feeCategory = feeCategory;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
