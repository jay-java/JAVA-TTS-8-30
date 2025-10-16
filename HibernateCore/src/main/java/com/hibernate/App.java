package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//1.Create Maven Project
//2.Add dependencies in POM.xml
//3.create db connection -> hibernate.cfg.xml
//4.Model class
//5.Main class

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		SessionFactory sf = new Configuration().configure("com/hibernate/hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		User u = new User(3, "mobile developer", 9876543210l, "mumbai");
		session.save(u);

//		session.update(u);

//		User u = session.get(User.class, 2);
//		System.out.println(u);
		tx.commit();
		session.close();
		sf.close();
	}
}
