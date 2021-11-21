package com.iii.amirutham.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "old Password does bot Matched ")
public class InvalidOldPasswordException extends RuntimeException {
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidOldPasswordException(String message) {
	        super(message);
	    }

	    public InvalidOldPasswordException(String message, Throwable cause) {
	        super(message, cause);
	    }
}