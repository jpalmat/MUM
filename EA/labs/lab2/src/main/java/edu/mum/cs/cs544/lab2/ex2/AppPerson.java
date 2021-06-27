package edu.mum.cs.cs544.lab2.ex2;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AppPerson {

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
			
			Person p1 = new Person();
			p1.setFirstname("jimmy");
			p1.setLastname("Palma");
			p1.setDateofbirth(new Date());
			
			
			session.persist(p1);
			
			Person p2 = new Person();
			p2.setFirstname("Maryam");
			p2.setLastname("Ghiasvand");
			p2.setDateofbirth(new Date());
			
			
			session.persist(p2);
			
			Person p3 = new Person();
			p3.setFirstname("Maryam");
			p3.setLastname("Ghiasvand");
			p3.setDateofbirth(new Date());
			
			
			session.persist(p3);
			
			tx.commit();
		} catch (Exception e) {
			if(tx!= null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		
		/*
		 * Open a session
• Retrieve all books and output them to the console
• Close the session
		 */
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			List<Person> personList =  session.createQuery("from Person").list();
			
			for (Person person : personList) {
				System.out.println("person name: "+ person.getFirstname() + " lastname: "+ person.getLastname());
			}
			
			tx.commit();
		} catch (Exception e) {
			if(tx!= null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		
		/*
		 * Open a session
• Retrieve a book from the database and change its title and price
• Delete a book (not the one that was just updated)
• Close the session
		 */
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			Person bu1 = (Person) session.get(Person.class, 1L);
			Person bd2 = (Person) session.get(Person.class, 2L);
			
			bu1.setFirstname("JimmyUpdate");
			
			session.delete(bd2);
			
			tx.commit();
		} catch (Exception e) {
			if(tx!= null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		
		/*
		 * Open a session
• Retrieve all books and output them to the console
• Close the session
		 */
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			List<Person> personList =  session.createQuery("from Person").list();
			
			for (Person person : personList) {
				System.out.println("person name: "+ person.getFirstname() + " lastname: "+ person.getLastname());
			}
			
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