package com.testinium.sms.service;



import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.testinium.sms.domain.Lesson;
import com.testinium.sms.dto.CreateLessonRequest;
import com.testinium.sms.dto.LessonResponse;
import com.testinium.sms.dto.UpdateLessonRequest;

public interface LessonService {
	
	  String createLesson(@Valid CreateLessonRequest createLessonRequest);

	  LessonResponse getLesson(String lessonId);

	  void deleteLesson(String lessonId);

	  void updateLesson(UpdateLessonRequest updateProductRequest);

	  Page<Lesson> findAllLessons(Pageable pageable);

	  Page<LessonResponse> getAllLessons(String sort, Integer page, Integer size);

}
