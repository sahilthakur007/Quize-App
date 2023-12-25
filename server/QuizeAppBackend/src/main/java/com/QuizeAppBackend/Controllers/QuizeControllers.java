package com.QuizeAppBackend.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.QuizeAppBackend.Payload.QuizeDto;
import com.QuizeAppBackend.Service.quizeService;
import com.QuizeAppBackend.Service.ServiceImplemantation.quizeServiceImpl;
import com.QuizeAppBackend.Utills.ResponceAPI;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/quize")
@CrossOrigin("*")
public class QuizeControllers {

	@Autowired
	quizeServiceImpl quizeService; 
	
	@PostMapping("/create/{teacherid}")
	ResponseEntity<?>creteQuize(@Valid @RequestBody QuizeDto quizedto,@PathVariable("teacherid") int tid)
	{
             try {
         		QuizeDto quize  = quizeService.createQuize(quizedto,tid );
         		return new ResponseEntity<QuizeDto>(quize, HttpStatus.CREATED); 

             }
             catch(Exception e)
             {
            	return new ResponseEntity<ResponceAPI>(new ResponceAPI(e.getMessage() ,false) ,HttpStatus.BAD_REQUEST);
             }
	}
	
	@PutMapping("/update/{quizeid}")
	ResponseEntity<?>updateQuize(@Valid @RequestBody QuizeDto quizedto,@PathVariable("quizeid") int qid)
	{
		try {
     		QuizeDto quize  = quizeService.updateQuize(quizedto,qid );
     		return new ResponseEntity<QuizeDto>(quize, HttpStatus.OK); 

         }
         catch(Exception e)
         {
        	return new ResponseEntity<ResponceAPI>(new ResponceAPI("Unable to update quize" ,false) ,HttpStatus.BAD_REQUEST);
         }
	}
	
	
	@PutMapping("/start/{quize_id}")
	ResponseEntity<ResponceAPI>startQuize(@PathVariable("quize_id") int qid)
	{
		try {
			quizeService.startQuize(qid); 
        	return new ResponseEntity<ResponceAPI>(new ResponceAPI("quize is started" ,true) ,HttpStatus.OK);
		}
		catch(Exception e)
		{
        	return new ResponseEntity<ResponceAPI>(new ResponceAPI("Unable to start quize" ,false) ,HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@PutMapping("/stop/{quize_id}")
	ResponseEntity<ResponceAPI>stopQuize(@PathVariable("quize_id") int qid)
	{
		try {
			quizeService.stopQuize(qid); 
        	return new ResponseEntity<ResponceAPI>(new ResponceAPI("quize is stoped" ,true) ,HttpStatus.OK);
		}
		catch(Exception e)
		{
        	return new ResponseEntity<ResponceAPI>(new ResponceAPI("Unable to stop quize" ,false) ,HttpStatus.BAD_REQUEST);

		}
		
	}
	@DeleteMapping("/delete/{quize_id}")
	ResponseEntity<ResponceAPI>deleteQuize(@PathVariable("quize_id") int qid)
	{
		try {
			
			quizeService.deleteQuize(qid); 
        	return new ResponseEntity<ResponceAPI>(new ResponceAPI("quize is deleted succesfully" ,true) ,HttpStatus.OK);
		}
		catch(Exception e)
		{
        	return new ResponseEntity<ResponceAPI>(new ResponceAPI("Unable to delete quize" ,false) ,HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@GetMapping("/teacher/{teacherid}")
	ResponseEntity<?>getQuizesByTeacher(@PathVariable("teacherid") int tid)
	{
	
		try {
		 List<QuizeDto>quizes= 	quizeService.findQuizeByTeacher(tid); 
        	return new ResponseEntity<List<QuizeDto>>(quizes ,HttpStatus.OK);
		}
		catch(Exception e)
		{
        	return new ResponseEntity<ResponceAPI>(new ResponceAPI("Unable to load quizes" ,false) ,HttpStatus.BAD_REQUEST);

		}

	}
}
