package com.testinium.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testinium.sms.domain.Exam;

public interface ExamRepository extends JpaRepository<Exam, String> {

}
