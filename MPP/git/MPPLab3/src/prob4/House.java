package prob4;

public class House extends Property{
	
	private Integer lotSize;

	public House(int i) {
		this.lotSize = i;
	}

	@Override
	double computeRent() {
		return 0.1 * lotSize;
	}
}
