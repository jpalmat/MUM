
public class Triangle extends Shape {
	private double base;
	private double height;
	
	public double getBase(){
		return this.base;
	}
	public double getHeight(){
		return this.height;
	}
	
	public Triangle(double bas, double height){
		this.base = base;
		this.height = height;
	}
	
	@Override
	public double computeArea(){
		return this.height* this.base / 2;
	}
}
