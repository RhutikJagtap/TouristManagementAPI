package com.rj.TouristManagement.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rj.TouristManagement.exception.ExceptionResponse;
import com.rj.TouristManagement.exception.TouristNotFoundException;

@RestControllerAdvice
public class APIExceptionHandler {
	
	
	@ExceptionHandler(value = TouristNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleTouristNotFoundException(TouristNotFoundException t)
	{
		ExceptionResponse exceptionResponse = new ExceptionResponse("404 not found",t.toString(),LocalDateTime.now());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ExceptionResponse> handleAllException(Exception exception)
	{
		ExceptionResponse exceptionResponse = new ExceptionResponse("Internal server error ",exception.getMessage(),LocalDateTime.now());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
