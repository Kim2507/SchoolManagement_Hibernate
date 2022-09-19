package jpa.service;

import java.util.List;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jpa.dao.ConnectionDAO;
import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class StudentService extends ConnectionDAO implements StudentDAO{

	
	public StudentService() {
		super();
		
	}

	public List<Student> getAllStudents() {
		
		Query query = session.getNamedQuery("getAllStudents");
		List<Student> st_list = query.getResultList();
		
		return st_list;
	}

	public Student getStudentByEmail(String sEmail) {
		TypedQuery query = session.getNamedQuery("getStudentByEmail").setParameter("email",sEmail);
		Student st = (Student)query.getSingleResult();
		
		return st;
	}

	public boolean validateStudent(String sEmail, String sPassword) {
		
		
		TypedQuery query = session.getNamedQuery("validateStudent")
				.setParameter("email", sEmail)
				.setParameter("password", sPassword);
		if(query.getSingleResult()!=null) return true;
		
		return false;
	}
	

	public void registerStudentToCourse(String sEmail, int cid) {
		Student student = getStudentByEmail(sEmail);
		List<Course> courses_list = getStudentCourses(sEmail);
		
		Query query = session.createQuery("select c from Course c where c.cid = :id");
		query.setParameter("id",cid);
		Course course = (Course) query.getSingleResult();
		
		
		if(!courses_list.contains(course)) {
			courses_list.add(course);
			student.setsCourses(courses_list);
			session.merge(student);
			
		}
		else {
			System.out.println("You are already registered in that course!");
		}
	
		
		
		
	}

	public List<Course> getStudentCourses(String sEmail) {
		
		Query query = session.getNamedQuery("getStudentByEmail").setParameter("email", sEmail);
		Student st = (Student) query.getSingleResult();
		List<Course> courses = st.getsCourses();
		
		return courses;
	}

}
