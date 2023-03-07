package com.ticketbooking.adminview;

import java.util.ArrayList;
import java.util.List;

public interface AdminViewCallBack {

	void printBookings(List<ArrayList<String>> userList);

	void printTrainDetails(List<ArrayList<String>> trainList);

}