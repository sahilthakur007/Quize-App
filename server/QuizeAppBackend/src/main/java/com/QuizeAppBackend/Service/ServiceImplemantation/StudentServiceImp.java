package com.QuizeAppBackend.Service.ServiceImplemantation;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import com.QuizeAppBackend.Exception.ResourceNotFoundException;
import com.QuizeAppBackend.Payload.QuizeDto;
import com.QuizeAppBackend.Payload.UserDto;
import com.QuizeAppBackend.Repositories.Quizedao;
import com.QuizeAppBackend.Repositories.Studentdao;
import com.QuizeAppBackend.Repositories.Userdao;
import com.QuizeAppBackend.Service.StudentService;
import com.QuizeAppBackend.Utills.ListInput;
import com.QuizeAppBackend.Utills.StudentResponce;
import com.QuizeAppBackend.entities.Quize;
import com.QuizeAppBackend.entities.Student;
import com.QuizeAppBackend.entities.User;
//import javafx.util.Pair;  

@Service
public class StudentServiceImp implements StudentService {

	@Autowired 
    Quizedao qr ; 
	@Autowired
	Studentdao sr; 
	@Autowired 
	Userdao ur; 
	@Autowired
	ModelMapper modelmapper ; 
	
	@Override
	public void addStudents(ListInput sid,int qid) {
		// TODO Auto-generated method stub
		Quize  quize = qr.findById(qid).orElseThrow(()->new ResourceNotFoundException("quize", "quize_id", qid));
        
		List<Student>students = sr.findAllById(sid.getStudentsList());
		quize.getStudents().addAll(students); 
		qr.save(quize);
		
	}

	@Override
	public void removeStudent(ListInput sid,int qid) {
		// TODO Auto-generated method stub
		Quize  quize = qr.findById(qid).orElseThrow(()->new ResourceNotFoundException("quize", "quize_id", qid));
		List<Student>students = sr.findAllById(sid.getStudentsList());
		quize.getStudents().removeAll(students); 
		qr.save(quize);

	}

	@Override
	public StudentResponce getAllStudent(int qid) {
		// TODO Auto-generated method stub
		Quize  quize = qr.findById(qid).orElseThrow(()->new ResourceNotFoundException("quize", "quize_id", qid));
		List<User> users  = ur.findbyUserRole("ROLE_STUDENT"); 
		Set<Student>alreadyaddedStudent = quize.getStudents(); 
		List<Integer>alreadyaddedStudentIds = alreadyaddedStudent.stream().map((s)->(s.getSid())).collect(Collectors.toList()); 
//		Pair<Integer, Integer>p = new Pair<Integer,Integer>("3",4); 
//		Pair<List<User>, List<Integer>>response = new Pair<List<User>, List<Integer>> (users,alreadyaddedStudentIds); 

		List<UserDto>usersdto = users.stream().map((user)->(modelmapper.map(user, UserDto.class))).collect(Collectors.toList()); 
		
		StudentResponce sres = new StudentResponce(); 
		sres.setAddedStudents(alreadyaddedStudentIds);
		sres.setStudents(usersdto);
		return sres;
	}

	@Override
	public List<QuizeDto> getAllQuize(int sid,int uid) {
		// TODO Auto-generated method stub
//		Student student = sr.findById(sid).orElseThrow(()->(new ResourceNotFoundException("student","sid",sid))); 
		System.out.println(uid);
		List<QuizeDto>quizedto  = qr.findByStudents(sid,uid).stream().map((quize)->(modelmapper.map(quize, QuizeDto.class))).collect(Collectors.toList());  
		return quizedto;
	}

}
