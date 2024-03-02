package com.nokorweb.phoneshop.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(ApiException.class)
	public ResponseEntity<?> handleApiException(ApiException e){
		ErrorException errorException = new ErrorException(e.getHttpStatus(), e.getMessage());
		
		return ResponseEntity.status(errorException.getHttpStatus())
				.body(errorException);
	}
	
}
