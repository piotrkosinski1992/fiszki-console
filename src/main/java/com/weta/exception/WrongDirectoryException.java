package com.weta.exception;

public class WrongDirectoryException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public WrongDirectoryException(String errorMessage) {
		super(errorMessage);
	}

}
