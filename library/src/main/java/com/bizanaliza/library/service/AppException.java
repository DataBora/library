package com.bizanaliza.library.service;

import javax.ejb.ApplicationException;

import com.bizanaliza.library.rest.ErrorMessages;

@ApplicationException(rollback = true)
public class AppException extends RuntimeException{
	
	private ErrorMessages error;
	
	public AppException(ErrorMessages error) {
		this.error = error;
	}

	//----- Getters Setters ------//
	public ErrorMessages getError() {
		return error;
	}

	public void setError(ErrorMessages error) {
		this.error = error;
	}
	
	
	
}
