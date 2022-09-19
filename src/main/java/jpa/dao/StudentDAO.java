package jpa.dao;

import java.util.List;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public interface StudentDAO {
	// Get all student and return a list of students
	List<Student> getAllStudents();

	// Get a student by email
	Student getStudentByEmail(String sEmail);

	// Get a validate student
	boolean validateStudent(String sEmail, String sPassword);

	// check if the student register the following course
	void registerStudentToCourse(String sEmail, int cid);

	// Return all the course the following student attending
	List<Course> getStudentCourses(String sEmail);

}
