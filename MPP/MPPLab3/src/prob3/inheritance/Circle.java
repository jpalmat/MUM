package prob3.inheritance;

public class Circle extends Cylinder {

	private Double radius;
	
	public Circle(Double radius) {
		super(radius, 0.0);
		this.radius = radius;
	}

	public Double getRadius() {
		return radius;
	}

	public Double computeArea() {
		return 3.14 * radius * radius;
	}

}
