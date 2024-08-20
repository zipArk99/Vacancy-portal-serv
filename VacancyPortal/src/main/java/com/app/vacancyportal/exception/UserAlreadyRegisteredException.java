package com.app.vacancyportal.exception;

public class UserAlreadyRegisteredException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAlreadyRegisteredException(String str) {
		super(str);	
		}

}
