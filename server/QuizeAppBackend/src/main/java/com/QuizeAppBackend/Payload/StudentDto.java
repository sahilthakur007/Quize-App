package com.QuizeAppBackend.Payload;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

public class StudentDto {

	
	int sid; 
	int uid ;
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
	public StudentDto(int sid, int uid) {
		super();
		this.sid = sid;
		this.uid = uid;
	}
	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
}
