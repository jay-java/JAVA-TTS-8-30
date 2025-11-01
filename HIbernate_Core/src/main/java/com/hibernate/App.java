package com.hibernate;

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

//		User u = new User(3, "dart", 987612330, "mumbai");
//		session.save(u);

//		User u = new User(3, "kotlin", 987612330, "mumbai");
//		session.update(u);

//		User u = (User) session.get(User.class, 1);
//		System.out.println(u);
		
		User u = new User(3, "dart", 987612330, "mumbai");
		session.delete(u);
		
		
		tx.commit();
		session.close();
		sf.close();
	}
}
