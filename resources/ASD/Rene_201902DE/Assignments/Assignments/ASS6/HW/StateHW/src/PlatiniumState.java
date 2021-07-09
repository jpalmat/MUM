
public class PlatiniumState implements State {
	
	
	private FFAccount account;
	
	
	public PlatiniumState(FFAccount account) {
		this.account = account;
	}

	@Override
	public void addFlight(int newMiles) {
		// TODO Auto-generated method stub
		account.setNumberOfFlights(account.getNumberOfFlights()+2);
		account.setNumberOfMiles(account.getNumberOfMiles()+newMiles*3);
		checkForUpdate();
	}
	
	public void checkForUpdate() {
		
	}
}
