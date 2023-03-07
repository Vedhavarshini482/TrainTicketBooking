package com.ticketbooking.adminview;

import java.util.ArrayList;
import java.util.List;

import com.ticketbooking.repository.Repository;

public class AdminModel implements AdminModelCallBack {

	private AdminModelControllerCallBack controller;

	AdminModel(AdminModelControllerCallBack controller) {
		this.controller = controller;
	}

	interface AdminModelControllerCallBack {

		void printBookings(List<ArrayList<String>> userList);

		void printTrainDetails(List<ArrayList<String>> trainList);

	}

	@Override
	public void bookings() {
		List<ArrayList<String>> userList = Repository.getInstance().bookings();
		controller.printBookings(userList);
	}

	@Override
	public void trainDetails() {
		List<ArrayList<String>> trainList=Repository.getInstance().trainDetails();
		controller.printTrainDetails(trainList);
	}

}