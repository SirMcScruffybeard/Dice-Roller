package com.sirmcscruffybeard.diceroller.gui;

//import com.sirmcscruffybeard.diceroller.GlobalKt;

import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Result extends Text{
	
	private int size = 100;
	
	private String startingResult = "0";
	
	public Result() {
		
		//new com.sirmcscruffybeard.diceroller.Global();
		
		this.setText(this.startingResult);
		
		this.prepFont();
			
	}
	
	public void setResult(String inResult) {
		
		this.setText(inResult);
		
	}
	
	public void prepFont() {
		
		this.setFont(Font.font(size));
		
		this.setEffect(new DropShadow(2,3,3, Color.RED));
		
	}
		
}
