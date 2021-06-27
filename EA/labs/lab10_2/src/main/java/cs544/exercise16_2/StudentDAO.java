package cs544.exercise16_2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentDAO {
	private SessionFactory sf;
	Transaction tx = null;

	public StudentDAO() {
		System.out.println("init constructor");
		Student student = new Student(11334, "Frank", "Brown");
		Course course1 = new Course(1101, "Java", "A");
		Course course2 = new Course(1102, "Math", "B-");
		student.addCourse(course1);
		student.addCourse(course2);
		sf=HibernateUtil.getSessionFactory();
		tx = sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().save(student);
		tx.commit();
		sf.getCurrentSession().close();
		System.out.println("end constructor");
	}

	public Student load(long studentid) {
		System.out.println("init load");
		sf=HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		tx = sf.getCurrentSession().beginTransaction();
		Student student = (Student) session.createQuery("from Student where studentid = "+studentid).uniqueResult();
		tx.commit();
		System.out.println("end load");
		return student;
	}
}
