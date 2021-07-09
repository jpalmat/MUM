import java.util.HashSet;

public class MostFavoriteCustomer {
	
	public static HashSet<String> customers = new HashSet<String>();

	public static void addCustomer(String name) {
		customers.add(name);
	}
	
	public static boolean checkCustomerIsFavorite(String name) {
		return customers.contains(name);
	}
}
