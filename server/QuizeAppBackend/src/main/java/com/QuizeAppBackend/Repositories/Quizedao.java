package com.QuizeAppBackend.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.QuizeAppBackend.entities.Quize;
import com.QuizeAppBackend.entities.Teacher;

import java.util.List;
import com.QuizeAppBackend.entities.Student;
import java.util.Set;



public interface Quizedao extends JpaRepository<Quize, Integer> {

	List<Quize> findByTeacher(Teacher teacher);
	
	@Query(value = "select * from quize q,quize_students qs ,student s  where q.qid=qs.quize_id and qs.student_id=s.sid and isstarted= true and sid = :student and qid not in ( select quize_qid from history h where h.student_uid=:user)", 
			nativeQuery = true)
	List<Quize> findByStudents(@Param("student") int  student,@Param("user")int user);
	
//	List<Quize>findByTeacher(Teacher teacher ); 
//	@Query("select u from User u where u.getRole() = :Role")

}
