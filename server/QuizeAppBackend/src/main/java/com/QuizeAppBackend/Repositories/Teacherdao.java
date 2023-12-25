package com.QuizeAppBackend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.QuizeAppBackend.entities.Teacher;

public interface Teacherdao extends JpaRepository<Teacher, Integer> {

}
