package com.QuizeAppBackend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.QuizeAppBackend.entities.Question;

public interface Questiondao extends JpaRepository<Question, Integer> {
	
}
