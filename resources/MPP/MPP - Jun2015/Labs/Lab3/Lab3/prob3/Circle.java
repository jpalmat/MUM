
public class Circle {

	private double radius;
	private String color;
	
	public Circle(){
		
	}
	
	public Circle(double _radius){
		this.radius = _radius;
	}
	
	
	public double getRadius(){
		return this.radius;
	}
	
	public double getArea(){
		return Math.PI*this.radius*this.radius;
	}
	
}
