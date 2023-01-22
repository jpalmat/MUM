
public class Main {

	public static void main(String[] args){
		Landholder holder = new Landholder();
		
		Building b1 = new Building();
		
		b1.AddApartment(new Apartment(50));
		b1.AddApartment(new Apartment(150));
		b1.setMaintenanceCost(100);
		
		Building b2 = new Building();
		b2.setMaintenanceCost(90);
		b2.AddApartment(new Apartment(100));
		b2.AddApartment(new Apartment(200));
		
		holder.addBuilding(b1);
		holder.addBuilding(b2);
		
		int totalRent = holder.calculateMonthlyTotalProfit();
		System.out.print("Total Rent: " + totalRent);
	}
}
