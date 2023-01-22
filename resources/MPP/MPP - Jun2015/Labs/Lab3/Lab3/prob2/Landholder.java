import java.util.ArrayList;
import java.util.List;


public class Landholder {
	private ArrayList<Building> Buildings;
	
	public Landholder(){
		this.Buildings = new ArrayList<Building>();
	}
	public boolean addBuilding(Building b){
		return this.Buildings.add(b);
	}
	public int calculateMonthlyTotalProfit(){
	    int sum = 0;
	    for(int i = 0; i<this.Buildings.size();i++){
	    	sum += this.Buildings.get(i).getBuldingProfit();
	    }
		return sum;
	}
}
