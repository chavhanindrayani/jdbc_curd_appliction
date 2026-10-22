package com.Eexception;

public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException(String mag)
	{
		super(mag);
	}
}
