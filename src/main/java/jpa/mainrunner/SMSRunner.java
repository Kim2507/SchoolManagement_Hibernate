package jpa.mainrunner;

import static java.lang.System.out;

import java.util.List;
import java.util.Scanner;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.CourseService;
import jpa.service.StudentService;

public class SMSRunner {

	private Scanner sin;
	private StringBuilder sb;

	protected static CourseService courseService;
	protected static StudentService studentService;
	private Student currentStudent;
	

	public SMSRunner() {
		sin = new Scanner(System.in);
		sb = new StringBuilder();
		courseService = new CourseService();
		studentService = new StudentService();
		studentService.openConnection();
		courseService.openConnection();

		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SMSRunner sms = new SMSRunner();
		sms.run();
		studentService.closeConnection();
		courseService.closeConnection();
	
	}

	private void run() {
		// Login or quit
		switch (menu1()) {
		case 1:
			if (studentLogin()) {
				registerMenu();
			}
			break;
		case 2:
			out.println("You have been signed out.");
			break;

		default:

		}
	}

	private int menu1() {
		sb.append("\n1.Student Login\n2. Quit Application\nPlease Enter Selection: ");
		out.print(sb.toString());
		sb.delete(0, sb.length());

		return sin.nextInt();
	}

	private boolean studentLogin() {
		boolean retValue = false;
		out.print("Enter your email address: ");
		String email = sin.next();
		out.print("Enter your password: ");
		String password = sin.next();
		
		if(studentService.validateStudent(email, password)) {
			retValue = true;
			currentStudent = studentService.getStudentByEmail(email);
			displayMyClasses(currentStudent.getEmail());
		}
		return retValue;
	}
	
	public void displayMyClasses(String email) {
		List<Course> studentCourses = studentService.getStudentCourses(email);
		System.out.println("My Classes:\n");
		System.out.printf("%-5s%-30s%-25s\n", "ID", "Course", "Instructor");
		for (Course course : studentCourses) {
			course.display();
		}
	}

	private void registerMenu() {
		sb.append("\n1.Register a class\n2. Logout\nPlease Enter Selection: ");
		out.print(sb.toString());
		sb.delete(0, sb.length());

		switch (sin.nextInt()) {
		case 1:
			List<Course> allCourses = courseService.getAllCourses();
			System.out.printf("%-5s%-30s%-25s\n", "ID", "Course", "Instructor");
			for (Course course : allCourses) {
				course.display();
			}
			out.println();
			out.print("Which course? ");
			int course_id = sin.nextInt();
			studentService.registerStudentToCourse(currentStudent.getEmail(), course_id);
			displayMyClasses(currentStudent.getEmail());
		case 2:
		default:
			out.println("You have been signed out.");
		}
	}
}
