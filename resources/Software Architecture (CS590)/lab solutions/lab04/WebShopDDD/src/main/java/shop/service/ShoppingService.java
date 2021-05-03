package shop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.domain.shopping.Product;
import shop.domain.shopping.ShoppingCart;
import shop.repository.ShoppingCartRepository;

@Service
public class ShoppingService {
	@Autowired
	ProductCatalogService productCatalogService;
	@Autowired
	ShoppingCartRepository shoppingCartRepository;
	@Autowired
	OrderService orderService;

	public void addToCart(String cartId, String productnumber, int quantity) {
		shop.domain.products.Product productsproduct = productCatalogService.getProduct(productnumber);
		//create a shopping product from a products product
		Product product = new Product(productsproduct.getProductnumber(),productsproduct.getDescription(),productsproduct.getPrice());
		Optional<ShoppingCart> cartOptional = shoppingCartRepository.findById(cartId);
		if (cartOptional.isPresent() && product != null) {
			ShoppingCart cart = cartOptional.get();
			cart.addToCart(product, quantity);
			shoppingCartRepository.save(cart);
		}
		else if (product != null) {
			ShoppingCart cart = new ShoppingCart();
			cart.setCartid(cartId);
			cart.addToCart(product, quantity);
			shoppingCartRepository.save(cart);
		}		
	}
	
	public ShoppingCart getCart(String cartId) {
		Optional<ShoppingCart> cart = shoppingCartRepository.findById(cartId);
		if (cart.isPresent())
		  return cart.get();
		else
			return null;
	}

	public void checkout(String cartId) {
		Optional<ShoppingCart> cart = shoppingCartRepository.findById(cartId);
		if (cart.isPresent()) {
			orderService.createOrder(cart.get());
		}		
	}
}
