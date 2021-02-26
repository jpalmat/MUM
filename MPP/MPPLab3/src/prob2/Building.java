package prob2;

import java.util.ArrayList;
import java.util.List;

public class Building {
	int maintainceCost; 
	List<Apartment> appartments; 	
	
	
	public int getMaintainceCost() {
		return maintainceCost;
	}

	public void setMaintainceCost(int maintainceCost) {
		this.maintainceCost = maintainceCost;
	}

	Building(int maintaince, List<Apartment> apts){
		this.maintainceCost = maintaince; 
		this.appartments = apts; 
	}
	
	int rentRevenue() {
		int total = 0;  
		for(Apartment apt: this.appartments) {
			total+= apt.getRent(); 
		}
		
		return total - this.getMaintainceCost(); 
	}
}