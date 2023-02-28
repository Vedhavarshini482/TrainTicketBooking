package com.ticketbooking.login;

public interface LoginViewCallBack {

	public void invalidUser(String string);

	public void validUser(String string);

	public void invalidAdmin(String string);

	public void validAdmin(String string);

	public void accountCreated(String string);

}