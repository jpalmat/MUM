package edu.mum.cs.cs544.exercises.f;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AppEmployee {

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
            
            Employee1 e1 = new Employee1("Jimmy");

            Department1 d1 = new Department1("BMW");
            d1.addEmployee(e1);
            
            Office office = new Office(212,"Cupertino");
            office.addEmployee(e1);

            e1.setDeparment(d1);
            
            session.persist(e1);

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
