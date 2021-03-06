package com.testinium.sms.service;

import java.util.List;

import com.testinium.sms.domain.Student;

public interface StudentService {
	
	Student getOneStudent(String id);
	
	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student updateStudent(Student student);
	
	Student findByUsername(String username);

	void deleteStudent(String studentId);

	Student getStudentById(String studentId);
	
	boolean addUser(Student student);

}
