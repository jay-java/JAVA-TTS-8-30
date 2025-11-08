package ManyToMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course2 {
	@Id
	private int cid;
	private String cname;
	@ManyToMany
	private List<Student2> students;

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

	public List<Student2> getStudents() {
		return students;
	}

	public void setStudents(List<Student2> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course2 [cid=" + cid + ", cname=" + cname + ", students=" + students + "]";
	}

}
