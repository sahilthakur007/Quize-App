package com.QuizeAppBackend.Service.ServiceImplemantation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.QuizeAppBackend.Exception.ResourceNotFoundException;
import com.QuizeAppBackend.Payload.QuizeDto;
import com.QuizeAppBackend.Repositories.Quizedao;
import com.QuizeAppBackend.Repositories.Teacherdao;
import com.QuizeAppBackend.Service.TeacherService;
import com.QuizeAppBackend.entities.Teacher;

@Service
public class TeacherServiceImpl  implements TeacherService{

	@Autowired
	Teacherdao tr;  
	@Autowired 
	Quizedao qr ; 
	@Autowired
	ModelMapper modelmapper ;
	@Override
	public List<QuizeDto> getAllQuizeList(int tid) {

		Teacher teacher = tr.findById(tid).orElseThrow(()->(new ResourceNotFoundException("teacher", "teacherid", tid)));
	     return qr.findByTeacher(teacher).stream().map((quize)->(modelmapper.map(quize, QuizeDto.class))).collect(Collectors.toList()); 
	}
	
	

	
}
