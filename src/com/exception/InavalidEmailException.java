package com.exception;

public class InavalidEmailException extends RuntimeException {

	public InavalidEmailException(String mag)
	{
		super(mag);
	}
}
