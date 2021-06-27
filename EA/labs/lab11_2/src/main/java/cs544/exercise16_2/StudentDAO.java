package cs544.exercise16_2;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class StudentDAO {

	private SessionFactory sf;

	@Transactional(propagation = Propagation.SUPPORTS)
	public void setSessionFactory(SessionFactory sf) {
		System.out.println("==============================================IN DAO==================");
		this.sf = sf;
	}
	public StudentDAO() {
		// TODO Auto-generated constructor stub
		Student student = new Student(11334, "Frank", "Brown");
		Course course1 = new Course(1101, "Java", "A");
		Course course2 = new Course(1102, "Math", "B-");
		student.addCourse(course1);
		student.addCourse(course2);
		sf.getCurrentSession().persist(student);
	}
	
	public Student load(long studentid) {
		return (Student) sf.getCurrentSession().get(Student.class, studentid);
	}
}
