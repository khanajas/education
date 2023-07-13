package com.kfh.college.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlers {
	
	 @ExceptionHandler(StudentNotFoundException.class)
	    public ResponseEntity<?> handleBookAPIException(StudentNotFoundException studentNotFound){
	        Map<String, String> errorMap = new HashMap<>();
	        errorMap.put("error message", studentNotFound.getMessage());
	        errorMap.put("status", HttpStatus.BAD_REQUEST.toString());
	        return ResponseEntity.ok(errorMap);
	    }

}
