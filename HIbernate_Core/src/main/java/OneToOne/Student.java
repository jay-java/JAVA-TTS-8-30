package OneToOne;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Student {
	@Id
	private int sid;
	private String name;
	@OneToOne(mappedBy = "student")
//	@JoinColumn(name = "course_id")
	private Course cid;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int sid, String name, Course cid) {
		super();
		this.sid = sid;
		this.name = name;
		this.cid = cid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Course getCid() {
		return cid;
	}

	public void setCid(Course cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", cid=" + cid + "]";
	}

}
