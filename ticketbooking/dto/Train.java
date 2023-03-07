package com.ticketbooking.dto;

public class Train {

	@Override
	public String toString() {
		return "Train [id=" + id + ", trainName=" + trainName + ", fromStation=" + fromStation + ", toStation="
				+ toStation + ", time=" + time + ", trainNo=" + trainNo + ", bookedReservationSeats="
				+ bookedReservationSeats + ", totalSeats=" + totalSeats + ", bookedTatkalSeats=" + bookedTatkalSeats
				+ ", availableSeats=" + availableSeats + "]";
	}

	private int id;
	private String trainName, fromStation, toStation, time, trainNo;
	private int bookedReservationSeats, totalSeats, bookedTatkalSeats, availableSeats;

	Train(){
		
	}
	
	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Train(int id, String trainName, String fromStation, String toStation, String time, String trainNo,
			int totalSeats) {
		this.id = id;
		this.trainName = trainName;
		this.fromStation = fromStation;
		this.toStation = toStation;
		this.time = time;
		this.trainNo = trainNo;
		this.totalSeats = totalSeats;
	}

	public int getBookedReservationSeats() {
		return bookedReservationSeats;
	}

	public void setBookedReservationSeats(int reservationSeats) {
		this.bookedReservationSeats = reservationSeats;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getBookedTatkalSeats() {
		return bookedTatkalSeats;
	}

	public void setBookedTatkalSeats(int tatkalSeats) {
		this.bookedTatkalSeats = tatkalSeats;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(String trainNo) {
		this.trainNo = trainNo;
	}

}