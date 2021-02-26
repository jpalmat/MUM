package edu.mum.cs.cs544.quiz4;

import java.util.Date;
import java.util.List;

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
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			Toy t1 = new Toy("ball", "plastic", "black");
			Pet pe1 = new Pet("lucas", "dog", "male", new Date());
			pe1.addToy(t1);
			Person p1 = new Person("Jimmy", "Palma");
			p1.addPet(pe1);
			
			session.persist(p1);
			
			tx.commit();
		} catch (Exception e) {
			if(tx!= null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		
		/*
		 * All Persons that own a Pet with the name ‘Fido’
		 */
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			System.out.println("HEEEERRREEEEE");
			List<Person> bookList =  session.createQuery("from Person").list();
			
			for (Person book : bookList) {
				System.out.println("book title: "+ book.getFirstname() + " author: "+ book.getLastname());
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