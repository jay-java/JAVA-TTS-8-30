package OneToManyToOne;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Course1 {
	@Id
	private int cid;
	private String cname;
	@ManyToOne
	private Student1 students;

	public Course1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Student1 getStudents() {
		return students;
	}

	public void setStudents(Student1 students) {
		this.students = students;
	}

	public Course1(int cid, String cname, Student1 students) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course1 [cid=" + cid + ", cname=" + cname + ", students=" + students + "]";
	}

}
