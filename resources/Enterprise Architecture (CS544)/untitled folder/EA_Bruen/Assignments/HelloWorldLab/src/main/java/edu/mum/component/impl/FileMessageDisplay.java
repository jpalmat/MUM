package edu.mum.component.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mum.component.MessageDisplay;
import edu.mum.component.MessageOrigin;

@Component
public class FileMessageDisplay implements MessageDisplay {

	@Autowired
	private MessageOrigin messageSource;

	public void display() {
		if (messageSource == null) {
			throw new RuntimeException("You must set the property messageSource of class:" + FileMessageDisplay.class.getName());
		}
		System.out.println(messageSource.getMessage());

		writeMessageToFile();
	}

	public MessageOrigin getMessageSource() {
		return this.messageSource;
	}

	public void writeMessageToFile() {
		String fileName = "test.txt";
		String path = this.getClass().getClassLoader().getResource(".").getFile();

		// create file
		File file = new File("E:\\MuM\\5-EA\\Assignments\\Output.txt");
		try {
			if (file.createNewFile()) {
				System.out.println("File is created!");
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(messageSource.getMessage());
			bufferedWriter.close();
			System.out.println("Message written to File in target/classes " + fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return;
	}
}
