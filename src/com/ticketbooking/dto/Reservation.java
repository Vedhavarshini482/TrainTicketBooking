package com.ticketbooking.dto;

import java.util.ArrayList;
import java.util.List;

public class Reservation {

	List<TrainSeats> reservation;
	List<Amount> amount;

	public Reservation(){
		this.reservation=new ArrayList<>();
		this.amount=new ArrayList<>();
	}

	public List<TrainSeats> getReservation() {
		return reservation;
	}

	public void setReservation(List<TrainSeats> reservation) {
		this.reservation = reservation;
	}

	public List<Amount> getAmount() {
		return amount;
	}

	public void setAmount(List<Amount> amount) {
		this.amount = amount;
	}

}