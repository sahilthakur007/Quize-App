package com.QuizeAppBackend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.QuizeAppBackend.Payload.StudentDto;
import com.QuizeAppBackend.Payload.UserDto;
import com.QuizeAppBackend.Service.ServiceImplemantation.UserServiceImpl;
import com.QuizeAppBackend.Utills.ResponceAPI;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	UserServiceImpl userService; 
	
	@PostMapping("/create")
	ResponseEntity<?> createUser(@Valid @RequestBody UserDto userdto)
	{
//		System.out.println("Reached");
	try {
		
		UserDto user = userService.createUser(userdto); 
		return new ResponseEntity<UserDto>(user, HttpStatus.CREATED); 
	}
	catch(Exception e)
	{
    	return new ResponseEntity<ResponceAPI>(new ResponceAPI("unable to create user" ,false) ,HttpStatus.BAD_REQUEST);

	}
	}
}
