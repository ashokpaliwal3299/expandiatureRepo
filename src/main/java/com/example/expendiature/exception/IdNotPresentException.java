package com.example.expendiature.exception;

public class IdNotPresentException extends RuntimeException {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

    public IdNotPresentException() {};
    
    public IdNotPresentException(String msg) {
    	super(msg);
    	this.message = msg;
    }
}
