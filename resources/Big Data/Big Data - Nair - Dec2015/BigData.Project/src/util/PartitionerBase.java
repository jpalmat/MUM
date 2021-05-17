package util;

public class PartitionerBase {
	
	public int getPartition(Integer i, int numberOfReducers) {			
		Integer reducers = numberOfReducers/2;		
		if(i < 500)
			return i%reducers;
		else  
			return i%reducers + reducers;		 
	}
}
