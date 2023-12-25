package com.QuizeAppBackend.Service.ServiceImplemantation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.QuizeAppBackend.Exception.ResourceNotFoundException;
import com.QuizeAppBackend.Payload.QuizeDto;
import com.QuizeAppBackend.Repositories.Quizedao;
import com.QuizeAppBackend.Repositories.Studentdao;
import com.QuizeAppBackend.Repositories.Teacherdao;
import com.QuizeAppBackend.Service.quizeService;
import com.QuizeAppBackend.entities.Quize;
import com.QuizeAppBackend.entities.Student;
import com.QuizeAppBackend.entities.Teacher;

import jakarta.annotation.Resource;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class quizeServiceImpl implements quizeService {

	@Autowired
	ModelMapper modelmapper; 
	@Autowired
	Quizedao qr; 
	@Autowired
	Teacherdao tr; 
	@Autowired 
	Studentdao sr; 
	@Override
	public QuizeDto createQuize(QuizeDto quiz ,int tid) {
		// TODO Auto-generated method stub
		Quize quize  = modelmapper.map(quiz, Quize.class);
		Teacher teacher = tr.findById(tid).orElseThrow(()->new ResourceNotFoundException("teacher","teacher_id",tid)); 
		quize.setTeacher(teacher);
		quize.setIsstarted(false);
		Quize savedquize = qr.save(quize); 
		return modelmapper.map(savedquize, QuizeDto.class);
		
	}

	@Override
	public void startQuize(int qid) {
		// TODO Auto-generated method stub
		Quize  quize = qr.findById(qid).orElseThrow(()->new ResourceNotFoundException("quize", "quize_id", qid));
		quize.setIsstarted(true);
		qr.save(quize); 
	}

	@Override
	public void stopQuize(int qid) {
		// TODO Auto-generated method stub
		Quize  quize = qr.findById(qid).orElseThrow(()->new ResourceNotFoundException("quize", "quize_id", qid));
		quize.setIsstarted(false);
		qr.save(quize); 
		

	}

	@Override
	public void deleteQuize(int qid) {
		// TODO Auto-generated method stub
		Quize  quize = qr.findById(qid).orElseThrow(()->new ResourceNotFoundException("quize", "quize_id", qid));
		qr.delete(quize);
		
	}

	@Override
	public List<QuizeDto> findQuizeByTeacher(int tid) {
		// TODO Auto-generated method stub
		
		Teacher teacher = tr.findById(tid).orElseThrow(()->new ResourceNotFoundException("teacher","teacher_id",tid)); 
		List<Quize>quizes = qr.findByTeacher(teacher); 
		
		List<QuizeDto>quizesdtos = quizes.stream().map((quize)->(modelmapper.map(quize,QuizeDto.class))).collect(Collectors.toList());
		return quizesdtos; 
	}

	@Override
	public QuizeDto updateQuize(QuizeDto quizdto, int qid) {
		// TODO Auto-generated method stub
		
		Quize  quize = qr.findById(qid).orElseThrow(()->new ResourceNotFoundException("quize", "quize_id", qid));
        quize.setName(quizdto.getName());
        quize.setTime(quizdto.getTime());
        quize.setMarkspq(quizdto.getMarkspq());
        Quize savedQuize = qr.save(quize); 
		return  modelmapper.map(savedQuize, QuizeDto.class) ;
	}



}
