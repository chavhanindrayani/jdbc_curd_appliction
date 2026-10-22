package com.exception;

public class InvalidUserIdException extends RuntimeException {

	public InvalidUserIdException(String mag)
	{
		super(mag);
	}
}
