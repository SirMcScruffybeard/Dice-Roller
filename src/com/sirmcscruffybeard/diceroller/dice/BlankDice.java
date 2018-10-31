package com.sirmcscruffybeard.diceroller.dice;

public interface BlankDice {

	public void setSides(int inSides);
	
	public int getSides();
	
	public void setName(String inName);
	
	public String getName();
	
	public int roll();
}
