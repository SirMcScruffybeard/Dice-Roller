package com.sirmcscruffybeard.diceroller;

public class Terminal {

	public void display(String inString) {
		
		System.out.println(inString);
	}
	
	public void display(int inInt) {
		
		display(String.valueOf(inInt));
	}
	
	public void display(double inDouble) {
		
		display(String.valueOf(inDouble));
	}
	
}
