package com.exception;

public class InvalidBlogDataException extends RuntimeException {
	public InvalidBlogDataException(String s) {
		super(s);
	}
}
