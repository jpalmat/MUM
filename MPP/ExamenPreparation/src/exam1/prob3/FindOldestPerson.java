package exam1.prob3;

import java.util.List;

//DO NOT MODIFY METHOD SIGNATURE OR STATIC QUALIFIER
public class FindOldestPerson {
//	public static Person findOldestPerson(List<Person> persons) {
//		//implement
//		return persons.stream().reduce((x,y)->{
//			Person max;
//			if(x.getAge()>y.getAge())
//				max=x;
//			
//			else
//				max=y;
//				
//			return max;
//		}).get();
//				                        
//	}
	
//	public static Person findOldestPerson(List<Person> persons) {
//		return persons.stream().reduce((x, y) -> {
//			if(x.getAge()>y.getAge()) {
//				return x;
//			} else {
//				return y;
//			}
//		}).get();
//		
//	}
	
	public static Person findOldestPerson(List<Person> persons) {
		return persons.stream().reduce((e1, e2) -> {
			if(e1.getAge()<e2.getAge()) return e1;
			else return e2;
		}).get();
	}
	
}
