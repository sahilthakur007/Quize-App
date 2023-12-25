package com.QuizeAppBackend.Payload;

import java.util.Date;

import com.QuizeAppBackend.entities.Quize;
import com.QuizeAppBackend.entities.Student;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

public class HistoryDto {
    
	int hid; 
	
	Date date ;
	@NotNull
	int marks; 
	
	QuizeDto quize;
	UserDto student ;
	public HistoryDto(int hid, Date date, @NotNull int marks, QuizeDto quize, UserDto student) {
		super();
		this.hid = hid;
		this.date = date;
		this.marks = marks;
		this.quize = quize;
		this.student = student;
	}
	public HistoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public QuizeDto getQuize() {
		return quize;
	}
	public void setQuize(QuizeDto quize) {
		this.quize = quize;
	}
	public UserDto getStudent() {
		return student;
	}
	public void setStudent(UserDto student) {
		this.student = student;
	}
	
	
	
}
