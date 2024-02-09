package com.zm.rest.exceptionhandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({MethodArgumentNotValidException.class})
	public ResponseEntity<?> handleException(MethodArgumentNotValidException ex){
		List<String> errors = ex.getBindingResult().getFieldErrors()
					.stream()
					.map(except -> except.getDefaultMessage())
					.collect(Collectors.toList());
		
		Map<String, List<String>> resp = new HashMap<>();
		resp.put("message", errors);
		return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
	}
}
