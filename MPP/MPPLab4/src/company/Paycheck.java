package company;

public final class Paycheck {
	
	private Double grossPay;
	private Double fica;
	private Double state;
	private Double local;
	private Double medicare;
	private Double socialSecurity;
	
	public Paycheck(Double grossPay, Double fica, Double state, Double local, Double medicare, Double socialSecurity) {
		this.grossPay = grossPay;
		this.fica = fica;
		this.state = state;
		this.local = local;
		this.medicare = medicare;
		this.socialSecurity = socialSecurity;
	}
	

	public String print() {
		return "salary is " + grossPay;
	}
	
	public void getNetPay() {
		
	}
}
