package com.sirmcscruffybeard.diceroller.dice;

//import com.sirmcscruffybeard.diceroller.TerminalKt;
import com.sirmcscruffybeard.diceroller.gui.Result;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public enum DICE implements BlankDice {

	D4(4, "D4"), D6(6, "D6"), D8(8, "D8"), D10(10, "D10"), D12(12, "D12"), D20(20, "D20"), D100(100, "Precentile");
	
	private String name = "";
	
	private int sides = 0;
	
	private double width = 85.0, addHeight = 45.0;
		
	private Button button = null;
	
	private Result result = null;
	
	DICE(int inSides, String inName) {
		
		this.setSides(inSides);
		
		this.setName(inName);
	}
	

	@Override
	public void setSides(int inSides) {
		
		this.sides = inSides; 
	}

	@Override
	public int getSides() {
		
		return this.sides;
	}

	@Override
	public void setName(String inName) {
		
		this.name = inName;
		
	}

	@Override
	public String getName() {

		return this.name;
	}
	
	public void setResultArea(Result inResult) {
		
		this.result = inResult;
	}

	@Override
	public int roll() {
		
		long seed = 0;
		
		int result = 0;
		
		seed = new Random().nextLong();
		
		Random roller = new Random(seed);
		
		while(result == 0) result = roller.nextInt(this.getSides()+1);
		
		return result;
	}
	
	private Button prepButton() {
		
		this.button = new Button(this.getName());
		
		this.setWidth(width);
		
		this.setHeight(button.getHeight() + this.addHeight);
		
		this.button.setOnAction(new RollHandeler(this, this.result));
		
		return button;
	}
	
	public Button getButton() {
		
		return this.prepButton();
	}
	
	public void setWidth(double inWidth) {
		
		this.width = inWidth;
		
		this.button.setMinWidth(width);
	}
	
	public void setHeight(double inHeight ) {
		
		this.button.setMinHeight(inHeight);
	}
	
	private class RollHandeler implements javafx.event.EventHandler<ActionEvent> {

		DICE dice = null;
		
		Result result = null;
		
		public RollHandeler(DICE inDice, Result inArea) {
			
			this.dice = inDice;
			
			this.result = inArea;
		}
		
		@Override
		public void handle(ActionEvent event) {
			
			//new com.sirmcscruffybeard.diceroller.Terminal();
			
			//TerminalKt.display(dice.roll());
			
			result.setResult(String.valueOf(dice.roll()));
			
		}
		
		
	}
}
