package com.testinium.sms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "RESULT")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result {
	
		@Id
	    @GeneratedValue(generator = "uuid")
	    @GenericGenerator(name = "uuid", strategy = "uuid2")
	    @Column(name = "RESULT_ID", updatable = false, nullable = false)
		private String resultId;
		
		@Column(name = "STUDENT_ID", nullable = false)
	 	private String studentId;
		
	    @Column(name = "STUDENT_NAME", nullable = false)
	    private String studentName;
	   
	    @Column(name = "LESSON_ID", nullable = false)
	    private String lessonId;
	    
	    @Column(name = "AVG_GRADE", nullable = false)
	    private double AvgGrade;
	    
	    @Column(name = "GRADE", nullable = false)
	    private double Grade;
	    
	    @Column(name = "IS_PASS")
	    private boolean isPassed;
	    
	    @Column(name = "SCHOOL_YEAR")
	    private String schoolYear;
	    
	    @Column(name = "SCHOOL_YEAR_STATUS")
	    private String schoolYearStatus;
	    
	    private Rank rank;
	    public enum Rank{E, D, C, B, A}

}
