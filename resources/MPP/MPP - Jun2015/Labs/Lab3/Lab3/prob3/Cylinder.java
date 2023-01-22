
public class Cylinder extends Circle{

	private double height;

	public Cylinder(){
		
	}
	public Cylinder(double _radius){
		super(_radius);
	}
	public Cylinder(double _radius, double _height){
		super(_radius);
		this.height = _height;
	}
	
	public double getHeight(){
		return this.height;
	}
	
	public double getVolume(){
		return super.getArea() * this.height;
	}
}
