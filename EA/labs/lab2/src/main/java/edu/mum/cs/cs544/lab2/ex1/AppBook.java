package edu.mum.cs.cs544.lab2.ex1;

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
			
			Book b1 = new Book();
			b1.setAuthor("Jimmy");
			b1.setISBN("123456");
			b1.setPrice(12.4);
			b1.setPublish_date(new Date());
			b1.setTitle("book 1");
			
			session.persist(b1);
			
			Book b2 = new Book();
			b2.setAuthor("Maryam");
			b2.setISBN("98765");
			b2.setPrice(22.4);
			b2.setPublish_date(new Date());
			b2.setTitle("book 2");
			
			session.persist(b2);
			
			Book b3 = new Book();
			b3.setAuthor("Maryam");
			b3.setISBN("98765");
			b3.setPrice(22.4);
			b3.setPublish_date(new Date());
			b3.setTitle("book 2");
			
			session.persist(b3);
			
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
			
			List<Book> bookList =  bookList =  session.createQuery("from Book").list();
			
			for (Book book : bookList) {
				System.out.println("book title: "+ book.getTitle() + " author: "+ book.getAuthor());
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
			
			Book bu1 = (Book) session.get(Book.class, 1);
			Book bd2 = (Book) session.get(Book.class, 2);
			
			bu1.setAuthor("JimmyUpdate");
			
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
			
			List<Book> bookList =  bookList =  session.createQuery("from Book").list();
			
			for (Book book : bookList) {
				System.out.println("book title: "+ book.getTitle() + " author: "+ book.getAuthor());
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