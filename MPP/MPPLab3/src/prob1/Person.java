package prob1;

public class Person {

	private String name;
Person(){
		
	}
	Person(String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}
	@Override
	public boolean equals(Object aPerson) {
		if(aPerson == null) return false; 
		if(aPerson instanceof PersonWithJob )
		{
			PersonWithJob p = (PersonWithJob) aPerson; 
			return this.name.equals(p.getPerson().getName()); 
		}
		Person p = (Person)aPerson;
		boolean isEqual = this.name.equals(p.name);
		return isEqual;
	}
	

}