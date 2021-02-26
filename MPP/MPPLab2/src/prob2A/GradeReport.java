package prob2A;

public class GradeReport {

	private Student student;
	
	private GradeReport () {
		
	}
	
	public static GradeReport getInstance(Student student) {
		if (student != null) {
			GradeReport report = new GradeReport();
			report.setStudent(student);
			return report;
		}
		return null;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
