package Exe1.gui;


import Exe1.rulesSet.RuleException;
import Exe1.rulesSet.RuleSet;
import Exe1.rulesSet.RuleSetFactory;
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

public class InfoWindow extends Application{
	
	private TextField nameTxt, streetTxt, cityTxt, stateTxt, zipTxt;

	public TextField getNameTxt() {
		return nameTxt;
	}

	public TextField getStreetTxt() {
		return streetTxt;
	}

	public TextField getCityTxt() {
		return cityTxt;
	}

	public TextField getStateTxt() {
		return stateTxt;
	}

	public TextField getZipTxt() {
		return zipTxt;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Ädrress Form");
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(25, 25, 25, 25));
		
		Label nameLabel = new Label("Name");
		pane.add(nameLabel, 0, 1);
		
		nameTxt = new TextField();
		pane.add(nameTxt, 0, 2);
		
		Label streetLabel = new Label("Street");
		pane.add(streetLabel, 1, 1);
		
		streetTxt = new TextField();
		pane.add(streetTxt, 1, 2);
		
		Label cityLabel = new Label("City");
		pane.add(cityLabel, 2, 1);
		
		cityTxt = new TextField();
		pane.add(cityTxt, 2, 2);
		
		Label stateLabel = new Label("State");
		pane.add(stateLabel, 1, 3);
		
		stateTxt = new TextField();
		pane.add(stateTxt, 1, 4);
		
		Label zipLabel = new Label("Zip");
		pane.add(zipLabel, 2, 3);
		
		zipTxt = new TextField();
		pane.add(zipTxt, 2, 4);
		
		Button submitBtn = new Button("Sing in");
		pane.add(submitBtn, 1, 5);
		
		submitBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				RuleSet rules = RuleSetFactory.getRuleSet(InfoWindow.this);
				try {
					rules.applyRules(InfoWindow.this);
					buildMesagge();
				} catch (RuleException e) {

					System.out.println("fields empty");
				}
			}

			private void buildMesagge() {
				StringBuilder msj = new StringBuilder();
				msj.append(nameTxt.getText()).append("\n");
				msj.append(streetTxt.getText()).append("\n");
				msj.append(cityTxt.getText()).append(", ").append(stateTxt.getText()).append(" ").append(zipTxt.getText());
				System.out.println(msj.toString());
			}
			
		});
		
		
		
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
