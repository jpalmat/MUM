package Exe2.gui;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StringUtility extends Application{
	
	private Button countLetter, reverseLetter, removeDuplicates;
	private TextField inputTxt, outputTxt;

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("String utility");
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(25, 25, 25, 25));
		
		countLetter = new Button("countLetter");
		pane.add(countLetter, 0, 1);
		countLetter.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				countLetter();
			}

			private void countLetter() {
				Integer count = inputTxt.getText().length();
				outputTxt.setText(count.toString());
			}
		});
		
		reverseLetter = new Button("reverseLetter");
		pane.add(reverseLetter, 0, 2);
		reverseLetter.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				StringBuilder letters = new StringBuilder(inputTxt.getText());
				outputTxt.setText(letters.reverse().toString());
			}
		});
		
		removeDuplicates = new Button("removeDuplicates");
		pane.add(removeDuplicates, 0, 3);
		removeDuplicates.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				List<String> list = Arrays.asList(inputTxt.getText().split(""));
				Set<String> a = new HashSet<String>(list);
				outputTxt.setText(a.stream().collect(Collectors.joining( "" )));
			}
		});
		
		Label inputLabel = new Label("Input");
		pane.add(inputLabel, 1, 1);
		
		inputTxt = new TextField();
		pane.add(inputTxt, 1, 2);
		
		Label zipLabel = new Label("Output");
		pane.add(zipLabel, 1, 3);
		
		outputTxt = new TextField();
		pane.add(outputTxt, 1, 4);
		
		
		
		
		
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
