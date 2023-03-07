package com.ticketbooking.adminview;

import java.util.ArrayList;
import java.util.List;

import com.ticketbooking.adminview.AdminModel.AdminModelControllerCallBack;

public class AdminController implements AdminControllerCallBack,AdminModelControllerCallBack{

	private AdminModelCallBack model;
	private AdminViewCallBack view;
	
	AdminController(AdminView view){
		this.view=view;
		model=new AdminModel(this);
	}

	@Override
	public void bookings() {
		model.bookings();
	}

	@Override
	public void printBookings(List<ArrayList<String>> userList) {
		view.printBookings(userList);
	}

	@Override
	public void trainDetails() {
		model.trainDetails();
	}

	@Override
	public void printTrainDetails(List<ArrayList<String>> trainList) {
		view.printTrainDetails(trainList);
	}
	
}