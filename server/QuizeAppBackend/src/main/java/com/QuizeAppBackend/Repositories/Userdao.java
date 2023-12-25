package com.QuizeAppBackend.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.QuizeAppBackend.entities.User;
import java.util.List;


public interface Userdao extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);
	
	@Query("select u from User u where u.role = :Role")
	List<User>findbyUserRole(String Role); 
	
	@Query(value="select * from user where student_sid = :student",nativeQuery = true )
	Optional<User>  findByStudent(@Param("student") int  student);
}
