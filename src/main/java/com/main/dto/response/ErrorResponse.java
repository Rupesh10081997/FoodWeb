package com.main.dto.response;

public class ErrorResponse {
	private String error;
	private String error_desc;
	@Override
	public String toString() {
		return "ErrorResponse [error=" + error + ", error_desc=" + error_desc + "]";
	}
	public String getError() {
		return error;
	}
	public ErrorResponse(String error, String error_desc) {
		super();
		this.error = error;
		this.error_desc = error_desc;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getError_desc() {
		return error_desc;
	}
	public void setError_desc(String error_desc) {
		this.error_desc = error_desc;
	}
}
