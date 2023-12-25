package com.QuizeAppBackend.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.QuizeAppBackend.Exception.ResourceNotFoundException;
import com.QuizeAppBackend.Repositories.Studentdao;
import com.QuizeAppBackend.Repositories.Userdao;
import com.QuizeAppBackend.entities.Student;
import com.QuizeAppBackend.entities.User;

@Component
public class CustomUserDetailsService implements  UserDetailsService {

	@Autowired
	Userdao ur; 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = ur.findByEmail(username).orElseThrow(()->(new ResourceNotFoundException("Student", "username: ", username))) ;
		return new CustomUserDetails(user);
	}

}
