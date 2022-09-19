package jpa.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import jpa.entitymodels.Student;
import jpa.service.StudentService;

@RunWith(JUnitPlatform.class)
public class StudentDAOTest {
	private static StudentService studentService;
	@BeforeAll
	public static void setUp() {
		studentService = new StudentService();
		studentService.openConnection();
	}
	@Test
	public void testGetStudentById() {
		Student expected = new Student();
		expected.setEmail("hluckham0@google.ru");
		expected.setName("Hazel Luckham");
		expected.setPassword("X1uZcoIh0dj");
		Student actual = studentService.getStudentByEmail("hluckham0@google.ru");
		assertEquals(expected.getEmail(), actual.getEmail());
		
		
	}
	
	@AfterEach
	public void closeConnect() {
		studentService.closeConnection();
	}
	



}
