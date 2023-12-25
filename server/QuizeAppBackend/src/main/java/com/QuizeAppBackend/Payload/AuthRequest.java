package com.QuizeAppBackend.Payload;

import jakarta.validation.constraints.NotBlank;

public class AuthRequest {

	@NotBlank
	private String username ; 
	@NotBlank
	private String password ;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AuthRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public AuthRequest() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	
	
}
