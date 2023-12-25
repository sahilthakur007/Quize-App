package com.QuizeAppBackend.Service.ServiceImplemantation;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.QuizeAppBackend.Exception.ResourceNotFoundException;
import com.QuizeAppBackend.Payload.QuestionDto;
import com.QuizeAppBackend.Repositories.Questiondao;
import com.QuizeAppBackend.Repositories.Quizedao;
import com.QuizeAppBackend.Service.QuestionService;
import com.QuizeAppBackend.entities.Question;
import com.QuizeAppBackend.entities.Quize;

@Service
public class QuestionServiceImpl  implements QuestionService {

	@Autowired
	Quizedao quizer ; 
	@Autowired
	Questiondao questionr; 
	
	@Autowired 
	ModelMapper modelmapper; 
	
	@Override
	public QuestionDto createQuestion(QuestionDto questiondto, int quizeid) {
		// TODO Auto-generated method stub
		Question question = modelmapper.map(questiondto, Question.class); 
		Quize  quize = quizer.findById(quizeid).orElseThrow(()->new ResourceNotFoundException("quize", "quize_id", quizeid));
		question.setQuize(quize);
		Question savedquestion  = questionr.save(question); 
		
	
		return modelmapper.map(savedquestion, QuestionDto.class);
	}

	@Override
	public QuestionDto updateQuestion(QuestionDto questiondto, int questionid) {
		// TODO Auto-generated method stub
		Question question  = questionr.findById(questionid).orElseThrow(()->(new ResourceNotFoundException("Question", "question_id", questionid)));
		question.setQuestion(questiondto.getQuestion());
		question.setOption1(questiondto.getOption1());
		question.setOption2(questiondto.getOption2());
		question.setOption3(questiondto.getOption3());
		question.setOption4(questiondto.getOption4());
		question.setCorrectOption(questiondto.getCorrectOption());
		Question savedquestion  = questionr.save(question); 	
		return modelmapper.map(savedquestion, QuestionDto.class);

	}

	@Override
	public void deleteQuestion(int questionid) {
		// TODO Auto-generated method stub
		Question question  = questionr.findById(questionid).orElseThrow(()->(new ResourceNotFoundException("Question", "question_id", questionid)));
         questionr.delete(question);
	}

	@Override
	public List<QuestionDto> getAllQuestionByQuize(int quizeid) {
		// TODO Auto-generated method stub
		Quize  quize = quizer.findById(quizeid).orElseThrow(()->new ResourceNotFoundException("quize", "quize_id", quizeid));
		Set<Question> quizes = quize.getQuestions();
	    return quizes.stream().map((q)->modelmapper.map(q, QuestionDto.class)).collect(Collectors.toList());
	}

}
