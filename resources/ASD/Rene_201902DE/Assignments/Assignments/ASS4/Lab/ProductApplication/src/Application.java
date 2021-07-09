import Model.Category;
import Model.Item;
import Model.ProductCatalog;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductCatalog productCatalog = new ProductCatalog();
		
		Category bookCategory = new Category("Book Category");
		Category frictionCategory = new Category("Friction Category");
		Category computerCategory = new Category("Computer Category");
		frictionCategory.addChild(new Item("Book 1", 1));
		frictionCategory.addChild(new Item("Book 2", 2));
		computerCategory.addChild(new Item("Book 3", 3));
		computerCategory.addChild(new Item("Book 4", 4));
		
		bookCategory.addChild(frictionCategory);
		bookCategory.addChild(computerCategory);
		
		productCatalog.addProduct(bookCategory);
		
		Category dVDCategory = new Category("DVD Category");
		Category drama = new Category("Drama Category");
		Category action = new Category("Action Category");
		drama.addChild(new Item("DVD 1", 1));
		drama.addChild(new Item("DVD 2", 2));
		action.addChild(new Item("DVD 3", 3));
		action.addChild(new Item("DVD 4", 4));
		
		dVDCategory.addChild(drama);
		dVDCategory.addChild(action);
		
		productCatalog.addProduct(dVDCategory);
		
		productCatalog.print();
		
	}

}
