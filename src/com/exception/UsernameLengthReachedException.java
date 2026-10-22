package com.exception;

public class UsernameLengthReachedException extends RuntimeException {

	public UsernameLengthReachedException(String mag)
	{
		super(mag);
	}
}
