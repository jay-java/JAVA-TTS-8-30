package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import model.User;

public class UserDao {
	SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = sf.openSession();
	Transaction tx = session.beginTransaction();

	public void insertUser(User u) {
		session.save(u);
		tx.commit();
		session.close();
		sf.close();
	}

	public User loginUser(User u) {
		String hql = "from User where email=:email and password = :password";
		Query q = session.createQuery(hql);
		q.setParameter("email", u.getEmail());
		q.setParameter("password", u.getPassword());
		User u1 = (User) q.uniqueResult();
		tx.commit();
		return u1;
	}

	public List<User> getAllUser() {
		String hql = "from User";
		Query q = session.createQuery(hql);
		List<User> list = q.list();
		tx.commit();
		return list;
	}

	public User getUserById(int id) {
		User u = session.get(User.class, id);
		return u;
	}

	public void updateUser(User u) {
		session.update(u);
	}

	public void deleteUser(int id) {
		User u = session.get(User.class, id);
		session.delete(u);
	}

}
