package prob1;

public class PersonWithJob {
	
	private double salary;
	private Person person; 
	
	public double getSalary() {
		return salary;
	}
	PersonWithJob(double s, Person p) {
		person = p;
		salary = s;
	}
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public String getName() {
		return person.getName(); 
	}
	
	@Override
	public boolean equals(Object aPerson) {
		if(aPerson == null) return false; 
		if(aPerson instanceof Person)
			return this.person.getName().equals(((Person) aPerson).getName());		
		
		PersonWithJob p = (PersonWithJob)aPerson;
		boolean isEqual = this.person.getName().equals(p.person.getName()) &&
				this.getSalary()==p.getSalary();
		return isEqual;
	}
	public static void main(String[] args) {
		Person p2 = new Person("Joe");
		PersonWithJob p1 = new PersonWithJob(30000, p2); 
		//As PersonsWithJobs, p1 should be equal to p2
		System.out.println("p1.equals(p2)? " + p1.equals(p2));
		System.out.println("p2.equals(p1)? " + p2.equals(p1));
	}



}
