package jpa.service;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jpa.dao.ConnectionDAO;
import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class CourseService extends ConnectionDAO implements CourseDAO{


	public List<Course> getAllCourses() {
		
		Query query = session.getNamedQuery("getAllCourses");
		List<Course> courses_list = query.getResultList();
		
		return courses_list;
	}

}
