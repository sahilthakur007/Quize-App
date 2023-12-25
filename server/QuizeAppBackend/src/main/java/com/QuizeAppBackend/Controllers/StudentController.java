package com.QuizeAppBackend.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.QuizeAppBackend.Payload.QuizeDto;
import com.QuizeAppBackend.Service.ServiceImplemantation.StudentServiceImp;
import com.QuizeAppBackend.Utills.ListInput;
import com.QuizeAppBackend.Utills.ResponceAPI;
import com.QuizeAppBackend.Utills.StudentResponce;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {

	@Autowired
	StudentServiceImp studentserice; 
	@PutMapping("/add/quize/{quizeid}")
	ResponseEntity<ResponceAPI>addStudents(@RequestBody ListInput sid,@PathVariable("quizeid") int qid)
	{
		try {
			
			studentserice.addStudents(sid, qid);
			
        	return new ResponseEntity<ResponceAPI>(new ResponceAPI("Student added Succesfully" ,true) ,HttpStatus.OK);

		}
		catch(Exception e )
		{
        	return new ResponseEntity<ResponceAPI>(new ResponceAPI("Unable to add students" ,false) ,HttpStatus.BAD_REQUEST);

		}
	}
	
	
	@PutMapping("/remove/quize/{quizeid}")
	ResponseEntity<ResponceAPI>removeStudents(@RequestBody ListInput sid,@PathVariable("quizeid") int qid)
	{
		try {
			
			studentserice.removeStudent(sid, qid);
			
        	return new ResponseEntity<ResponceAPI>(new ResponceAPI("Student removed Succesfully" ,true) ,HttpStatus.OK);

		}
		catch(Exception e )
		{
        	return new ResponseEntity<ResponceAPI>(new ResponceAPI("Unable to remove students" ,false) ,HttpStatus.BAD_REQUEST);

		}
	}
	
	@GetMapping("/quize/{quizeid}")
	ResponseEntity<?>getAllStudents(@PathVariable("quizeid") int qid)
	{
		try {
			StudentResponce sres =  studentserice.getAllStudent(qid); 
			return new ResponseEntity<StudentResponce>(sres,HttpStatus.OK); 
		}
		catch(Exception e )
		{
        	return new ResponseEntity<ResponceAPI>(new ResponceAPI(e.getMessage() ,false) ,HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@GetMapping("/{studentid}/{userid}")
	ResponseEntity<?>getAllQuizeForStudent(@PathVariable("studentid") int sid,@PathVariable("userid") int uid)
	{
		try {
			List<QuizeDto> quizedto =  studentserice.getAllQuize(sid,uid); 
			return new ResponseEntity<List<QuizeDto>>(quizedto,HttpStatus.OK); 
		}
		catch(Exception e )
		{
        	return new ResponseEntity<ResponceAPI>(new ResponceAPI("Unable to load students" ,false) ,HttpStatus.BAD_REQUEST);

		}
		
	}

	
	
}
