package com.sirmcscruffybeard.diceroller.gui;

import com.sirmcscruffybeard.diceroller.dice.DICE;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainWindow extends Application {
	
	private BorderPane mainPane = null;
	
	private VBox buttonBox = null;
	
	private Result result = null;
	
	@Override
	public void start(Stage primaryStage) {
		
		
		
		primaryStage.setScene(new Scene(this.prepMainPane()));
		
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	private BorderPane prepMainPane() {
		
		this.mainPane = new BorderPane();
		
		this.mainPane.setCenter(this.prepResult());
		
		this.mainPane.setLeft(this.prepButtons());
		
		return this.mainPane;
	}
	
	private VBox prepButtons() {
		
		this.buttonBox = new VBox();
		
		for(DICE dice: DICE.values()) {
			
			dice.setResultArea(result);
			
			this.buttonBox.getChildren().add(dice.getButton());
			
			//this.buttonBox.setVgrow(dice.getButton(), Priority.ALWAYS);
		}
		
		return this.buttonBox;
	}
	
	private Pane prepResult() {
		
		double width = 300;
		
		double height = 300;
		
		StackPane pane = new StackPane(this.result = new Result());
		
		pane.setPrefSize(width, height);
		
		return pane;
	}
}
