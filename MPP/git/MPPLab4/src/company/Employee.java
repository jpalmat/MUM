package company;

public abstract class Employee {

	private Integer empId;
	private Double total;
	
	
	public void print() {
		
	}
	
	public Paycheck calcCompensation(Integer month, Integer year) {
		
		total = calcGrossPay(month, year);
		Double fica = total * 0.23;
		Double state = total * 0.05;
		Double local = total * 0.01;
		Double medicare = total * 0.03;
		Double socialSecurity = total * 0.075;
		Double grossPay = total - fica - state - local - medicare - socialSecurity;
		
		
		Paycheck pay1 = new Paycheck(grossPay, fica, state, local, medicare, socialSecurity);
		
		return pay1;	
	}
	
	abstract Double calcGrossPay(Integer month, Integer yr); 
}
