package com.testinium.sms.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.testinium.sms.dto.CreateLessonRequest;
import com.testinium.sms.service.LessonService;


@RestController
@RequestScope
@RequestMapping("lessons")
@CrossOrigin
@Validated
public class LessonController {
	
	
	private LessonService lessonService;

	public LessonController( LessonService lessonService) {
		super();
		this.lessonService = lessonService;
	}
	
	//create lesson
	 @PostMapping("/lessons/new")
	 public ResponseEntity<?> createProduct(@RequestBody @Valid CreateLessonRequest createLessonRequest){

	        String lesson = lessonService.createLesson(createLessonRequest);

	        URI location = ServletUriComponentsBuilder
	                .fromCurrentRequest().path("/{lessonId}")
	                .buildAndExpand(lesson).toUri();

	        return ResponseEntity.created(location).build();
	    }

}
