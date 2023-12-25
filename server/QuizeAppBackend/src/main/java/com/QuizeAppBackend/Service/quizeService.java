package com.QuizeAppBackend.Service;

import java.util.List;

import com.QuizeAppBackend.Payload.QuizeDto;
import com.QuizeAppBackend.entities.Quize;

public interface quizeService {

	QuizeDto createQuize(QuizeDto quiz,int tid); 
	QuizeDto updateQuize(QuizeDto quiz,int qid); 
	void startQuize(int qid); 
	void stopQuize(int qid); 
	void deleteQuize(int qid); 
	List<QuizeDto> findQuizeByTeacher(int tid); 
//	List<QuizeDto> findActiveQuizeForStudent(int sid); 
}
