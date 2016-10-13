package br.com.rudolfoborges.utils.exceptions;

import org.springframework.http.HttpStatus;

public abstract class ApplicationException extends RuntimeException {

	private HttpStatus httpStatus;

	public ApplicationException(String message, HttpStatus httpStatus){
		super(message);
		this.httpStatus = httpStatus;;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
}
