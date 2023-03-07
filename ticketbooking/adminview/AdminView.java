package com.ticketbooking.adminview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ticketbooking.login.LoginView;

public class AdminView implements AdminViewCallBack {

	private AdminControllerCallBack controller;
	private Scanner scanner = new Scanner(System.in);

	public AdminView() {
		controller = new AdminController(this);
	}

	public void adminView() {
		System.out.println("Enter your choice\n");
		System.out.println("1.Customer Details\n2.Display Train Details\n3.Back\n4.Exit");
		String choice = scanner.nextLine();
		switch (choice) {
		case "1":
			displayBookings();
			break;
		case "2":
			controller.trainDetails();
		case "3":
			System.out.println("Your account logged out");
			new LoginView().login();
			break;
		case "4":
			exit();
		default:
			System.out.println("You entered an invalid number");
			adminView();
		}
	}

	private void displayBookings() {
		controller.bookings();
	}

	private void exit() {
		System.out.println("\t\t\t\t\tTHANKYOU FOR VISITING OUR PAGE :)");
		System.exit(0);
	}

	@Override
	public void printBookings(List<ArrayList<String>> userList) {
		for (int i = 0; i < userList.size(); i++) {
			System.out.println("User ID      : " + userList.get(i).get(0));
			System.out.println("User name    : " + userList.get(i).get(1));
			System.out.println("Mail ID      : " + userList.get(i).get(2));
			System.out.println("Address      : " + userList.get(i).get(3));
			System.out.println("Phone number : " + userList.get(i).get(4));
		}
		adminView();
	}

	@Override
	public void printTrainDetails(List<ArrayList<String>> trainList) {
		for (int i = 0; i < trainList.size(); i++) {
			System.out.println("Train ID       : " + trainList.get(i).get(0));
			System.out.println("Train Name     : " + trainList.get(i).get(1));
			System.out.println("Train Number   : " + trainList.get(i).get(2));
			System.out.println("From station   : " + trainList.get(i).get(3));
			System.out.println("To sttation    : " + trainList.get(i).get(4));
			System.out.println("Train Time     : " + trainList.get(i).get(5));
			System.out.println("Avilable seats : " + trainList.get(i).get(6));
			System.out.println("Total seats    : " + trainList.get(i).get(7));
			System.out.println("Reserved seats : " + trainList.get(i).get(8));
			System.out.println("Tatkal seats   : " + trainList.get(i).get(9));

		}
		adminView();
	}

}