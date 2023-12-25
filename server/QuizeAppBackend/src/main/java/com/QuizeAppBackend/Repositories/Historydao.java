package com.QuizeAppBackend.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.QuizeAppBackend.entities.History;
import com.QuizeAppBackend.entities.Quize;
import com.QuizeAppBackend.entities.Student;
import com.QuizeAppBackend.entities.User;

public interface Historydao extends JpaRepository<History, Integer> {

	List<History>findByQuize(Quize quize);
	List<History> findByStudent(User student);
}
