
public interface State {	
	
	final public static int MILES_LIMIT_SILVER = 75000;
	final public static int MILES_LIMIT_GOLD = 150000;
	final public static int FLIGHTS_LIMIT_SILVER = 75;
	final public static int FLIGHTS_LIMIT_GOLD = 145;
	
	public void addFlight(int newMiles);
	public void checkForUpdate();

}
