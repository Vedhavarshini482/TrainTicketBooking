package com.ticketbooking.repository;

import java.util.List;
import java.util.Queue;

import com.ticketbooking.dto.Train;

public class TrainData {

	List<Train> train;
	Queue<String> waitingList;

	public Queue<String> getWaitingList() {
		return waitingList;
	}

	public void setWaitingList(Queue<String> waitingList) {
		this.waitingList = waitingList;
	}

	TrainData() {

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