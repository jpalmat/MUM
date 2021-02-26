package prob2;

import java.util.*;
//This is a suggested way to test your code. It makes
//assumptions about the constructors and methods in the
//classes you will create. You may wish to modify this
//code in a way that suits your implementation of the other classes.
public class Main {

public static void main(String[] args) {
	
	List<Apartment> apts1 =  new ArrayList<>(); 
		apts1.add(new Apartment(400)); 
		apts1.add(new Apartment(600)); 
		apts1.add(new Apartment(700));
		
	List<Apartment> apts2 =  new ArrayList<>();
		apts2.add(new Apartment(900)); 
		apts2.add(new Apartment(500));  
		apts2.add(new Apartment(450)); 
	
	List<Apartment> apts3 =  new ArrayList<>();
			apts3.add(new Apartment(300));
			apts3.add(new Apartment(1100)); 
			apts3.add(new Apartment(650));
			
	List<Apartment> apts4 = new ArrayList<>(); 
		apts4.add(new Apartment(775));
		apts4.add(new Apartment(6750));
		apts4.add(new  Apartment(945)); 
	
	List<Building> bldgs = new ArrayList<>(); 
	
	
		bldgs.add(new Building(150,apts1)); 
		bldgs.add(new Building(175,apts2));
		bldgs.add(new Building(150, apts3));
		bldgs.add(new Building(175, apts4));
	

	LandlordInfo landlord = new LandlordInfo();
	for(Building b: bldgs) {
		landlord.addBuilding(b);
	}
	System.out.println(landlord.calcProfits());
			
	}

}