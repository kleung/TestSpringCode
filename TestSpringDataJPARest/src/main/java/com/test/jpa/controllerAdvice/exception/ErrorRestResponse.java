package com.test.jpa.controllerAdvice.exception;

import java.io.Serializable;

public class ErrorRestResponse {
	
	protected String errorMessage;
	
	public ErrorRestResponse() {
		super();
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
