package com.QuizeAppBackend.Controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

import com.QuizeAppBackend.Payload.QuestionDto;
import com.QuizeAppBackend.Service.ServiceImplemantation.QuestionServiceImpl;
import com.QuizeAppBackend.Utills.ResponceAPI;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionControllers {

	@Autowired
	QuestionServiceImpl questionService;
	
	@PostMapping("/create/{quizeid}")
	ResponseEntity<?>createQuestion(@Valid @RequestBody QuestionDto questiondto, @PathVariable("quizeid") int qid)
	{
		try {
			
			QuestionDto question = questionService.createQuestion(questiondto, qid); 
			return new ResponseEntity<QuestionDto>(question,HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new  ResponseEntity<ResponceAPI>(new ResponceAPI("Unable to save question",false),HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping("/update/{questionid}")
	ResponseEntity<?>updateQuestion(@Valid @RequestBody QuestionDto questiondto, @PathVariable("questionid") int qid )
	{
     try {
			
			QuestionDto question = questionService.updateQuestion(questiondto, qid); 
			return new ResponseEntity<QuestionDto>(question,HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new  ResponseEntity<ResponceAPI>(new ResponceAPI("Unable to update question",false),HttpStatus.BAD_REQUEST);
		}

	}
	@DeleteMapping("/delete/{question_id}")
	ResponseEntity<ResponceAPI>deleteQuestion(@PathVariable("question_id") int qid)
	{
		try {
			
			questionService.deleteQuestion(qid); 
			return new  ResponseEntity<ResponceAPI>(new ResponceAPI("Question deleted succesfully",true),HttpStatus.OK);

		}
		catch(Exception e)
		{
			return new  ResponseEntity<ResponceAPI>(new ResponceAPI("Unable to delete question",false),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/quize/{quizeid}")
	ResponseEntity<?>getQuestionByQuize(@PathVariable("quizeid") int qid)
	{
		try {
			
			List<QuestionDto> questionsdto = questionService.getAllQuestionByQuize(qid);  
			return new ResponseEntity<List<QuestionDto>>(questionsdto,HttpStatus.OK); 
		}
		catch(Exception e)
		{
			return new  ResponseEntity<ResponceAPI>(new ResponceAPI("Unable to load question",false),HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
}
