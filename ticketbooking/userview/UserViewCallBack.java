package com.ticketbooking.userview;

import java.util.List;

public interface UserViewCallBack {

	void showTrains(List<List<String>> trains);

	void notAvailable(String string);

	void tatkalAvailable();

	void tatkalNotAvailable(String string);

	void seatsAvailable(String string);

	void seatNotAvailable(String string);

	void seatNotAvailableTatkal(String string);

	void payAmount(String string);
	
}