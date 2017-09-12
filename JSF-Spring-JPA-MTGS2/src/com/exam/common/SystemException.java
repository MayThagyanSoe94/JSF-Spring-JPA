package com.exam.common;


import org.springframework.transaction.TransactionSystemException;

public class SystemException extends TransactionSystemException {
	private static final long serialVersionUID = -6449152569923493875L;
	
	private Object response;

	public SystemException(String message) {
		super(message);
	}

	public SystemException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	public SystemException(Object response, String message) {
		super(message);
		this.response = response;
	}

	public Object getResponse() {
		return response;
	}
}
