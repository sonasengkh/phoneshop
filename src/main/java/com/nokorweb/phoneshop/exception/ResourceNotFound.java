package com.nokorweb.phoneshop.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFound extends ApiException{

	public ResourceNotFound(String ResourceName, Integer id) {
		super(HttpStatus.NOT_FOUND, "Can't find " + ResourceName + " Id " + id);
		
	}

	
	
}
