package jpa.entitymodels;

import javax.persistence.*;


@NamedQueries({
	@NamedQuery(name="getAllCourses", query = "from Course")
})
@Entity
//@Table(name = "course")
public class Course implements java.io.Serializable {
	@Id
	@Column(name="id")
	private int cid;
	
	@Column(name="name")
	private String cName;
	
	@Column(name="instructor")
	private String cInstructorName;
	
	public Course() {
		this.cid = 0;
		this.cName="";
		this.cInstructorName = "";
	}
	
	

	public Course(int cid, String cName, String cInstructorName) {
		super();
		this.cid = cid;
		this.cName = cName;
		this.cInstructorName = cInstructorName;
	}



	public int getId() {
		return cid;
	}

	public void setId(int id) {
		this.cid = id;
	}

	public String getName() {
		return cName;
	}

	public void setName(String name) {
		this.cName = name;
	}

	public String getInstructor() {
		return cInstructorName;
	}

	public void setInstructor(String instructor) {
		this.cInstructorName = instructor;
	}

	@Override
	public String toString() {
		return "Course [id=" + cid + ", name=" + cName + ", instructor=" + cInstructorName + "]";
	}
	
	public void display() {
		
		String id = String.valueOf(getId()).replaceAll("(\\r\\n)", "");
		String name = getName().replaceAll("(\\r\\n)", "");
		String instructor = getInstructor().replaceAll("(\\r\\n)", "");
		System.out.printf("%-5s%-30s%-25s\n", id,name, instructor);
		
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean isValid = true;
		if (obj instanceof Course) {
			Course other = (Course) obj;
			boolean sameId = (this.cid == other.getId());
			boolean sameName = (this.cName.equals(other.getName()));
			boolean sameInstructorName = (this.cInstructorName.equals(other.getInstructor()));
			if (sameId && sameName && sameInstructorName) {
				isValid = true;
			}else {
				isValid = false;
			}
		}
		return isValid;
	}
	

}
