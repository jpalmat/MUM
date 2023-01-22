
public class Rectangle extends Shape  {
	private double width;
	private double lenght;
	
	public double getWidht(){
		return this.width;
	}
	public double getLenght(){
		return this.lenght;
	}
	
	public Rectangle(double width, double length){
		this.width = width;
		this.lenght = length;
	}
	
	@Override
	public double computeArea(){
		return this.width * this.lenght;
	}
}
