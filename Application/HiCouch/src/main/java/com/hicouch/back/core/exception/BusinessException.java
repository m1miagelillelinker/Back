package com.hicouch.back.core.exception;

public abstract class BusinessException extends Exception {
	
	public BusinessException(String message) {
		super(message);
	}
	
	public BusinessException() {
		super();
	}

}
