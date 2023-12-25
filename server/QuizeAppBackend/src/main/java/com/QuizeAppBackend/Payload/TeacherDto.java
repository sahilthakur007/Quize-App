package com.QuizeAppBackend.Payload;

public class TeacherDto {
	int tid; 
	int uid;
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
	public TeacherDto(int tid, int uid) {
		super();
		this.tid = tid;
		this.uid = uid;
	}
	public TeacherDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
