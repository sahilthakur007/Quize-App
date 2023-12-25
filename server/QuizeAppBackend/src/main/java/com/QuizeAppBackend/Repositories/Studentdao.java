package com.QuizeAppBackend.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.QuizeAppBackend.entities.Student;
import java.util.List;


public interface Studentdao  extends JpaRepository<Student, Integer>{

	
}
