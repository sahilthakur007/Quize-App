package com.QuizeAppBackend.Service;

import java.util.List;

import com.QuizeAppBackend.Payload.QuizeDto;
import com.QuizeAppBackend.Payload.UserDto;
import com.QuizeAppBackend.Utills.ListInput;
import com.QuizeAppBackend.Utills.StudentResponce;
import com.QuizeAppBackend.entities.Quize;
import com.QuizeAppBackend.entities.User;

public interface StudentService {

//	add students ; 
	
	void addStudents(ListInput sid,int qid); 
	
//	remove students; 
	void removeStudent(ListInput sid,int qid); 
//	send students for teacher 
	
	StudentResponce getAllStudent(int qid);
	
	//	send quize to student ; 
	List<QuizeDto>getAllQuize(int sid,int uid); 
//	view history or past quize performance ; 

}
