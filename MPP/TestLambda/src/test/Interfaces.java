package test;

public class Interfaces {
	
	
	public static void main(String[] args) {
		Test t = (x, y)-> x + y;
		System.out.println(t.operation(5, 6));
	}
}

interface Test {
	int operation(int a, int b);
	
	@Override
	String toString();
}