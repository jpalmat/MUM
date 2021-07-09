package Model;

import java.util.ArrayList;
import java.util.List;

public class Category implements Product {
	private List<Product> products;
	private String title;
	
	public Category(String title) {
		super();
		this.title = title;
		products = new ArrayList<>();
	}

	public List<Product> getProducts() {
		return products;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public void addChild(Product p) {
		// TODO Auto-generated method stub
		products.add(p);
	}

	@Override
	public void removeChild(int i) {
		// TODO Auto-generated method stub
		products.remove(i);
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Category : "+title);
		System.out.println("----------------------------------");
		for (Product product:products) {
			product.print();
		}
	}
		
}
