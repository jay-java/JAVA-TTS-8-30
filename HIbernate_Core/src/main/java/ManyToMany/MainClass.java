package ManyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainClass {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Student2 s1 = new Student2();
		s1.setSid(1);
		s1.setSname("xyz");

		Student2 s2 = new Student2();
		s2.setSid(2);
		s2.setSname("abc");

		Course2 c1 = new Course2();
		c1.setCid(1);
		c1.setCname("java");

		Course2 c2 = new Course2();
		c2.setCid(2);
		c2.setCname("python");

		Course2 c3 = new Course2();
		c3.setCid(3);
		c3.setCname("flutter");

		List<Course2> courseList = new ArrayList<Course2>();
		courseList.add(c1);
		courseList.add(c2);
		courseList.add(c3);

		List<Student2> studentList = new ArrayList<Student2>();
		studentList.add(s1);
		studentList.add(s2);

		s1.setCourses(courseList);
		s2.setCourses(courseList);

		c1.setStudents(studentList);
		c2.setStudents(studentList);
		c3.setStudents(studentList);

		session.save(s1);
		session.save(s2);
		session.save(c1);
		session.save(c2);
		session.save(c3);

		tx.commit();
		session.close();
		sf.close();
	}
}
