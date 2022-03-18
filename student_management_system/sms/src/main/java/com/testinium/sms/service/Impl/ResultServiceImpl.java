package com.testinium.sms.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testinium.sms.domain.Result;
import com.testinium.sms.repository.ResultRespository;
import com.testinium.sms.service.ResultService;

@Service
public class ResultServiceImpl implements ResultService {
	
	private  ResultRespository resultRepo ;
	
	@Autowired
	public ResultServiceImpl(ResultRespository resultRepo) {
		super();
		this.resultRepo = resultRepo;
	}


	@Override
	public List<Result> findByStudentLessonCodeAndSchoolYear(String code, String year) {
		return resultRepo.findAllByLessonIdAndSchoolYear(code, year);
	}


	@Override
	public List<Result> findByStudentIdAndLessonCodeAndSchoolYear(String code, String id, String year) {
		
		return resultRepo.findResultByStudentIdAndLessonIdAndSchoolYear(code, id, year);
	}

}
