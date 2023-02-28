package com.ticketbooking.dto;

import java.util.List;

public class MyBooking {

	private int id, payment, bookingSeats;
	private String trainName, fromStation, toStation, trainNumber, quota, statement;
	private List<String> seatType;

	public List<String> getSeatType() {
		return seatType;
	}

	public void setSeatType(List<String> seatType) {
		this.seatType = seatType;
	}

	public MyBooking(int id, int payment, int bookingSeats, String trainName, String fromStation, String toStation,
			String trainNumber, String quota, String statement, List<String> seatType) {
		this.id = id;
		this.payment = payment;
		this.bookingSeats = bookingSeats;
		this.trainName = trainName;
		this.fromStation = fromStation;
		this.toStation = toStation;
		this.trainNumber = trainNumber;
		this.quota = quota;
		this.statement = statement;
		this.seatType = seatType;
	}

	MyBooking() {

	}

	public int getBookingSeats() {
		return bookingSeats;
	}

	public void setBookingSeats(int bookingSeats) {
		this.bookingSeats = bookingSeats;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public String getQuota() {
		return quota;
	}

	public void setQuota(String quota) {
		this.quota = quota;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getFromStation() {
		return fromStation;
	}

	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}

	public String getToStation() {
		return toStation;
	}

	public void setToStation(String toStation) {
		this.toStation = toStation;
	}

	public String getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}

}