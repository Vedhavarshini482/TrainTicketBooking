package com.ticketbooking.userview;

import java.util.ArrayList;
import java.util.List;

import com.ticketbooking.repository.Repository;

public class UserModel implements UserModelCallBack {

	private UserModelControllerCallBack controller;
	private List<String> seatType = new ArrayList<>();

	UserModel(UserModelControllerCallBack controller) {
		this.controller = controller;
	}

	interface UserModelControllerCallBack {

		void showTrains(List<List<String>> trains);

		void notAvailable(String string);

		void showSeats(String string, int seats);

		void available(String string);

		void ticketsNotAvailable(int ticketCount, String string);

		void ticketStatus(String string, String status);

		void tatkalClosed(String string);

		void payAmount(int amount, String string);

	}

	@Override
	public void checkTrainAvailability(String from, String to) {
		List<List<String>> trains = new ArrayList<>();
		trains = Repository.getInstance().checkTrainAvailability(from, to);
		if (trains.size() != 0)
			controller.showTrains(trains);
		else
			controller.notAvailable("\t\t\t\tYour destination is not available");
	}

	@Override
	public void showFirstAc(String quota) {
		int seats = Repository.getInstance().showFirstAc(quota);
		controller.showSeats(("\t\t" + seats + "  seats available in First AC " + quota + " quota"), seats);
	}

	@Override
	public void showSecondAC(String quota) {
		int seats = Repository.getInstance().showSecondAc(quota);
		controller.showSeats(("\t\t" + seats + "  seats available in Second AC " + quota + " quota"), seats);
	}

	@Override
	public void showSleeper(String quota) {
		int seats = Repository.getInstance().showSleeper(quota);
		controller.showSeats(("\t\t" + seats + "  seats available in Sleeper " + quota + " quota"), seats);
	}

	@Override
	public void showThirdAC(String quota) {
		int seats = Repository.getInstance().showThirdAc(quota);
		controller.showSeats(("\t\t" + seats + "  seats available in Third AC " + quota + " quota"), seats);
	}

	@Override
	public void showSecondSitting(String quota) {
		int seats = Repository.getInstance().showSecondSitting(quota);
		controller.showSeats(("\t\t" + seats + "  seats available in Second Sitting " + quota + " quota"), seats);
	}

	@Override
	public void ticketAvailable(int ticketCount, String seating) {
		if (Repository.getInstance().ticketAvailable(ticketCount, seating))
			controller.available(ticketCount + " available in " + seating);
		else
			controller.ticketsNotAvailable((ticketCount), " not available in " + seating);

		seatType.add(seating + " - " + ticketCount);
	}

	@Override
	public void ticketAvailableTatkal(int ticketCount, String seating) {
		if (Repository.getInstance().ticketAvailableTatkal(ticketCount, seating))
			controller.ticketStatus("\t\tYour ticket Confirmed", "Confirmed");
		else
			controller.ticketStatus("\t\tYou are in waiting list", "Waiting list");
	}

	@Override
	public void checkOpened() {
		if (!Repository.getInstance().checkOpened())
			controller.tatkalClosed("\t\t  Tatkal ticket booking not opened yet");
	}

	@Override
	public void paymentTatkal(int ticketCount, String seating) {
		int amount = Repository.getInstance().paymentTatkal(ticketCount, seating);
		controller.payAmount(amount, "You have to pay " + amount);
	}

	@Override
	public void paymentReservation(int ticketCount, String seating) {
		int amount = Repository.getInstance().paymentReservation(ticketCount, seating);
		controller.payAmount(amount, "You have to pay " + amount);
	}

	@Override
	public void confirmTicket(String name, String id, String from, String to, int seats, String statement, int amount,
			String quota, String trainClass) {
		Repository.getInstance().confirmTicket(name, id, from, to, seats, statement, amount, quota, trainClass,
				seatType);
	}
}