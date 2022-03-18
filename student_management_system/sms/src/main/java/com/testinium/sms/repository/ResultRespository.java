package com.testinium.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testinium.sms.domain.Result;

public interface ResultRespository extends JpaRepository<Result,String>{
	
	List<Result> findResultByStudentIdAndLessonIdAndSchoolYear(String studentId, String lessonId , String schoolYear);
	
	List<Result> findAllByLessonIdAndSchoolYear(String lessonId , String schoolYear);

}
