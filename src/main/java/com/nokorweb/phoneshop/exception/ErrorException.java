package com.nokorweb.phoneshop.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.RequiredArgsConstructor;
@Data
@RequiredArgsConstructor
public class ErrorException {
	private final HttpStatus httpStatus;
	private final String message;
}
