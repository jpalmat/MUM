package prob3.composition;

public class Cylinder {

	private Double heigtht;
	private Circle circle;
	
	public Cylinder(Double height, Double radius) {
		this.heigtht = height;
		circle = new Circle(radius);
	}

	public Double getHeigtht() {
		return heigtht;
	}

	public void setHeigtht(Double heigtht) {
		this.heigtht = heigtht;
	}
	
	public Double computeVolume() {
		return 3.14 * Math.pow(circle.getRadius(), 2)  * heigtht;
	}
}
