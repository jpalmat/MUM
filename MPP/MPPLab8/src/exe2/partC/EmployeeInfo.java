package exe2.partC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeInfo {
	static enum SortMethod {BYNAME, BYSALARY};
	public void sort(List<Employee> emps,  SortMethod method) {	
		Collections.sort(emps, (e1,e2) ->
		{
			if(method == SortMethod.BYNAME) {
				if(e1.name.equals(e2.name) && e1.salary == e2.salary) {
					return 0;
				} else {
					return e1.name.compareTo(e2.name);
				}
			} else {
				if(e1.salary == e2.salary) 
				{
					return e1.name.compareTo(e2.name);
				} else if(e1.salary < e2.salary) 
					return -1;
				else 
					return 1;
			}
		});			
	}
	
	public static void main(String[] args) {
		List<Employee> emps = new ArrayList<>();
		emps.add(new Employee("Joe", 1000));
		emps.add(new Employee("Tim", 150));
		emps.add(new Employee("Andy", 1116000));
		EmployeeInfo ei = new EmployeeInfo();
		ei.sort(emps, EmployeeInfo.SortMethod.BYNAME);
		System.out.println(emps);
		//same instance
		ei.sort(emps, EmployeeInfo.SortMethod.BYSALARY);
		System.out.println(emps);
	}
}
