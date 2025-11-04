package OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Student s1 = new Student();
		s1.setSid(1);
		s1.setName("abc");

		Student s2 = new Student();
		s2.setSid(2);
		s2.setName("xyz");

		Course c1 = new Course();
		c1.setCid(1);
		c1.setCname("java");

		Course c2 = new Course();
		c2.setCid(2);
		c2.setCname("python");

		s1.setCid(c2);
		s2.setCid(c1);

		c1.setStudent(s2);
		c2.setStudent(s1);

		session.save(s1);
		session.save(s2);
		session.save(c1);
		session.save(c2);

		tx.commit();
		session.close();
		sf.close();
	}
}
