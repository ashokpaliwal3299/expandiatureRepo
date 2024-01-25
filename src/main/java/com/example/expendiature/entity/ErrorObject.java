package com.example.expendiature.entity;

public class ErrorObject {
	
	private Integer httpStatus;
	private String massage;
	
	
	public ErrorObject() {
		
	}


	public Integer getHttpStatus() {
		return httpStatus;
	}


	public void setHttpStatus(Integer httpStatus) {
		this.httpStatus = httpStatus;
	}


	public String getMassage() {
		return massage;
	}


	public void setMassage(String massage) {
		this.massage = massage;
	}


	public ErrorObject(Integer httpStatus, String massage) {
		super();
		this.httpStatus = httpStatus;
		this.massage = massage;
	}
	
	

	

	
	
}
