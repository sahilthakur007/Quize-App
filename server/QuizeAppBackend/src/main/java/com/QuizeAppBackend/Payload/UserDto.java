package com.QuizeAppBackend.Payload;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public class UserDto {
	int uid ; 
    @NotBlank
    String name ;
    @NotBlank
	String  email; 
	@NotBlank
	String password ;
	@NotBlank
	String phone ;
	@NotBlank
	String role;
	StudentDto student ; 
	TeacherDto teacher; 
	
	public TeacherDto getTeacher() {
		return teacher;
	}
	public void setTeacher(TeacherDto teacher) {
		this.teacher = teacher;
	}
	public StudentDto getStudent() {
		return student;
	}
	public void setStudent(StudentDto student) {
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
	
	
	public UserDto(int uid, @NotBlank String name, @NotBlank String email, String password, String phone, String role,
			StudentDto student, TeacherDto teacher) {
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
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
