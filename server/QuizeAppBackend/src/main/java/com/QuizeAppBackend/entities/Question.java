package com.QuizeAppBackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY) 
	int quid ; 
	String question; 
	String option1; 
	String option2; 
	String option3 ; 
	String option4 ; 
	String correctOption; 
	@ManyToOne
	Quize quize;
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
	public Quize getQuize() {
		return quize;
	}
	public void setQuize(Quize quize) {
		this.quize = quize;
	}
	public Question(int quid, String question, String option1, String option2, String option3, String option4,
			String correctOption, Quize quize) {
		super();
		this.quid = quid;
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.correctOption = correctOption;
		this.quize = quize;
	}
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	
}
