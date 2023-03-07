package com.ticketbooking.userview;

import java.util.List;

import com.ticketbooking.userview.UserModel.UserModelControllerCallBack;

public class UserController implements UserModelControllerCallBack, UserControllerCallBack {

	private UserModelCallBack model;
	private UserViewCallBack view;

	UserController(UserView view) {
		this.view = view;
		model = new UserModel(this);
	}

	@Override
	public void checkTrainAvailability(String from, String to) {
		model.checkTrainAvailability(from,to);
	}

	@Override
	public void showTrains(List<List<String>> trains) {
		view.showTrains(trains);
	}

	@Override
	public void notAvailable(String string) {
		view.notAvailable(string);
	}

	@Override
	public void checkOpened() {
		model.checkOpened();
	}

	@Override
	public void tatkalAvailable() {
		view.tatkalAvailable();
	}

	@Override
	public void tatkalNotAvailable(String string) {
		view.tatkalNotAvailable(string);
	}

	@Override
	public void checkSeatTatkal(int firstAC, int tier2A, int tier3A, int sleeper, int secondSitting) {
		model.checkSeatTatkal(firstAC,tier2A,tier3A,sleeper,secondSitting);
	}

	@Override
	public void checkSeatReservation(int firstAC, int tier2A, int tier3A, int sleeper, int secondSitting) {
		model.checkSeatReservation(firstAC,tier2A,tier3A,sleeper,secondSitting);
	}

	@Override
	public void seatNotAvailable(String string) {
		view.seatNotAvailable(string);
	}

	@Override
	public void seatsAvailable(String string) {
		view.seatsAvailable(string);
	}

	@Override
	public void seatNotAvailableTatkal(String string) {
		view.seatNotAvailableTatkal(string);
	}

	@Override
	public void paymentTakkal() {
		model.paymentTakkal();
	}

	@Override
	public void paymentReservation() {
		model.paymentReservation();
	}

	@Override
	public void payAmount(String string) {
		view.payAmount(string);
	}

	@Override
	public void confirm(String name, String trainId, String from, String to, String quota, String userDate) {
		model.confirm(name,trainId,from,to,quota,userDate);	
	}

}