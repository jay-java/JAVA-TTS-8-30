package OneToManyToOne;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student1 {
	@Id
	private int sid;
	private String sname;
	private long contact;
	@OneToMany
	private List<Course1> courses;

	public Student1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student1(int sid, String sname, long contact, List<Course1> courses) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.contact = contact;
		this.courses = courses;
	}

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

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public List<Course1> getCourses() {
		return courses;
	}

	public void setCourses(List<Course1> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student1 [sid=" + sid + ", sname=" + sname + ", contact=" + contact + ", courses=" + courses + "]";
	}

}
