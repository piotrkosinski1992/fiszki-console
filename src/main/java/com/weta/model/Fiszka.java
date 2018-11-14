package com.weta.model;

public class Fiszka {

	private String firstSide;
	private String secondSide;
	
	public Fiszka(String polski, String lacinski) {
		this.firstSide = polski;
		this.secondSide = lacinski;
	}

	public String getFirstSide() {
		return firstSide;
	}

	public void setFirstSide(String firstSide) {
		this.firstSide = firstSide;
	}

	public String getSecondSide() {
		return secondSide;
	}

	public void setSecondSide(String secondSide) {
		this.secondSide = secondSide;
	}	
}
