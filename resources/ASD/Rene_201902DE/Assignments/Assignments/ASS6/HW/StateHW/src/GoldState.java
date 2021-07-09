
public class GoldState implements State {
	
	
	private FFAccount account;
	
	
	public GoldState(FFAccount account) {
		this.account = account;
	}

	@Override
	public void addFlight(int newMiles) {
		// TODO Auto-generated method stub
		account.setNumberOfFlights(account.getNumberOfFlights()+1);
		account.setNumberOfMiles(account.getNumberOfMiles()+newMiles*2);
		checkForUpdate();
	}
	
	public void checkForUpdate() {
		if (account.getNumberOfMiles()>MILES_LIMIT_GOLD || account.getNumberOfFlights()>FLIGHTS_LIMIT_GOLD) {
			account.setAccountType(account.platiniumState);
		}
	}
}
