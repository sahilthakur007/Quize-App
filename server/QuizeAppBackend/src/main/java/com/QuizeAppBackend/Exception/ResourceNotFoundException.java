package com.QuizeAppBackend.Exception;

public class ResourceNotFoundException extends RuntimeException {
	String resourceName;
	String fieldName ;
	long  fieldvalue ;
	String fieldval; 
	public ResourceNotFoundException(String resourceName, String fieldName, long fieldvalue) {
		super(String.format("%s not found with %s: %s", resourceName,fieldName,fieldvalue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldvalue = fieldvalue;
	} 
	
	public ResourceNotFoundException(String resourceName, String fieldName, String fieldval) {
		super(String.format("%s not found with %s: %s", resourceName,fieldName,fieldval));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldval = fieldval;
	} 	
}
