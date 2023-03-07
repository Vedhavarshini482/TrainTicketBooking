package com.ticketbooking.login;

import com.ticketbooking.dto.User;
import com.ticketbooking.repository.Repository;
import com.ticketbooking.dto.Admin;

public class LoginModel implements LoginModelCallBack {

	private LoginModelControllerCallBack controller;

	LoginModel(LoginModelControllerCallBack controller) {
		this.controller = controller;
	}

	interface LoginModelControllerCallBack {

		void validAdmin(String string);

		void invalidAdmin(String string);

		void validUser(String string);

		void invalidUser(String string);

		void accountCreated(String string);

	}

	@Override
	public void validAdmin(String userName, String password) {
		Admin admin = Repository.getInstance().validAdmin(userName, password);
		if (admin != null)
			controller.validAdmin("\t\tHello " + admin.getUserName());
		else
			controller.invalidAdmin("\t\tInvalid login attempt");
	}

	@Override
	public void validLogin(String name, String password) {
		User user = Repository.getInstance().validUser(name, password);
		if (user != null)
			controller.validUser("\t\tHello " + user.getName());
		else
			controller.invalidUser("\t\tInvalid Login attempt");
	}

	@Override
	public void createAccount(String name, String password, String address, long mobileNumber, String mailID) {
		Repository.getInstance().createAccount(name, password, address, mobileNumber, mailID);
		controller.accountCreated("Your account created successfully");
	}

}