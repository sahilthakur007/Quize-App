package com.QuizeAppBackend.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.QuizeAppBackend.Payload.HistoryDto;
import com.QuizeAppBackend.Payload.QuizeDto;
import com.QuizeAppBackend.Service.TeacherService;
import com.QuizeAppBackend.Service.ServiceImplemantation.TeacherServiceImpl;
import com.QuizeAppBackend.Utills.ResponceAPI;

@RestController
@RequestMapping("/teacher")
@CrossOrigin("*")
public class TeacherController {

	@Autowired
	TeacherServiceImpl teacherService; 
	
	@GetMapping("/{teacherid}")
	ResponseEntity<?>getAllQuizeByTeacher(@PathVariable("teacherid") int tid)
	{
		try {
			
			List<QuizeDto> quizedto =teacherService.getAllQuizeList(tid);
			return new ResponseEntity<List<QuizeDto>>(quizedto, HttpStatus.OK);

		}
		catch(Exception e)
		{
			return new ResponseEntity<ResponceAPI>(new ResponceAPI("Unable to load quize history", false), HttpStatus.BAD_REQUEST);

		}
	}

}
