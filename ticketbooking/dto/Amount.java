package com.ticketbooking.dto;

public class Amount {

	int firstAC, secondAC, thirdAC, sleeper, secondSitting;

	Amount(){
		
	}
	
	public Amount(int firstAC, int secondAC, int thirdAC, int sleeper, int secondSitting) {
		this.firstAC = firstAC;
		this.secondAC = secondAC;
		this.thirdAC = thirdAC;
		this.sleeper = sleeper;
		this.secondSitting = secondSitting;
	}

	public int getFirstAC() {
		return firstAC;
	}

	public void setFirstAC(int firstAC) {
		this.firstAC = firstAC;
	}

	public int getSecondAC() {
		return secondAC;
	}

	public void setSecondAC(int secondAC) {
		this.secondAC = secondAC;
	}

	public int getThirdAC() {
		return thirdAC;
	}

	public void setThirdAC(int thirdAC) {
		this.thirdAC = thirdAC;
	}

	public int getSleeper() {
		return sleeper;
	}

	public void setSleeper(int sleeper) {
		this.sleeper = sleeper;
	}

	public int getSecondSitting() {
		return secondSitting;
	}

	public void setSecondSitting(int secondSitting) {
		this.secondSitting = secondSitting;
	}

}