package com.exception;

public class InvalidPasswordException extends RuntimeException {
	
	public InvalidPasswordException(String mag)
	{
		super(mag);
	}

}


