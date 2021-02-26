package edu.mum.cs.cs544.lab5.b;

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
			
			Customer1 c1 = new Customer1("Jimmy", "Palma");
			
			Order1 o1 = new Order1(new Date());
			c1.addOrder(o1);
			
			Product1 p1 = new CD("dna", "GROUP", "BSB");
			Product1 p2 = new DVD("AVE", "MOVIE", "action");
			Product1 p3 = new Book("bla", "des", "bla");
			
			OrderLine1 ol1 = new OrderLine1(1, p1);
			OrderLine1 ol2 = new OrderLine1(1, p2);
			OrderLine1 ol3 = new OrderLine1(1, p3);
			
			o1.addOrderLineList(ol1);
			o1.addOrderLineList(ol2);
			o1.addOrderLineList(ol3);
			
			session.persist(c1);
			
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