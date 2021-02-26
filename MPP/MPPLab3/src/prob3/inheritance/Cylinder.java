package prob3.inheritance;

public class Cylinder {

	private Double heigtht;
	private Double radius;
	
	public Cylinder(Double radius, Double height) {
		this.heigtht = height;
		this.radius = radius;
	}

	public Double getHeigtht() {
		return heigtht;
	}

	public void setHeigtht(Double heigtht) {
		this.heigtht = heigtht;
	}

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}
	
	public Double computeVolume() {
		return 3.14 * radius * radius * heigtht;
	}
}
