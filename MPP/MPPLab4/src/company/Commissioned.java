package company;

import java.util.ArrayList;
import java.util.List;

public class Commissioned extends Employee{

	private Double commission;
	private Double baseSalary;
	
	private Double totalAmount = 0.0;
	
	private List<Order> listOrder =new ArrayList<Order>();
	
	@Override
	Double calcGrossPay(Integer month, Integer yr) {
		this.listOrder.stream().forEach(p -> totalAmount+=p.getOrderAmount());
		return baseSalary + (commission * totalAmount);
	}

	public Double getCommission() {
		return commission;
	}

	public void setCommission(Double commission) {
		this.commission = commission;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<Order> getListOrder() {
		return listOrder;
	}

	public void setListOrder(List<Order> listOrder) {
		this.listOrder = listOrder;
	}
}
