package com.QuizeAppBackend.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.QuizeAppBackend.Exception.ResourceNotFoundException;
import com.QuizeAppBackend.Exception.SecurityException;
import com.QuizeAppBackend.Payload.AuthRequest;
import com.QuizeAppBackend.Payload.UserDto;
import com.QuizeAppBackend.Repositories.Userdao;
import com.QuizeAppBackend.Security.CustomUserDetailsService;
import com.QuizeAppBackend.Security.JWTAuthResponse;
import com.QuizeAppBackend.Security.JWTTokenHelper;
import com.QuizeAppBackend.Utills.ResponceAPI;
import com.QuizeAppBackend.entities.User;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

	@Autowired
	CustomUserDetailsService userdetailsservice; 
	@Autowired
	JWTTokenHelper jwttokenhelper; 
	@Autowired
	AuthenticationManager authenticationManager ; 
	@Autowired
	Userdao ur; 
	@Autowired
	ModelMapper modelmapper ;
	@Autowired
	JWTTokenHelper tokenhelper; 
	@PostMapping("/login")
	ResponseEntity<?> login(@RequestBody AuthRequest request)
	{
//		System.out.println("reached");
		try {
			authenticate(request.getUsername(),request.getPassword()); 
			UserDetails userDetails = userdetailsservice.loadUserByUsername(request.getUsername()); 
			
			String token  = jwttokenhelper.generateToken(userDetails); 
			User user = ur.findByEmail(request.getUsername()).orElseThrow(()->(new ResourceNotFoundException("user", "username", request.getUsername())));
			UserDto userdto = modelmapper.map(user, UserDto.class); 
			return new ResponseEntity<JWTAuthResponse>(new JWTAuthResponse(token,userdto),HttpStatus.OK); 
		}
		catch(Exception e)
		{
			return new ResponseEntity<ResponceAPI>(new ResponceAPI("Incorret username or password",false),HttpStatus.BAD_REQUEST); 

		}
		
	}
	
     @GetMapping("/check-token/{token}/{username}")
     public ResponseEntity<?>checkToken(@PathVariable("token") String token, @PathVariable("username") String username){
    	 try {
 			UserDetails userDetails = userdetailsservice.loadUserByUsername(username); 

 			Boolean res =  tokenhelper.validateToken(token, userDetails); 
// 			Boolean res2 =  true ;//tokenhelper.isTokenExpired(token); 
    		 return new ResponseEntity<Boolean>(res,HttpStatus.OK); 
    	 }
    	 catch(Exception e)
    	 {
    		 return new ResponseEntity<Boolean>(false,HttpStatus.OK); 

    	 }
     }
	private void authenticate(String username, String password) {

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password); 

	     authenticationManager.authenticate(authenticationToken); 
	    
	}

	
}
