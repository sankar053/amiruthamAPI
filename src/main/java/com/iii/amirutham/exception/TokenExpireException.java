/**
 * 
 */
package com.iii.amirutham.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author sanka
 *
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class TokenExpireException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public TokenExpireException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
