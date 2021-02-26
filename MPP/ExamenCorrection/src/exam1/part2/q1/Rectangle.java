package exam1.part2.q1;

public class Rectangle {
	
	double side1, side2, diagonal;

	/*
	 //original
	 public Rectangle(double side1, double side2) {
		super();
		this.side1 = side1;
		this.side2 = side2;
	}

	public Rectangle(double side1, double diagonal) {
		super();
		this.side1 = side1;
		this.diagonal = diagonal;
	}
	*/
	
	private Rectangle(double side1, double side2) {
		super();
		this.side1 = side1;
		this.side2 = side2;
	}
	
	public static Rectangle getRectangleBySideAndDiagonal(double side1, double diagonal) {
		double side2 = side1 = diagonal; //this calculation is wrong
		Rectangle rectangle = new Rectangle(side1, side2);
		rectangle.diagonal = diagonal;
		return rectangle;
	}
	
	public static Rectangle getRectangleBySideAndSide(double side1, double side2) {
		return new Rectangle(side1, side2);
	}

}
