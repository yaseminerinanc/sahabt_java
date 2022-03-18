package com.testinium.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testinium.sms.domain.Lesson;

@Repository
public interface LessonRespository extends JpaRepository<Lesson, String> {

}
