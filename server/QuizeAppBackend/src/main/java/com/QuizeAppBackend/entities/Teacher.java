package com.QuizeAppBackend.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int tid; 
	int uid;
    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)	
	Set<Quize>quizes = new HashSet<Quize>(); 
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Set<Quize> getQuizes() {
		return quizes;
	}
	public void setQuizes(Set<Quize> quizes) {
		this.quizes = quizes;
	}
	public Teacher(int tid, int uid, Set<Quize> quizes) {
		super();
		this.tid = tid;
		this.uid = uid;
		this.quizes = quizes;
	} 
	
	
	
}
