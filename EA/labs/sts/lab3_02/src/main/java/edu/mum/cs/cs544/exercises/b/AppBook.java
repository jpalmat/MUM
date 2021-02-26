package edu.mum.cs.cs544.exercises.b;

import org.hibernate.HibernateException;
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
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static void main(String[] args) {
        // Hibernate placeholders
        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            
            Publisher p1 = new Publisher("Publisher1");
            session.persist(p1);
            
            Book b1 = new Book("1234", "title1", "Jimmy", p1);
            session.persist(b1);

            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                System.err.println("Rolling back: " + e.getMessage());
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

//        try {
//            session = sessionFactory.openSession();
//            tx = session.beginTransaction();
//
//            // retieve all cars
//            @SuppressWarnings("unchecked")
//            List<Department> carList = session.createQuery("from Car").list();
//            for (Department car : carList) {
//                System.out.println("brand= " + car.getBrand() + ", year= "
//                        + car.getYear() + ", price= " + car.getPrice() + 
//                        " owner: "+ car.getOwner().getName());
//            }
//            tx.commit();
//
//        } catch (HibernateException e) {
//            if (tx != null) {
//                System.err.println("Rolling back: " + e.getMessage());
//                tx.rollback();
//            }
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }

        // Close the SessionFactory (not mandatory)
        sessionFactory.close();
        System.exit(0);
    }
}
