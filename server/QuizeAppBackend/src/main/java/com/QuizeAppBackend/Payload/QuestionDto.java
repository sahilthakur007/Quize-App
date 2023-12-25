package com.QuizeAppBackend.Payload;

import com.QuizeAppBackend.entities.Quize;

import jakarta.validation.constraints.NotBlank;


public class QuestionDto {
	int quid ; 
	@NotBlank
	String question; 
	@NotBlank
	String option1;
	@NotBlank
	String option2;
	@NotBlank
	String option3 ; 
	@NotBlank
	String option4 ;
	@NotBlank

	String correctOption;
	public int getQuid() {
		return quid;
	}
	public void setQuid(int quid) {
		this.quid = quid;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public String getCorrectOption() {
		return correctOption;
	}
	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}
	public QuestionDto(int quid, String question, String option1, String option2, String option3, String option4,
			String correctOption) {
		super();
		this.quid = quid;
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.correctOption = correctOption;
	}
	public QuestionDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
