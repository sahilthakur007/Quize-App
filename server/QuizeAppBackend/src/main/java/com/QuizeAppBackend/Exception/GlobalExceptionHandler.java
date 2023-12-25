package com.QuizeAppBackend.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.QuizeAppBackend.Utills.ResponceAPI;

@RestControllerAdvice
public class GlobalExceptionHandler {

	 @ExceptionHandler(ResourceNotFoundException.class)
		public ResponseEntity<ResponceAPI>resourceNotFoundExeption(ResourceNotFoundException ex)
		{
	    	ResponceAPI response  = new ResponceAPI(ex.getMessage(), false);
			return new ResponseEntity<ResponceAPI>(response,HttpStatus.NOT_FOUND); 
		}
	 
	 @ExceptionHandler(SecurityException.class)
		public ResponseEntity<ResponceAPI>securityExeption(SecurityException ex)
		{
	    	ResponceAPI response  = new ResponceAPI(ex.getMessage(), false);
			return new ResponseEntity<ResponceAPI>(response,HttpStatus.NOT_FOUND); 
		}
	 
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Map<String, String>>methodArgumentNotValid(MethodArgumentNotValidException ex)
	    {
	    	Map<String, String> errors = new HashMap<>(); 
	    	ex.getBindingResult().getAllErrors().forEach((error)->{
	    		String fieldname = ((FieldError)error).getField();
	    		String message   = error.getDefaultMessage();
	    		errors.put(fieldname, message); 
	    	});
	    	
	    	return new ResponseEntity<Map<String,String>>(errors,HttpStatusCode.valueOf(400));
	    	
	    }
	    
	    @ExceptionHandler(DataIntegrityViolationException.class)
	    public ResponseEntity<ResponceAPI>dataIntegrityvietion(DataIntegrityViolationException ex)
	    {
	    	ResponceAPI response  = new ResponceAPI("Email ID is already used", false);
			return new ResponseEntity<ResponceAPI>(response,HttpStatus.NOT_FOUND);     	
	    }
	    
	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<ResponceAPI>allException(Exception e)
	    {
	    	return new ResponseEntity<ResponceAPI>(new ResponceAPI("Some thing went wrong",false),HttpStatus.BAD_REQUEST);
	    }
	    
	    
}
