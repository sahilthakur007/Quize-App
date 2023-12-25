package com.QuizeAppBackend.Security;

import com.QuizeAppBackend.Payload.UserDto;

public class JWTAuthResponse {

	private String token;
    private UserDto user; 
    
	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	
	public JWTAuthResponse(String token, UserDto user) {
		super();
		this.token = token;
		this.user = user;
	}

	public JWTAuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
}
