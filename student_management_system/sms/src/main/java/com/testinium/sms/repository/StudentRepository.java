package com.testinium.sms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testinium.sms.domain.Student;

@Repository

public interface StudentRepository extends JpaRepository <Student,String>{
	
	 Student findByName(String name); 
	 
	 Optional<Student> findById(String Id); 
	 
	

}
