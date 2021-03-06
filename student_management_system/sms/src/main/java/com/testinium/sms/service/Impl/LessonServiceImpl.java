package com.testinium.sms.service.Impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testinium.sms.domain.Lesson;
import com.testinium.sms.dto.CreateLessonRequest;
import com.testinium.sms.dto.LessonResponse;
import com.testinium.sms.dto.UpdateLessonRequest;
import com.testinium.sms.repository.LessonRespository;
import com.testinium.sms.service.LessonService;

public class LessonServiceImpl implements LessonService {

	@Autowired
	LessonRespository lessonRepository;
	@Autowired
	ObjectMapper objectMapper;
	   
	@Override
	public String createLesson(@Valid CreateLessonRequest createLessonRequest) {
		
		
		 Lesson lesson = Lesson.builder()
				 		.lessonName(createLessonRequest.getLessonName())
				 		.description(createLessonRequest.getDescription())
				 		.imageId(createLessonRequest.getImageId())
				 		.build();


	        Lesson savedLesson = lessonRepository.save(lesson);
	        return savedLesson.getLessonId();
	}

	@Override
	public LessonResponse getLesson(String lessonId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteLesson(String lessonId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateLesson(UpdateLessonRequest updateProductRequest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<Lesson> findAllLessons(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<LessonResponse> getAllLessons(String sort, Integer page, Integer size) {
		// TODO Auto-generated method stub
		return null;
	}

}
