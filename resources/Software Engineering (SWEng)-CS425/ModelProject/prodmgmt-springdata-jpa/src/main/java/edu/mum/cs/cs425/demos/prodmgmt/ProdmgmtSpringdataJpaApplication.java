package edu.mum.cs.cs425.demos.prodmgmt;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.cs.cs425.demos.prodmgmt.model.Product;
import edu.mum.cs.cs425.demos.prodmgmt.repository.ProductRepository;

@SpringBootApplication
public class ProdmgmtSpringdataJpaApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ProdmgmtSpringdataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product p = new Product(100L, "iphone xs max", 800.00f, LocalDate.of(2019, 8, 31));
		Product savedProduct = saveProduct(p);
//		System.out.println(savedProduct);
		for (Product p1 : getSpecialProducts()) {
			System.out.println(p1);
		}
	}

	Product saveProduct(Product p) {
		return repository.save(p);
	}

	List<Product> getSpecialProducts() {
		return repository.findProductsByUnitPriceGreaterThan(1500.00f);
	}

}
