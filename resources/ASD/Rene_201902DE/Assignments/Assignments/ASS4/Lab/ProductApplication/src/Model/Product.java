package Model;

public interface Product {
	
	public default void addChild(Product p) {
		throw new UnsupportedOperationException();
	}
	public default void removeChild(int i) {
		throw new UnsupportedOperationException();
	}
	public void print();
	
}
