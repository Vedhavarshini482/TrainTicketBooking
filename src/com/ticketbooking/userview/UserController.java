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
	public void showFirstAC(String quota) {
		model.showFirstAc(quota);
	}

	@Override
	public void showSeats(String string,int seat) {
		view.showSeats(string,seat);
	}

	@Override
	public void showSecondAC(String quota) {
		model.showSecondAC(quota);
	}

	@Override
	public void showSlepper(String quota) {
		model.showSleeper(quota);
	}

	@Override
	public void showThirdAC(String quota) {
		model.showThirdAC(quota);
	}

	@Override
	public void showSecondSitting( String quota) {
		model.showSecondSitting(quota);
	}

	@Override
	public void ticketAvailable(int ticketCount, String seating) {
		model.ticketAvailable(ticketCount,seating);
	}

	@Override
	public void available(String string) {
		view.available(string);
	}

	@Override
	public void ticketsNotAvailable(int ticketCount,String string) {
		view.ticketsNotAvailable(ticketCount,string);
	}

	@Override
	public void ticketAvailableTatkal(int ticketCount, String seating) {
		model.ticketAvailableTatkal(ticketCount,seating);
	}

	@Override
	public void ticketStatus(String string,String status) {
		view.ticketStatus(string,status);
	}

	@Override
	public void checkOpened() {
		model.checkOpened();
	}

	@Override
	public void tatkalClosed(String string) {
		view.tatkalClosed(string);
		
	}

	@Override
	public void paymentTatkal(int ticketCount, String seating) {
		model.paymentTatkal(ticketCount,seating);
	}

	@Override
	public void paymentReservation(int ticketCount, String seating) {
		model.paymentReservation(ticketCount,seating);
	}

	@Override
	public void payAmount(int amount, String string) {
		view.payAmount(amount,string);
	}

	@Override
	public void confirmTicket(String name,String id, String from, String to, int seats, String statement,int amount,String quota,String trainClass) {
		model.confirmTicket(name,id,from,to,seats,statement,amount,quota,trainClass);
	}

}