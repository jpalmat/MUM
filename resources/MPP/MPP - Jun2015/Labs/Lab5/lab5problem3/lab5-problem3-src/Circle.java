
public class Circle extends Shape  {
	private double radius;
	
	public double getRadius(){
		return this.radius;
	}
	
	public Circle(double radious){
		this.radius = radious;
	}
	
	@Override
	public double computeArea(){
		return  Math.PI * this.radius *this.radius;
	}
}
