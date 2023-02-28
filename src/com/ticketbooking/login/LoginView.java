package com.ticketbooking.login;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ticketbooking.adminview.AdminView;
import com.ticketbooking.userview.UserView;

public class LoginView implements LoginViewCallBack {

	private LoginControllerCallBack controller;
	private Scanner scanner = new Scanner(System.in);
	private String name;

	public LoginView() {
		controller = new LoginController(this);
	}

	public static void main(String[] args) {
		new LoginView().welcome();
	}

	public void welcome() {
		System.out.println("\t\t-->WELCOME TO ONLINE TICKET BOOKING<--");
		login();
	}

	public void login() {
		System.out.println("1.Admin Login\n2.User Login\n3.SignUp\n4.Exit");
		String choice = scanner.nextLine();
		switch (choice) {
		case "1":
			adminLogin();
			break;
		case "2":
			userLogin();
			break;
		case "3":
			signup();
			break;
		case "4":
			exit();
		default:
			System.out.println("Enter a valid number");
			login();
		}
	}

	public void signup() {
		System.out.println("Enter your full name(ex:Varsha R)");
		name = scanner.nextLine().toUpperCase();
		System.out.println("Enter your address");
		String address = scanner.nextLine();
		long mobileNumber = mobileNumber();
		System.out.println("Enter your mail ID");
		String mailID = scanner.nextLine();
		System.out.println("Enter your password");
		String password = scanner.nextLine();
		controller.createAccount(name, password, address, mobileNumber, mailID);
	}

	public long mobileNumber() {
		System.out.println("Enter your mobile number");
		String mobileNumber = scanner.nextLine();
		String MOBILE_NUMBER_PATTERN = "^(\\+\\d{1,3}[- ]?)?\\d{10}$";
		Pattern pattern = Pattern.compile(MOBILE_NUMBER_PATTERN);
		Matcher matcher = pattern.matcher(mobileNumber);
		if (!matcher.matches()) {
			System.out.println("Enter a valid mobile number");
			mobileNumber();
		}
		return Long.parseLong(mobileNumber);
	}

	public void userLogin() {
		System.out.println("Enter your user name");
		name = scanner.nextLine();
		System.out.println("Enter your password");
		String password = scanner.nextLine();
		controller.validLogin(name, password);
	}

	public void adminLogin() {
		System.out.println("Enter Your user name");
		String userName = scanner.nextLine();
		System.out.println("Enter your password");
		String password = scanner.nextLine();
		controller.validAdmin(userName, password);
	}

	public void exit() {
		System.out.println("\t\t\t\t\tTHANKYOU FOR VISITING OUR BANKING APPLICATION:)");
		System.exit(0);
	}

	@Override
	public void accountCreated(String string) {
		System.out.println(string);
		new UserView().userView(name);
	}

	@Override
	public void validAdmin(String string) {
		System.out.println(string);
		new AdminView().adminView();
	}

	@Override
	public void invalidAdmin(String string) {
		System.out.println(string);
		login();
	}

	@Override
	public void validUser(String string) {
		System.out.println(string);
		new UserView().userView(name);
	}

	@Override
	public void invalidUser(String string) {
		System.out.println(string);
		login();
	}

}