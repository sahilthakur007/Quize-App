package com.QuizeAppBackend.Service;

import java.util.List;
import java.util.Set;

import com.QuizeAppBackend.Payload.QuestionDto;
import com.QuizeAppBackend.entities.Question;

public interface QuestionService {

	QuestionDto createQuestion(QuestionDto questiondto, int quizeid);
	QuestionDto updateQuestion(QuestionDto questiondto,int questionid);
	void deleteQuestion(int questionid); 
    List<QuestionDto>getAllQuestionByQuize(int qid); 
	
}
