package com.QuizeAppBackend.Utills;

import java.util.List;

public class ListInput {

	List<Integer>studentsList;

	public List<Integer> getStudentsList() {
		return studentsList;
	}

	public void setStudentsList(List<Integer> studentsList) {
		this.studentsList = studentsList;
	}

	public ListInput(List<Integer> studentsList) {
		super();
		this.studentsList = studentsList;
	}

	public ListInput() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	
}
