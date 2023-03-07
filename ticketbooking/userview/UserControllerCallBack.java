package com.ticketbooking.userview;

public interface UserControllerCallBack {

	void checkTrainAvailability(String from, String to);

	void checkOpened();

	void checkSeatTatkal(int firstAC, int tier2a, int tier3a, int sleeper, int secondSitting);

	void checkSeatReservation(int firstAC, int tier2a, int tier3a, int sleeper, int secondSitting);

	void paymentTakkal();

	void paymentReservation();

	void confirm(String name, String trainId, String from, String to, String quota, String userDate);

}