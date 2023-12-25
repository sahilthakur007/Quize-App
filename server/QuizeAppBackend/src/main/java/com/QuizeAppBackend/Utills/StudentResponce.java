package com.QuizeAppBackend.Utills;

import java.util.List;

import com.QuizeAppBackend.Payload.UserDto;

public class StudentResponce {

	List<UserDto>students; 
	List<Integer>addedStudents;
	public List<UserDto> getStudents() {
		return students;
	}
	public void setStudents(List<UserDto> students) {
		this.students = students;
	}
	public List<Integer> getAddedStudents() {
		return addedStudents;
	}
	public void setAddedStudents(List<Integer> addedStudents) {
		this.addedStudents = addedStudents;
	}
	public StudentResponce() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
