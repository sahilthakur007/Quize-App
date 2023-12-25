package com.QuizeAppBackend.Utills;

public class ResponceAPI {
	String message; 
	boolean success;

	public ResponceAPI(String message, boolean success) {
		super();
		this.message = message;
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public ResponceAPI() {
		super();
		// TODO Auto-generated constructor stub
	} 
}
