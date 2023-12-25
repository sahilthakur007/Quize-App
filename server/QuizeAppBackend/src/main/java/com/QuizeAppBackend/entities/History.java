package com.QuizeAppBackend.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class History {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int hid;
	
	Date date ; 
	int marks; 
//	@Id
	@ManyToOne
	@JoinColumn(nullable = false)
	Quize quize;
	
//	@Id
	@ManyToOne
	@JoinColumn(nullable = false)
	User student ;

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

	public Quize getQuize() {
		return quize;
	}

	public void setQuize(Quize quize) {
		this.quize = quize;
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}

	public History(int hid, Date date, int marks, Quize quize, User student) {
		super();
		this.hid = hid;
		this.date = date;
		this.marks = marks;
		this.quize = quize;
		this.student = student;
	}

	public History() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	
	

}
