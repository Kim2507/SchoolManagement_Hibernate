package jpa.entitymodels;

import java.util.List;

import javax.persistence.*;

@NamedQueries({
    @NamedQuery(name = "getAllStudents", query = "from Student" ),
    @NamedQuery(name = "getStudentByEmail", query = "select s from Student s where s.sEmail = :email" ),
    @NamedQuery(name = "validateStudent", query = "select s from Student s where s.sEmail =:email AND s.sPass =:password" ),
    //@NamedQuery(name = "getStudentCourses", query = "select from Course join students_courses where Student_email= :Student_email")
    
})	


@Entity
//@Table(name="student")
public class Student implements java.io.Serializable{
	@Id
	@Column(name="email")
	private String sEmail;
	
	@Column(name="name")
	private String sName;
	
	@Column(name="password")
	private String sPass;
	
	@ManyToMany(targetEntity = Course.class, fetch = FetchType.EAGER)
	@JoinTable(name="students_courses")
	private List sCourses;
	
	
	public Student() {
		this.sEmail = "";
		this.sName ="";
		this.sPass = "";
		this.sCourses = null;
	}
	
	

	public Student(String sEmail, String sName, String sPass) {
		super();
		this.sEmail = sEmail;
		this.sName = sName;
		this.sPass = sPass;
	}



	public Student(String sEmail, String sName, String sPass, List sCourses) {
		super();
		this.sEmail = sEmail;
		this.sName = sName;
		this.sPass = sPass;
		this.sCourses = sCourses;
	}



	public String getEmail() {
		return sEmail;
	}

	public void setEmail(String email) {
		this.sEmail = email;
	}

	public String getName() {
		return sName;
	}

	public void setName(String name) {
		this.sName = name;
	}

	public String getPassword() {
		return sPass;
	}

	public void setPassword(String password) {
		this.sPass = password;
	}
	
	

	public List getsCourses() {
		return sCourses;
	}



	public void setsCourses(List sCourses) {
		this.sCourses = sCourses;
	}



	@Override
	public String toString() {
		return "Student [email=" + sEmail + ", name=" + sName + ", password=" + sPass + "]";
	}
	
	
}
