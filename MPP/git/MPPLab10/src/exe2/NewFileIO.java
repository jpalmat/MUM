package exe2;

import java.io.FileOutputStream;
import java.util.logging.Logger;

public class NewFileIO {
	private static final Logger LOG = Logger.getLogger(NewFileIO.class.getName());
	public final static String FILE_LOCATION = "src/exe2/output.txt";
	public final static String TO_PRINT = "This is the string to print to file.";

	public static void main(String[] args) {
		NewFileIO newFile = new NewFileIO();
		newFile.writeText(FILE_LOCATION, TO_PRINT);
	}
	
	void writeText(String filename, String text) {
		try(FileOutputStream newFileStream =new FileOutputStream(filename)){    
			byte byteArray[] = text.getBytes();   
			newFileStream.write(byteArray);      
			}catch(Exception e){  
				LOG.warning("IOException attempting to write a file: " + e.getMessage());
			}  
	}

}
