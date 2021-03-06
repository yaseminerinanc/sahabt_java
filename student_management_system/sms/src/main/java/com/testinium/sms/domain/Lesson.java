package com.testinium.sms.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "LESSON")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Lesson {
	
	   @Id
	   @GeneratedValue(generator = "uuid")
	   @GenericGenerator(name = "uuid", strategy = "uuid2")
	   @Column(name = "LESSON_ID", updatable = false, nullable = false)
	   private String lessonId;
	   
	   @Column(name = "LESSON_NAME", nullable = false)
	   private String lessonName;
	   
	    @Column(name = "LESSON_DESCRIPTION")
	    private String description;
	    
	    @Column(name = "LESSON_IMAGE_ID")
	    private String imageId;
	    
	    @Column(name = "AVAILABLE")
	    private boolean available;
 
	    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	    @JsonIgnore
	    private Set<Student> students = new HashSet<>();
	    
}
