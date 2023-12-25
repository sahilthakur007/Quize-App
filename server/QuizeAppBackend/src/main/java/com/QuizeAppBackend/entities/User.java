package com.QuizeAppBackend.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int uid ; 
    String name ;
	@Column(unique = true, nullable = false)
	String  email; 
	String password ;
	@Column(unique = true , nullable = false)
	String phone ;
	
	String role;
	
	@OneToOne
	Student student ; 
	
	@OneToOne
	Teacher teacher; 
	
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
	public User(int uid, String name, String email, String password, String phone, String role, Student student,
			Teacher teacher) {
		super();
		this.uid = uid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.role = role;
		this.student = student;
		this.teacher = teacher;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	
}
