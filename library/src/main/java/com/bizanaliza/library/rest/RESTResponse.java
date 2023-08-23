package com.bizanaliza.library.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RESTResponse {

	public int code;
	public String errorMessage;
	
	
	//------- Getters Setters ----------//
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	//za error response
	public void setErrorCode(ErrorMessages em) {
		this.setCode(em.getCode());
		this.setErrorMessage(em.getMessage());
	}
	
	
	
}
