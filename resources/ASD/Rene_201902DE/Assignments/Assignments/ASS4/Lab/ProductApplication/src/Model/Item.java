package Model;

public class Item implements Product {
	
	private String title;
	private int id;
	
	public Item(String title,int id) {
		super();
		this.title = title;
		this.id = id;
	}
	
	

	public int getId() {
		return id;
	}



	public String getTitle() {
		return title;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Product : "+title+","+id);
	}

}
