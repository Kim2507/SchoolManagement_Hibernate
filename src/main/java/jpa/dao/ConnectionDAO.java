package jpa.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ConnectionDAO {
	protected SessionFactory factory;
	protected Session session;
	protected Transaction t;
	
	
	public void openConnection() {
		factory = new Configuration().configure().buildSessionFactory();
    	session = factory.openSession();
    	t = session.beginTransaction();
	}
	
	public void closeConnection() {
		t.commit();
		session.close();
		factory.close();
	}
	

}
