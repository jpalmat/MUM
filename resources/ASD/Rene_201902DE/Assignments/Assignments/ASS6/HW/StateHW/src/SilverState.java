
public class SilverState implements State {
	
	
	private FFAccount account;
	
	
	public SilverState(FFAccount account) {
		this.account = account;
	}

	@Override
	public void addFlight(int newMiles) {
		// TODO Auto-generated method stub
		account.setNumberOfFlights(account.getNumberOfFlights()+1);
		account.setNumberOfMiles(account.getNumberOfMiles()+newMiles);
		checkForUpdate();
	}
	
	public void checkForUpdate() {
		if (account.getNumberOfMiles()>MILES_LIMIT_SILVER || account.getNumberOfFlights()>FLIGHTS_LIMIT_SILVER) {
			account.setAccountType(account.goldState);
		}
	}
}
