package lesson10.labsolns.prob4a;

/**
 * Holds a customer id and a zipcode
 *
 */
public class IdZip {
	private final int id;
	private final String zip;
	public IdZip(int id, String zip) {
		this.id = id;
		this.zip = zip;
	}
	public int getId() {
		return id;
	}
	public String getZip() {
		return zip;
	}
	@Override
	public String toString() {
		return "[" + id + ", " + zip + "]";
	}
}
