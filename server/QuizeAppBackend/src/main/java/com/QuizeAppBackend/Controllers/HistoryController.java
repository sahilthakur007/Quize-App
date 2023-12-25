package com.QuizeAppBackend.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.QuizeAppBackend.Payload.HistoryDto;
import com.QuizeAppBackend.Service.HistoryService;
import com.QuizeAppBackend.Service.ServiceImplemantation.HistoryServiceImpl;
import com.QuizeAppBackend.Utills.ResponceAPI;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/history")
@CrossOrigin("*")
public class HistoryController {

	@Autowired
	HistoryServiceImpl historyservice; 
	
	@PostMapping("/submit/quize/{quizeid}/student/{studentid}")
	ResponseEntity<ResponceAPI>submitQuize(@Valid @RequestBody HistoryDto historydto,@PathVariable("quizeid") int qid, @PathVariable("studentid") int sid)
	{
		try{
			historyservice.submitQuize(historydto, sid, qid); 
			return new ResponseEntity<ResponceAPI>(new ResponceAPI("Quize submited succesfully", true), HttpStatus.OK);

		}
		catch(Exception e)
		{
			return new ResponseEntity<ResponceAPI>(new ResponceAPI(e.getMessage(), false), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/student/{studentid}")
	ResponseEntity<?>findHistoryByStudent(@PathVariable("studentid") int sid)
	{
		try {
			
			List<HistoryDto> historydto =historyservice.getStudentHistory(sid);
			return new ResponseEntity<List<HistoryDto>>(historydto, HttpStatus.OK);

		}
		catch(Exception e)
		{
			return new ResponseEntity<ResponceAPI>(new ResponceAPI("Unable to load your history", false), HttpStatus.BAD_REQUEST);

		}
	}
	
	@GetMapping("/quize/{quizeid}")
	ResponseEntity<?>findHistoryByQuize(@PathVariable("quizeid") int qid)
	{
		try {
			
			List<HistoryDto> historydto =historyservice.getQuizeHistory(qid);
			return new ResponseEntity<List<HistoryDto>>(historydto, HttpStatus.OK);

		}
		catch(Exception e)
		{
			return new ResponseEntity<ResponceAPI>(new ResponceAPI("Unable to load quize history", false), HttpStatus.BAD_REQUEST);

		}
	}

}
