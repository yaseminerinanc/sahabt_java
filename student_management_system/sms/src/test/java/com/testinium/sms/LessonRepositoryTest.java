package com.testinium.sms;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.testinium.sms.domain.Lesson;
import com.testinium.sms.repository.LessonRespository;

@DataJpaTest
@AutoConfigureTestDatabase
@Rollback(false)
public class LessonRepositoryTest {
	
	
	@Autowired
	private LessonRespository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateLesson() {
	
		Lesson lesson = new Lesson();
		lesson.setLessonName("Biology");
		lesson.setImageId(null);
		lesson.setStudents(null);
		lesson.setAvailable(true);
		lesson.setLessonId("1");
		lesson.setDescription("Short description for lesson");
	

		Lesson savedLesson = repo.save(lesson);
		
		assertThat(savedLesson).isNotNull();
		assertThat(savedLesson.getLessonId()).isGreaterThan(null);
	}
	
	@Test
	public void testListAllLesson() {
		Iterable<Lesson> iterable = repo.findAll();
		
		iterable.forEach(System.out::println);
	}
	
	@Test
	public void testGetLesson() {
		String id = "2";
		Lesson lesson = repo.findById(id).get();
				
		System.out.println(lesson);
		
		assertThat(lesson).isNotNull();
	}
	
	@Test
	public void testUpdateLesson() {
		String id = "2";
		Lesson lesson = repo.findById(id).get();
		lesson.setLessonName("Math");
		
		repo.save(lesson);
		
		Lesson updatedLesson = entityManager.find(Lesson.class, id);
		
		assertThat(updatedLesson.getLessonName()).isEqualTo("Math");
	}
	
	@Test
	public void testDeleteLesson() {
		String id = "2";
		repo.deleteById(id);
		
		Optional<Lesson> result = repo.findById(id);
		
		assertThat(!result.isPresent());
	}
	
}
