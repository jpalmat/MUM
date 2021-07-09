package Model;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
	private List<Product> products;

	public ProductCatalog() {
		products = new ArrayList<>();
	}
	
	public void addProduct(Product p) {
		products.add(p);
	}
	
	public void removeProduct(Product p) {
		products.remove(p);
	}
	
	public void print() {
		
		for (Product product:products) {
			product.print();
			System.out.println("--------------------------------");
		}
	}
}
