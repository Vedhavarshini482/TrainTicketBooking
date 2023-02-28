package com.ticketbooking.userview;

public interface UserControllerCallBack {

	void checkTrainAvailability(String from, String to);

	void showFirstAC(String quota);

	void showSecondAC(String quota);

	void showSlepper(String quota);

	void showThirdAC(String quota);

	void showSecondSitting(String quota);

	void ticketAvailable(int ticketCount, String seating);

	void ticketAvailableTatkal(int ticketCount, String seating);

	void checkOpened();

	void paymentTatkal(int ticketCount, String seating);

	void paymentReservation(int ticketCount, String seating);

	void confirmTicket(String name,String id, String from, String to, int seats, String statement,int amount,String quota,String trainClass);

}