package com.example.expendiature.exception;

public class NoRecordsFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String massage;
	
	public NoRecordsFoundException() {
		
	}

	public NoRecordsFoundException(String massage) {
		super(massage);
		this.massage = massage;
	}
	
	
}
