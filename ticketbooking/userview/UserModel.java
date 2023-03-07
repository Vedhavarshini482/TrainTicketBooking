package com.ticketbooking.userview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ticketbooking.repository.Repository;

public class UserModel implements UserModelCallBack {

	private UserModelControllerCallBack controller;
	private HashMap<String, Integer> ticketCount = new HashMap<>();
	private int seats, amount;
	private String statement;
	private List<String> seatType = new ArrayList<>();

	UserModel(UserModelControllerCallBack controller) {
		this.controller = controller;
	}

	interface UserModelControllerCallBack {

		void showTrains(List<List<String>> trains);

		void notAvailable(String string);

		void tatkalAvailable();

		void tatkalNotAvailable(String string);

		void seatNotAvailable(String string);

		void seatsAvailable(String string);

		void seatNotAvailableTatkal(String string);

		void payAmount(String string);
		
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
	public void checkOpened() {
		if (Repository.getInstance().checkOpened())
			controller.tatkalAvailable();
		else
			controller.tatkalNotAvailable("Tatkal ticket booking not opened yet..");
	}

	@Override
	public void checkSeatTatkal(int firstAC, int tier2A, int tier3A, int sleeper, int secondSitting) {
		statement = "Waiting List";
		if (!Repository.getInstance().ticketAvailableTatkal(firstAC, "AC First Class(1A)") && firstAC != 0)
			controller.seatNotAvailableTatkal("\t\t\t\t" + firstAC + " seats not available in AC First Class(1A)");
		if (!Repository.getInstance().ticketAvailableTatkal(tier2A, "AC 2Tier(2A)") && tier2A != 0)
			controller.seatNotAvailableTatkal("\t\t\t\t" + tier2A + " seats not available in AC 2Tier(2A)");
		if (!Repository.getInstance().ticketAvailableTatkal(tier3A, "AC 3Tier(3A)") && tier2A != 0)
			controller.seatNotAvailableTatkal("\t\t\t\t" + tier3A + " seats not available in AC 3Tier(3A)");
		if (!Repository.getInstance().ticketAvailableTatkal(sleeper, "Sleeper(SL)") && sleeper != 0)
			controller.seatNotAvailableTatkal("\t\t\t\t" + sleeper + " seats not available in Sleeper(SL)");
		if (!Repository.getInstance().ticketAvailableTatkal(secondSitting, "Second Sitting(2S)") && secondSitting != 0)
			controller.seatNotAvailableTatkal("\t\t\t\t" + tier2A + " seats not available in Second Sitting(2S)");
		else {
			statement = "Confirmed";
			addTicketCount(firstAC, tier2A, tier3A, sleeper, secondSitting);
			controller.seatsAvailable("\t\t\t\t\t\tSeats are available");
			
		}
	}

	private void addTicketCount(int firstAC, int tier2A, int tier3A, int sleeper, int secondSitting) {
		seatType.add("AC First Class(1A) - " + firstAC + " tickets");
		seatType.add("AC 2Tier(2A) - " + tier2A + " tickets");
		seatType.add("AC 3Tier(3A) - " + tier3A + " tickets");
		seatType.add("Sleeper(SL) - " + sleeper + " tickets");
		seatType.add("Second Sitting(2S) - " + secondSitting + " tickets");

		ticketCount.put("AC First Class(1A)", firstAC);
		ticketCount.put("AC 2Tier(2A)", tier2A);
		ticketCount.put("AC 3Tier(3A)", tier3A);
		ticketCount.put("Sleeper(SL)", sleeper);
		ticketCount.put("Second Sitting(2S)", secondSitting);
		
	}

	@Override
	public void checkSeatReservation(int firstAC, int tier2A, int tier3A, int sleeper, int secondSitting) {
		if (!Repository.getInstance().ticketAvailable(firstAC, "AC First Class(1A)") && firstAC != 0)
			controller.seatNotAvailable("\t\t\t\t" + firstAC + " seats not available in AC First Class(1A)");
		if (!Repository.getInstance().ticketAvailable(tier2A, "AC 2Tier(2A)") && tier2A != 0)
			controller.seatNotAvailable("\t\t\t\t" + tier2A + " seats not available in AC 2Tier(2A)");
		if (!Repository.getInstance().ticketAvailable(tier3A, "AC 3Tier(3A)") && tier2A != 0)
			controller.seatNotAvailable("\t\t\t\t" + tier3A + " seats not available in AC 3Tier(3A)");
		if (!Repository.getInstance().ticketAvailable(sleeper, "Sleeper(SL)") && sleeper != 0)
			controller.seatNotAvailable("\t\t\t\t" + sleeper + " seats not available in Sleeper(SL)");
		if (!Repository.getInstance().ticketAvailable(secondSitting, "Second Sitting(2S)") && secondSitting != 0)
			controller.seatNotAvailable("\t\t\t\t" + tier2A + " seats not available in Second Sitting(2S)");
		else {
			statement = "Confirmed";
			addTicketCount(firstAC, tier2A, tier3A, sleeper, secondSitting);
			controller.seatsAvailable("\t\t\t\t\t\tSeats are available");
		}
	}

	@Override
	public void paymentTakkal() {

		for (Map.Entry<String, Integer> entry : ticketCount.entrySet()) {
			seats += entry.getValue();
			amount += Repository.getInstance().paymentTatkal(entry.getKey(), entry.getValue());
		}
		controller.payAmount("\t\t\t\tYou have to pay " + amount);
	}

	@Override
	public void paymentReservation() {

		statement = "Confirmed";
		for (Map.Entry<String, Integer> entry : ticketCount.entrySet()) {
			seats += entry.getValue();
			System.out.println(entry.getKey() + " " + entry.getValue());
			amount += Repository.getInstance().paymentReservation(entry.getKey(), entry.getValue());
			System.out.println(amount);
		}
		controller.payAmount("\t\t\t\tYou have to pay " + amount);
	}

	@Override
	public void confirm(String name, String trainId, String from, String to, String quota, String userDate) {
	 Repository.getInstance().confirmTicket(name, trainId, from, to, seats, statement, amount, quota,
				trainId, seatType, userDate);
	}
}