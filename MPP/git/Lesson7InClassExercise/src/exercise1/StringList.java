package exercise1;

public interface StringList {
	
	String[] strArray();
	int size();
	void incrementSize();
	
	/** Adds a string to the end of the list */
	public void add(String s);
	
	/** Gets the i_th string in the list */
	default String get(int i) {
		if (i < 0 || i >= size()) {
		return null;
	}
	return strArray()[i];
	}
	
}