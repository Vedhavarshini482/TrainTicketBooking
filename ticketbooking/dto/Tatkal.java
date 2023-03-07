package com.ticketbooking.dto;

import java.util.ArrayList;
import java.util.List;

public class Tatkal {

	List<TrainSeats> tatkal;
	List<Amount> amount;

	public Tatkal(){
		this.tatkal=new ArrayList<>();
		this.amount=new ArrayList<>();
	}

	public List<TrainSeats> getTatkal() {
		return tatkal;
	}

	public void setTatkal(List<TrainSeats> tatkal) {
		this.tatkal = tatkal;
	}

	public List<Amount> getAmount() {
		return amount;
	}

	public void setAmount(List<Amount> amount) {
		this.amount = amount;
	}
	
}