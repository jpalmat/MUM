package edu.mum.cs.cs544.lab4.a;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AppBook {

	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;
	
	static {
		Configuration configuration = new Configuration();
		configuration.configure();
		
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;
		/*
		 * Open a session
• Create 3 books save them to the database
• Close the session
		 */
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			Student s1 = new Student("Jimmy", "Palma");
			
			Laptop l1 = new Laptop("HP", "t1");
			Laptop l2 = new Laptop("Dell", "t1");
			
			s1.addLaptop(l1);
			s1.addLaptop(l2);
			
			session.persist(s1);
			
			tx.commit();
		} catch (Exception e) {
			if(tx!= null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
	}
}