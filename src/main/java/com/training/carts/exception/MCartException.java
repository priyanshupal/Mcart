package com.training.carts.exception;

public class MCartException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MCartException() {
		super();
	}
	
	public MCartException(String errors) {
		super(errors);
	}
	
}
