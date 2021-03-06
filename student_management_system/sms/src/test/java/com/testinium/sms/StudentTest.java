package com.testinium.sms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.testinium.sms.domain.Student;

public class StudentTest {
	
	@ParameterizedTest
	@DisplayName("create student successfuly")
	void createStudentSuccessfuly(String fullname, String id) {
		
		var st = new Student(fullname,id);
		assertEquals(fullname, st.getName());
		assertEquals(id, st.getStudentId());
	
	}

	@Test
	@DisplayName("setting student name successfuly")
	void setCustomerFullNameSuccessfuly() {
		
		var st = new Student("94954016200", "Casmin By");
		st.setName("yasmin");
		assertEquals("yasmin", st.getName());
		
	}

	@Test
	void equalsTest() throws Exception {
	
		var st = new Student("94954016200", "Casmin");
		
		assertFalse(st.equals(null));
		assertFalse(st.equals(new Object()));
	}
	
	
	@Test
	void toStringShouldStartWithStudent() throws Exception {
	
		var st = new Student("94954016200", "Yasemin Erinanc");
		
		assertTrue(st.toString().startsWith("Student"));
	}

}
