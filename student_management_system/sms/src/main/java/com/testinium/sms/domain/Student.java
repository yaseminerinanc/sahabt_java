package com.testinium.sms.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "STUDENT")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	
	 @Id
	  @GeneratedValue(generator = "uuid")
	  @GenericGenerator(name = "uuid", strategy = "uuid2")
	  @Column(name = "STUDENT_ID", updatable = false, nullable = false)
	private String studentId;
	 
	 @Column(name = "STUDENT_NAME", updatable = false, nullable = false)
	private String name;
	
	 @ManyToMany(fetch = FetchType.EAGER,
		      cascade = CascadeType.DETACH)
	 @JoinTable(name = "LESSON",
		  joinColumns = {@JoinColumn(name = "student_id")},
		  inverseJoinColumns = {@JoinColumn(name = "lesson_id")})
	private  Set<Lesson> lessons;

	 @OneToMany(fetch = FetchType.EAGER,
		      cascade = CascadeType.DETACH)
	 @JoinTable(name = "EXAM",
		  joinColumns = {@JoinColumn(name = "student_id")},
		  inverseJoinColumns = {@JoinColumn(name = "exam_id")})
	private  Set<Exam> exams;
	 
	 public Student(String fullName, String id) {
			this.studentId = id;
			this.name = fullName;
		}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", lessons=" + lessons + ", exams=" + exams + "]";
	}
	 
	

}
