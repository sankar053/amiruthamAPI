package com.iii.amirutham.exception;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.iii.amirutham.dto.base.GenericResponse;


@ControllerAdvice
@RestController
public class AmirthumExceptuinHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messages;

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		logger.error("500 Status Code", ex);
		final GenericResponse bodyOfResponse = new GenericResponse(
				messages.getMessage("message.error", null, request.getLocale()), "InternalError");
		return new ResponseEntity<>(bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleNotFoundException(UserNotFoundException ex, WebRequest request)
			throws Exception {
		ExceptionResponse exceptionResponse = new ExceptionResponse("4000", ex.getMessage(), new Date(),
				request.getDescription(false));

		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.UNPROCESSABLE_ENTITY);

	}
	
	@ExceptionHandler(InvalidOldPasswordException.class)
	public final ResponseEntity<Object> handleInvalidOldPasswordException(InvalidOldPasswordException ex, WebRequest request)
			throws Exception {
		ExceptionResponse exceptionResponse = new ExceptionResponse("4004", ex.getMessage(), new Date(),
				request.getDescription(false));

		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.UNAUTHORIZED);

	}
	
	@ExceptionHandler(TokenExpireException.class)
	public final ResponseEntity<Object> handleNotFoundException(TokenExpireException ex, WebRequest request)
			throws Exception {
		ExceptionResponse exceptionResponse = new ExceptionResponse("4001", ex.getMessage(), new Date(),
				request.getDescription(false));

		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.UNAUTHORIZED);

	}
	

	// 409
	@ExceptionHandler({ UserAlreadyExistException.class })
	public ResponseEntity<Object> handleUserAlreadyExist(final RuntimeException ex, final WebRequest request) {
		logger.error("409 Status Code", ex);
		final GenericResponse bodyOfResponse = new GenericResponse(
				messages.getMessage("message.regError", null, request.getLocale()), "UserAlreadyExist");
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

	@ExceptionHandler(AmirthumCommonException.class)
	public final ResponseEntity<Object> handleNotFoundException(AmirthumCommonException ex, WebRequest request)
			throws Exception {
		ExceptionResponse exceptionResponse = new ExceptionResponse("4001", ex.getMessage(), new Date(),
				request.getDescription(false));

		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.OK);

	}

	// 500
	@ExceptionHandler({ MailAuthenticationException.class })
	public ResponseEntity<Object> handleMail(final RuntimeException ex, final WebRequest request) {
		logger.error("500 Status Code", ex);
		final GenericResponse bodyOfResponse = new GenericResponse(
				messages.getMessage("message.email.config.error", null, request.getLocale()), "MailError");
		return new ResponseEntity<>(bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex,
			final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
		logger.error("400 Status Code", ex);
		final BindingResult result = ex.getBindingResult();
		final GenericResponse bodyOfResponse = new GenericResponse(result.getAllErrors(),
				"Invalid" + result.getObjectName());
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

}
