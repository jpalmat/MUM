package edu.mum.cs.cs544.lab4.b;

import java.util.Date;

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
			
			Passenger p1 = new Passenger("Jimmy");
			Flight f1 = new Flight(1, "USA", "Ecuador", new Date());
			
			p1.addFlight(f1);
			
			session.persist(p1);
			
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