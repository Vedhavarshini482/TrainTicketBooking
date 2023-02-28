package com.ticketbooking.login;

public interface LoginModelCallBack {

	void validAdmin(String userName, String password);

	void validLogin(String name, String password);

	void createAccount(String name, String password, String address, long mobileNumber, String mailID);

}