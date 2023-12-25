package com.QuizeAppBackend.Payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class QuizeDto {
   
	int qid;
	@NotBlank
	int  time ; 
	@NotNull
	int markspq; 
	@NotBlank
	String name ; 
	@NotNull
	boolean isstarted;
	
	
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getMarkspq() {
		return markspq;
	}
	public void setMarkspq(int markspq) {
		this.markspq = markspq;
	}
	public boolean isIsstarted() {
		return isstarted;
	}
	public void setIsstarted(boolean isstarted) {
		this.isstarted = isstarted;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public QuizeDto(@NotBlank int time, @NotBlank int markspq, @NotBlank String name,  boolean isstarted,int qid) {
		super();
		this.time = time;
		this.markspq = markspq;
		this.name = name;
		this.isstarted = isstarted;
		this.qid = qid; 
	}
	public QuizeDto() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	
}
