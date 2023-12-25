package com.QuizeAppBackend.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int sid;
	
	int uid ;
    
	@ManyToMany
	Set<Quize>quizes = new HashSet<Quize>(); 
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public Student(int sid, int uid) {
		super();
		this.sid = sid;
		this.uid = uid;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	
	
}
