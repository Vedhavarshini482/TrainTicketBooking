package com.ticketbooking.userview;

import java.util.List;

public interface UserViewCallBack {

	void showTrains(List<List<String>> trains);

	void notAvailable(String string);

	void showSeats(String string,int seat);

	void available(String string);

	void ticketsNotAvailable(int ticketCount,String string);

	void ticketStatus(String string,String status);

	void tatkalClosed(String string);

	void payAmount(int amount, String string);

}