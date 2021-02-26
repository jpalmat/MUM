package test;

public interface B extends A {

	
	 default void method() {
		 System.out.println("prueba");
	 }
}
