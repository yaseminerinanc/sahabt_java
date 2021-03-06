package com.testinium.sms.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testinium.sms.domain.Student;
import com.testinium.sms.repository.StudentRepository;
import com.testinium.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository studentRepo;
	
	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
	
		this.studentRepo = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		
		return studentRepo.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public Student getStudentById(String studentId) {
		return studentRepo.findById(studentId).get();
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public void deleteStudent(String studentId) {
		studentRepo.deleteById(studentId);
		
	}

	@Override
	public Student findByUsername(String username) {
		
		return (Student) studentRepo.findByName(username);
	}

	@Override
	public Student getOneStudent(String id) {
		
		return studentRepo.getById(id);
	}

	@Override
	public boolean addUser(Student student) {
		 Optional<Student> form = studentRepo.findById(student.getStudentId());
				 
	        if (form != null) {
	            return false;
	        }else
	        	//business rules...
	        return true;
	}



}
