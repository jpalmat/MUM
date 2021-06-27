package prob3;

final public class Rectangle implements Shape{
	private final double width;
	private final double length;
	
	public Rectangle(double width, double length) {
		super();
		this.width = width;
		this.length = length;
	}

	@Override
	public double computeArea() {
		return (width*length);
	}

}
