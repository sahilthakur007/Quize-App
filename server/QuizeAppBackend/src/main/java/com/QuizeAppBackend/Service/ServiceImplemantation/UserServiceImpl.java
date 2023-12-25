package com.QuizeAppBackend.Service.ServiceImplemantation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.QuizeAppBackend.Payload.StudentDto;
import com.QuizeAppBackend.Payload.UserDto;
import com.QuizeAppBackend.Repositories.Studentdao;
import com.QuizeAppBackend.Repositories.Teacherdao;
import com.QuizeAppBackend.Repositories.Userdao;
import com.QuizeAppBackend.Service.UserService;
import com.QuizeAppBackend.entities.Student;
import com.QuizeAppBackend.entities.Teacher;
import com.QuizeAppBackend.entities.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	ModelMapper modelmapper; 
	@Autowired
	Userdao ur;
	@Autowired
	Studentdao sr; 
	@Autowired
	Teacherdao tr; 
	@Autowired
	PasswordEncoder passwordEncoder; 
	
	@Override
	public UserDto createUser(UserDto user) {
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		
//		System.out.println("Hi"+savedUser.getRole()+"Hi");
		if(user.getRole().equalsIgnoreCase("ROLE_STUDENT"))
		{
			Student s = new Student();
//			s.setUid(savedUser.getUid());
			Student savedStudent = sr.save(s); 
			User newUser = modelmapper.map(user , User.class); 
			newUser.setStudent(savedStudent);
			User savedUser = ur.save(newUser); 		
			return modelmapper.map(savedUser, UserDto.class);

		}
		else {
			Teacher t = new Teacher(); 
//			t.setUid(savedUser.getUid());
			Teacher savedTeacher = tr.save(t); 
			User newUser = modelmapper.map(user , User.class); 
			newUser.setTeacher(savedTeacher);
			User savedUser = ur.save(newUser); 		
			return modelmapper.map(savedUser, UserDto.class);

		}
	}

}
