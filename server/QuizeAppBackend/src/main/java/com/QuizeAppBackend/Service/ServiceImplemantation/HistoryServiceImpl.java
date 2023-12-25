package com.QuizeAppBackend.Service.ServiceImplemantation;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.QuizeAppBackend.Exception.ResourceNotFoundException;
import com.QuizeAppBackend.Payload.HistoryDto;
import com.QuizeAppBackend.Repositories.Historydao;
import com.QuizeAppBackend.Repositories.Quizedao;
import com.QuizeAppBackend.Repositories.Studentdao;
import com.QuizeAppBackend.Repositories.Userdao;
import com.QuizeAppBackend.Service.HistoryService;
import com.QuizeAppBackend.entities.History;
import com.QuizeAppBackend.entities.Quize;
import com.QuizeAppBackend.entities.Student;
import com.QuizeAppBackend.entities.User;


@Service
public class HistoryServiceImpl implements HistoryService {

	@Autowired 
    Quizedao qr ; 
	@Autowired
	Studentdao sr; 
	@Autowired 
	Historydao hr; 
	@Autowired 
	Userdao ur; 
	@Autowired
	ModelMapper modelmapper ; 
	
	
	@Override
	public void submitQuize(HistoryDto historydto, int sid, int qid) {
		// TODO Auto-generated method stub
		User student = ur.findByStudent(sid).orElseThrow(()->(new ResourceNotFoundException("user","sid",sid))); 
		Quize  quize = qr.findById(qid).orElseThrow(()->new ResourceNotFoundException("quize", "quize_id", qid));
		
		History history = modelmapper.map(historydto, History.class); 
		System.out.println(historydto.getMarks());
		history.setDate(new Date());
		history.setQuize(quize);
		history.setStudent(student);
		hr.save(history); 
		
	}

	@Override
	public List<HistoryDto> getStudentHistory(int sid) {
		User student = ur.findById(sid).orElseThrow(()->(new ResourceNotFoundException("student","sid",sid))); 
         List<History>allhistory = hr.findByStudent(student); 
         List<HistoryDto>allhistorydto =allhistory.stream().map((history)->(modelmapper.map(history, HistoryDto.class))).collect(Collectors.toList());
		return allhistorydto ;
	}

	@Override
	public List<HistoryDto> getQuizeHistory(int qid) {
		// TODO Auto-generated method stub
		Quize  quize = qr.findById(qid).orElseThrow(()->new ResourceNotFoundException("quize", "quize_id", qid));
		List<History>allhistory = hr.findByQuize(quize); 
        List<HistoryDto>allhistorydto =allhistory.stream().map((history)->(modelmapper.map(history, HistoryDto.class))).collect(Collectors.toList());
		return allhistorydto ;	
        }

}
