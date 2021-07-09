
public class FFAccount {
	private String accountNumber;
	private int numberOfMiles;
	private int numberOfFlights;
	State silverState; 
	State goldState;
	State platiniumState;
	
	private State accountType;
	
	public FFAccount(String aNumber) {
		accountNumber = aNumber;
		silverState = new SilverState(this);
		goldState = new GoldState(this);
		platiniumState = new PlatiniumState(this);
		accountType = silverState;
	}

	public void addFlight(int newMiles) {
		accountType.addFlight(newMiles);
	}

	public State getAccountType() {
		return accountType;
	}

	public void setAccountType(State accountType) {
		this.accountType = accountType;
	}

	public int getNumberOfMiles() {
		return numberOfMiles;
	}

	public int getNumberOfFlights() {
		return numberOfFlights;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setNumberOfMiles(int numberOfMiles) {
		this.numberOfMiles = numberOfMiles;
	}

	public void setNumberOfFlights(int numberOfFlights) {
		this.numberOfFlights = numberOfFlights;
	}
	
}