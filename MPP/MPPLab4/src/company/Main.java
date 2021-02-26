package company;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Employee hourly = new Hourly(10.0, 40);
		Employee salary = new Salaried(1200.0);
		
		Paycheck grossPayHourly = hourly.calcCompensation(1, 2019);
		Paycheck grossPaySalary = salary.calcCompensation(1, 2019);
		
		System.out.println("********Hourly");
		System.out.println(grossPayHourly.print());
		
		System.out.println("********Salaried");
		System.out.println(grossPaySalary.print());
		
		/////////////////////////////////
		Order[] orders = {new Order(1, LocalDate.now(), 100.0), 
				new Order(2, LocalDate.now(), 100.0),
				new Order(3, LocalDate.now(), 100.0)};
		
		Commissioned com = new Commissioned();
		com.setCommission(0.1);
		com.setBaseSalary(300.0);
		com.setListOrder(Arrays.asList(orders));
		
		System.out.println("********Commissioned");
		
		Paycheck grossPayCom = com.calcCompensation(1, 2019);
		System.out.println(grossPayCom.print());

	}

}
