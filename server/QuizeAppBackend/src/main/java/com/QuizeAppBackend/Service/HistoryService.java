package com.QuizeAppBackend.Service;

import java.util.List;

import com.QuizeAppBackend.Payload.HistoryDto;

public interface HistoryService {

	void submitQuize(HistoryDto historydto,int sid, int qid);
	List<HistoryDto>getStudentHistory(int sid);
	List<HistoryDto>getQuizeHistory(int qid); 
}
