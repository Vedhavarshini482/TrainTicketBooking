package com.ticketbooking.login;

import com.ticketbooking.login.LoginModel.LoginModelControllerCallBack;

public class LoginController implements LoginControllerCallBack, LoginModelControllerCallBack {

	LoginViewCallBack view;
	LoginModelCallBack model;

	LoginController(LoginView view) {
		this.view = view;
		model = new LoginModel(this);
	}

	@Override
	public void validAdmin(String userName, String password) {
		model.validAdmin(userName, password);
	}

	@Override
	public void validLogin(String name, String password) {
		model.validLogin(name, password);
	}

	@Override
	public void validAdmin(String string) {
		view.validAdmin(string);
	}

	@Override
	public void invalidAdmin(String string) {
		view.invalidAdmin(string);
	}

	@Override
	public void validUser(String string) {
		view.validUser(string);
	}

	@Override
	public void invalidUser(String string) {
		view.invalidUser(string);
	}

	@Override
	public void createAccount(String name, String password, String address, long mobileNumber, String mailID) {
		model.createAccount(name, password, address, mobileNumber, mailID);
	}

	@Override
	public void accountCreated(String string) {
		view.accountCreated(string);
	}

}