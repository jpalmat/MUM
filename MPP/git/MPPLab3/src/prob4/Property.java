package prob4;

public abstract class Property {

	private Double rent;

	public Double getRent() {
		return rent;
	}

	public void setRent(Double rent) {
		this.rent = rent;
	}
	
	abstract double computeRent();
}
