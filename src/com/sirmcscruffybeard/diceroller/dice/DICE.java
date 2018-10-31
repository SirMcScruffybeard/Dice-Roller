package com.sirmcscruffybeard.diceroller.dice;

import java.util.Random;

public enum DICE implements BlankDice {

	D4(4, "D4"), D6(6, "D6"), D8(8, "D8"), D10(10, "D10"), D12(12, "D12"), D20(20, "D20"), D100(100, "Precentile");
	
	private String name = "";
	
	private int sides = 0;
	
	Random roller = null;
	
	DICE(int inSides, String inName) {
		
		this.setSides(inSides);
		
		this.setName(inName);
		
		this.roller = new Random();
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

	@Override
	public int roll() {
		
		int result = 0;

		while(result == 0) result = this.roller.nextInt(this.getSides()+1);
		
		return result;
	}
	
}
