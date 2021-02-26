package prob3;

public class Main {

	public static void main(String[] args) {
		Shape[] sh= {new Triangle(2,3.2),new Circle(5),
					 new Rectangle(2.3,8.5),new Triangle(2.3,7)};
		double totalArea=0.0;
		for(Shape s:sh) {
			totalArea+=s.computeArea();
		}
		System.out.println("Total Area is: "+totalArea);
	}
	

}

