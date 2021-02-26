package company;

public class Salaried extends Employee{

	private Double salary;
	
	public Salaried(Double salary) {
		this.salary =salary;
	}
	
	@Override
	Double calcGrossPay(Integer month, Integer yr) {
		return salary;
	}

}
