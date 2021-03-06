package com.testinium.sms.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "EXAM")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Exam {
	
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "EXAM_ID", updatable = false, nullable = false)
    private String examId;
    
    @Column(name = "EXAM_NAME", nullable = false)
    private String examName;
    
    @Column(name = "STUDENT_NAME", nullable = false)
    private String studentName;
    
    @Column(name = "TOTAL", nullable = false)
    private double total;
    
    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ExamItem> examItems = new ArrayList<>();
    
    
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "exam")
    @JsonIgnore
    private Set<Student> students = new HashSet<>();
    
   
    
   
	
	
}
