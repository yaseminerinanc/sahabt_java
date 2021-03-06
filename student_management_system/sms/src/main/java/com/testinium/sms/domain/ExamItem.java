package com.testinium.sms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "EXAM_ITEM")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExamItem {
	
		@Id
	    @GeneratedValue(generator = "uuid")
	    @GenericGenerator(name = "uuid", strategy = "uuid2")
	    @Column(name = "EXAM_ITEM_ID", updatable = false, nullable = false)
	    private String examItemId;

	    @Column(name = "MIDTERM_GRADE", nullable = false)
	    private double midTerm;

	    @Column(name = "FINALEXAM_GRADE", nullable = false)
	    private double finalExam;
	    
	    @Column(name = "LETTER_GRADE", nullable = false)
	    private String letterGrade;
	    
	    @Column(name = "AVG_GRADE", nullable = false)
	    private double averageGrade;
	    
	    @Column(name = "LESSON_ID", nullable = false)
	    private String lessonId;

	    @Column(name = "LESSON_NAME", nullable = false)
	    private String lessonName;
	    
	    @ManyToOne
	    @JoinColumn(name = "EXAM_ID")
	    @JsonIgnore
	    private Exam exam;
	    
	    
	    public void calcAverageGrade()
  		{
  			averageGrade = (30*midTerm + 70*finalExam)/100;
  			calcLetterGrade();
  		}
  		
  		/** letter grade based on average grade of a student.
  		 */
  		public void calcLetterGrade()
  		{
  			if (averageGrade<=100 && averageGrade>=90)
  			{
  				letterGrade = "A+";
  			}
  			else if (averageGrade>=85)
  			{
  				letterGrade = "A";
  			}
  			else if (averageGrade>=80)
  			{
  				letterGrade = "A-";
  			}
  			else if (averageGrade>=75)
  			{
  				letterGrade = "B+";
  			}
  			else if (averageGrade>=70)
  			{
  				letterGrade = "B";
  			}
  			else if (averageGrade>=65)
  			{
  				letterGrade = "C+";
  			}
  			else if (averageGrade>=60)
  			{
  				letterGrade = "C";
  			}
  			else if (averageGrade>=55)
  			{
  				letterGrade = "D+";
  			}
  			else if (averageGrade>=50)
  			{
  				letterGrade = "D";
  			}
  			else
  			{
  				letterGrade = "F";
  			}
  		}
}
