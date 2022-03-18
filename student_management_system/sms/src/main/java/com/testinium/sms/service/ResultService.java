package com.testinium.sms.service;

import java.util.List;

import com.testinium.sms.domain.Result;

public interface ResultService {
	
	List<Result> findByStudentLessonCodeAndSchoolYear(String code, String year);
	
	List<Result> findByStudentIdAndLessonCodeAndSchoolYear(String code, String id, String year);

}
