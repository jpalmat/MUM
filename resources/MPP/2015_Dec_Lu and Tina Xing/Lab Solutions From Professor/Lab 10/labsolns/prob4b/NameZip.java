package lesson10.labsolns.prob4b;

/**
 * Holds a customer id and a zipcode
 *
 */
public class NameZip {
	private final String name;
	private final String zip;
	public NameZip(String name, String zip) {
		this.name = name;
		this.zip = zip;
	}
	public String getName() {
		return name;
	}
	public String getZip() {
		return zip;
	}
	@Override
	public String toString() {
		return "[" + name + ", " + zip + "]";
	}
	@Override
	public boolean equals(Object ob) {
		if (ob == null) return false;
		if(ob instanceof NameZip) {
			NameZip nz = (NameZip)ob;
			return nz.name.equals(name) && nz.zip.equals(zip); 
		}
		return false;
	}
}
