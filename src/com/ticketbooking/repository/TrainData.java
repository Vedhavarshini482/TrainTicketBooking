package com.ticketbooking.repository;

import java.util.List;

import com.ticketbooking.dto.Train;

public class TrainData {

	List<Train> train;

	TrainData(){
		
	}
	
	public List<Train> getTrain() {
		return train;
	}

	public void setTrain(List<Train> train) {
		this.train = train;
	}

	@Override
	public String toString() {
		return "TrainData [train=" + train + "]";
	}
	
}