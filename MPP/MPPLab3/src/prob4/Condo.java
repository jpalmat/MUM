package prob4;

public class Condo extends Property{

	private Integer numberFloors;
	public Condo(int i) {
		this.numberFloors = i;
	}

	@Override
	double computeRent() {
		return 400 * numberFloors;
	}

}
