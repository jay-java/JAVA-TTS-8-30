package OneToManyToOne;

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

		Student1 s1 = new Student1();
		s1.setSid(1);
		s1.setSname("xyz");
		s1.setContact(987654310);

		Student1 s2 = new Student1();
		s2.setSid(2);
		s2.setSname("abc");
		s2.setContact(7894652130l);

		Course1 c1 = new Course1();
		c1.setCid(1);
		c1.setCname("java");

		Course1 c2 = new Course1();
		c2.setCid(2);
		c2.setCname("python");

		Course1 c3 = new Course1();
		c3.setCid(3);
		c3.setCname("flutter");

		List<Course1> courseListS1 = new ArrayList<Course1>();
		courseListS1.add(c1);
		courseListS1.add(c2);
		courseListS1.add(c3);

		List<Course1> courseListS2 = new ArrayList<Course1>();
		courseListS2.add(c1);
		courseListS2.add(c2);

		s1.setCourses(courseListS1);

		s2.setCourses(courseListS2);

		c1.setStudents(s1);
		c1.setStudents(s2);

		c2.setStudents(s1);
		c2.setStudents(s2);

		c3.setStudents(s1);

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
