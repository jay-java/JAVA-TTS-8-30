package ManyToMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student2 {
	@Id
	private int sid;
	private String sname;

	@ManyToMany
	private List<Course2> courses;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public List<Course2> getCourses() {
		return courses;
	}

	public void setCourses(List<Course2> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student2 [sid=" + sid + ", sname=" + sname + ", courses=" + courses + "]";
	}

}
