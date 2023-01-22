package lesson10.labsolns.prob3;

import java.io.*;

public class NewFileIO {
	public final static String FILE_LOCATION = "src/lesson10/labsolns/prob3/word_test.txt";
	public void readText(String filename) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader(filename));
		r.lines().forEach(System.out::println);
		r.close();		                                             	
	}
	public static void main(String[] args) {
		NewFileIO newFIO = new NewFileIO();
		String filename = FILE_LOCATION;
		try {
			newFIO.readText(filename);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
