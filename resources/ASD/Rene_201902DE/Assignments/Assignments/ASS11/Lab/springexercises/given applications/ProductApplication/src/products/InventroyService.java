package products;

public class InventroyService implements IInventoryService {

	@Override
	public int getNumberInStock(int productNumber) {
		// TODO Auto-generated method stub
		return productNumber-200;
	}

}
