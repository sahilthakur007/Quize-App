package com.QuizeAppBackend.entities;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Quize {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int qid; 
	String name ; 
	int  time ; 
	int markspq; 
	boolean isstarted; 
	
	@ManyToOne
//	@JoinColumn(name = "teacher_id")
    Teacher teacher ;

	@OneToMany(mappedBy = "quize",cascade = CascadeType.ALL)
    Set<Question>questions = new HashSet<Question>();
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="quizeStudents",
	joinColumns =  @JoinColumn(name="quize_id" ,referencedColumnName = "qid"),
	inverseJoinColumns = @JoinColumn(name = "student_id",referencedColumnName ="sid")		)
    Set<Student>students = new HashSet<Student>(); 
	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public int  getTime() {
		return time;
	}
	

	public Quize(int qid, String name, int  time, int markspq, boolean isstarted, Teacher teacher,
			Set<Question> questions, Set<Student> students) {
		super();
		this.qid = qid;
		this.name = name;
		this.time = time;
		this.markspq = markspq;
		this.isstarted = isstarted;
		this.teacher = teacher;
		this.questions = questions;
		this.students = students;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isIsstarted() {
		return isstarted;
	}

	public void setIsstarted(boolean isstarted) {
		this.isstarted = isstarted;
	}

	public void setTime(int  time) {
		this.time = time;
	}

	public int getMarkspq() {
		return markspq;
	}

	public void setMarkspq(int markspq) {
		this.markspq = markspq;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	
	public Quize() {
		super();
		// TODO Auto-generated constructor stub
	} 
    
	
}
