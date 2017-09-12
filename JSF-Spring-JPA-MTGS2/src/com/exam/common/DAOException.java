/**
 * @author Zaw Than Oo
 */

package com.exam.common;

public class DAOException extends Exception {
	private static final long serialVersionUID = -1191209777458392054L;

	public DAOException(String message) {
		super(message);
	}
	
	public DAOException(Throwable throwable) {
		super(throwable);
	}

	public DAOException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
