package com.testinium.sms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.testinium.sms.domain.Student;
import com.testinium.sms.repository.StudentRepository;
import com.testinium.sms.service.StudentService;

@SpringBootTest
public class StudentServiceImplTest {
	
	@Autowired
    private StudentService studentService;

    @MockBean
    private StudentRepository studnetRepository;
	
	  @Test
	    public void studentSave() {
	        Student st = new Student();
	        st.setName("Student");
	        st.setStudentId("1111111");
	        st.setLessons(null);
	        st.setExams(null);

	        boolean isUserCreated = studentService.addUser(st);
	        assertTrue(isUserCreated);
	        verify(studnetRepository, times(1)).save(st);
	    }
	  
	   @Test
	    public void loadStudentByUsername() {
		   Student student = new Student();
	        student.setName("Student");

	        when(studnetRepository.findByName("Student")).thenReturn((student));
	        verify(studnetRepository, times(1)).findByName("Student");
	        assertEquals("Student", student.getName());
	    }
	   
	   

}
