package company;

public class Hourly extends Employee {

	private Double hourlyWage;
	private Integer hoursPerWeek;
	
	public Hourly (Double hourlyWage, Integer hoursPerWeek) {
		this.hourlyWage = hourlyWage;
		this.hoursPerWeek = hoursPerWeek;
	}
	
	
	@Override
	Double calcGrossPay(Integer month, Integer yr) {
		return hourlyWage * hoursPerWeek * 4;
	}

}
