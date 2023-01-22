import java.util.*;


public class Main {

		public static void main(String[] args){
			
			List<Shape> shapes = new ArrayList<Shape>();
			
			shapes.add(new Circle(1.0));
			shapes.add(new Rectangle(2.0, 1.5));
			shapes.add(new Triangle(2.0, 1.6));
			
			double sumOfAllAreas = 0;
			for(Shape s: shapes){
				sumOfAllAreas +=s.computeArea();
			}
			System.out.println("Sum of all areas : " + sumOfAllAreas);
			
		}
}
