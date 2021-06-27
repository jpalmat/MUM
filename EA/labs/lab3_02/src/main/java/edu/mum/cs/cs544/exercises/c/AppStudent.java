package edu.mum.cs.cs544.exercises.c;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AppStudent {

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
            
            Course c1 = new Course(1, "MWA");
            
            Course c2 = new Course(2, "EA");
            
            Course c3 = new Course(3, "WAP");
            
            Student s1 = new Student("Jimmy", "Palma");
            
            Student s2 = new Student("Carlos", "Palm");
            
            c1.addStudent(s1);
            c1.addStudent(s2);
            
            c2.addStudent(s1);
            c2.addStudent(s2);
            
            c3.addStudent(s1);
            c3.addStudent(s2);
            
            s1.addCourse(c1);
            s1.addCourse(c2);
            s1.addCourse(c3);

            s2.addCourse(c1);
            s2.addCourse(c2);
            s2.addCourse(c3);
            
            
            session.persist(c1);
            session.persist(c2);
            session.persist(c3);
            session.persist(s1);
            session.persist(s2);

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
