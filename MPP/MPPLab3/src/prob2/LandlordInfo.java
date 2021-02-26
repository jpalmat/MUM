package prob2;

import java.util.ArrayList;
import java.util.List;

public class LandlordInfo {

	String name; 
	List<Building> buildings; 
	
	public LandlordInfo(){
		buildings = new ArrayList<>(); 
	}
	public int calcProfits() {
		int totalProfit = 0; 
		
		for(Building bld: this.buildings) {
			totalProfit+=bld.rentRevenue(); 
		}
		
		return totalProfit; 
	}
	
	public void addBuilding(Building building) {
		this.buildings.add(building); 
	}
}