import java.util.ArrayList;
import java.util.List;


public class Building {
 
	private int maintenanceCost;
	private ArrayList<Apartment> Apartments;
	
	public Building(){
		this.Apartments = new ArrayList<Apartment>();
	}
	
	public void setMaintenanceCost(int cost){
		this.maintenanceCost = cost;
	}
	
	public boolean AddApartment(Apartment a){
		return this.Apartments.add(a);	
	}
	public int getBuldingProfit(){
		int sum = 0;
		for(int i = 0; i<this.Apartments.size();i++)		{
			sum += this.Apartments.get(i).getRent();
		}
		return sum - this.maintenanceCost;
	}
}
