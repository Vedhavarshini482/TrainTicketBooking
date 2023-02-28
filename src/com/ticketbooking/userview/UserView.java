package com.ticketbooking.userview;

import java.util.List;
import java.util.Scanner;

import com.ticketbooking.login.LoginView;

public class UserView implements UserViewCallBack {

	private UserControllerCallBack controller;
	private Scanner scanner = new Scanner(System.in);
	private String name, id, from, to;
	private int seats;
	private String statement,quota,trainClass;

	public UserView() {
		controller = new UserController(this);
	}

	public void userView(String name) {
		this.name=name;
		userView();
	}
	
	private void userView() {
		System.out.println("Enter yout choice\n");
		System.out.println("1.To Choose From and To\n2.Back\n3.Exit");
		String choice = scanner.nextLine();
		switch (choice) {
		case "1":
			fromAndTo();
			break;
		case "2":
			System.out.println("\t\t\t\t\t    Your account logged out");
			new LoginView().login();
		case "3":
			System.out.println("\t\t\t\t\t    Your account logged out");
			exit();
		default:
			System.out.println("\t\t\t\t\t    Enter a valid number");
			userView();
		}
	}

	private void fromAndTo() {
		System.out.println("From : ");
		from = scanner.nextLine();
		System.out.println("To : ");
		to = scanner.nextLine();
		controller.checkTrainAvailability(from, to);
		bookingDetails();
	}

	private void exit() {
		System.out.println("\t\t\t\t\tTHANKYOU FOR VISITING OUR PAGE :)");
		System.exit(0);
	}

	@Override
	public void showTrains(List<List<String>> trains) {
		for (int i = 0; i < trains.size(); i++) {
			System.out.println("Train ID     : " + trains.get(i).get(0));
			System.out.println("Train Name   : " + trains.get(i).get(1));
			System.out.println("Train Number : " + trains.get(i).get(2));
			System.out.println(
					"From station : " + trains.get(i).get(3) + "\t\tTo station      : " + trains.get(i).get(4));
			System.out.println("Train timing : " + trains.get(i).get(5));
			System.out.println("Total Seats  : " + trains.get(i).get(6) + "\n\n");
		}
		System.out.println("If you choose your travelling train kindly enter the train ID");
		id = scanner.nextLine();
		if (!(trains.get(0).get(0).equals(id) || trains.get(1).get(0).equals(id))) {
			System.out.println("You entered an invalid ID");
			showTrains(trains);
		}
	}

	@Override
	public void notAvailable(String string) {
		System.out.println(string);
		userView();
	}

	public void bookingDetails() {
		System.out.println("Enter your choice\n");
		System.out.println("1.Select Class\n2.Back\n3.Exit");
		String choice = scanner.nextLine();
		switch (choice) {
		case "1":
			selectClass();
			break;
		case "2":
			fromAndTo();
			break;
		case "3":
			System.out.println("\t\t\t\t\t    Your account logged out");
			exit();
		default:
			System.out.println("Enter a valid number");
			bookingDetails();
		}
	}

	private void selectClass() {
		System.out.println("Enter your choice\n");
		System.out.println(
				"1.AC First Class(1A)\n2.AC 2Tier(2A)\n3.AC 3Tier(3A)\n4.Sleeper(SL)\n5.Second Sitting(2S)\n6.Back\n7.Exit");
		 trainClass = scanner.nextLine();
		switch (trainClass) {
		case "1":
			firstAC("AC First Class(1A)");
			break;
		case "2":
			secondAC("AC 2Tier(2A)");
			break;
		case "3":
			thirdAC("AC 3Tier(3A)");
			break;
		case "4":
			sleeper("Sleeper(SL)");
			break;
		case "5":
			secondSitting("Second Sitting(2S)");
			break;
		case "6":
			System.out.println("\t\t\t\t\t    Your account logged out");
			bookingDetails();
			break;
		case "7":
			System.out.println("\t\t\t\t\t    Your account logged out");
			exit();
		default:
			System.out.println("\t\t\t\t\t    Enter a valid number");
			selectClass();

		}
	}

	private String selectQuota() {
		System.out.println("Enter your choice\n");
		System.out.println("1.Reservation\n2.Tatkal\n3.Back\n4.Exit");
		String choice = scanner.nextLine();
		switch (choice) {
		case "1":
			return "Reservation";
		case "2":
			return "Tatkal";
		case "3":
			selectClass();
			return "";
		case "4":
			System.out.println("\t\t\t\t\t    Your account logged out");
			exit();
			return "";
		default:
			System.out.println("Enter a valid number");
			bookingDetails();
			return "";
		}
	}

	private void secondSitting(String seating) {
		quota = selectQuota();
		controller.showSecondSitting(quota);
		bookTicket(quota, seating);
	}

	private void thirdAC(String seating) {
		 quota = selectQuota();
		controller.showThirdAC(quota);
		bookTicket(quota, seating);
	}

	private void sleeper(String seating) {
		 quota = selectQuota();
		controller.showSlepper(quota);
		bookTicket(quota, seating);
	}

	private void secondAC(String seating) {
		 quota = selectQuota();
		controller.showSecondAC(quota);
		bookTicket(quota, seating);
	}

	private void firstAC(String seating) {
		String quota = selectQuota();
		controller.showFirstAC(quota);
		bookTicket(quota, seating);
	}

	@Override
	public void showSeats(String string, int seat) {
		seats = seat;
		System.out.println(string);
	}

	private void bookTicket(String quota, String seating) {
		int ticketCount;
		if (quota.equals("Tatkal")) {
			controller.checkOpened();
			System.out.println("Enter how many tickets you want in " + seating);
			ticketCount = scanner.nextInt();
			controller.ticketAvailableTatkal(ticketCount, seating);
		} else {
			System.out.println("Enter how many tickets you want in " + seating);
			ticketCount = scanner.nextInt();
			controller.ticketAvailable(ticketCount, seating);
		}
		payment(quota, ticketCount, seating);
	}

	private void payment(String quota, int ticketCount, String seating) {
		if (quota.equals("Tatkal")) {
			controller.paymentTatkal(ticketCount, seating);
		} else {
			controller.paymentReservation(ticketCount, seating);
		}
	}

	@Override
	public void available(String string) {
		System.out.println(string);
	}

	@Override
	public void ticketsNotAvailable(int ticketCount, String string) {
		System.out.println(ticketCount + string + " " + (seats - ticketCount) + " tickets only available");
		selectQuota();
	}

	@Override
	public void ticketStatus(String string, String status) {
		System.out.println(string);
		statement = status;
	}

	@Override
	public void tatkalClosed(String string) {
		System.out.println(string);
		selectQuota();
	}

	@Override
	public void payAmount(int amount, String string) {
		System.out.println("Type Enter to ticket confirmation or otherwise enter 0");
		String confirm = scanner.next();
		if (!confirm.equals("0")) {
			statement = "Confirmed";
			System.out.println(string);
			System.out.println("Press enter to pay");
			scanner.next();
			System.out.println("Now pay");
			int money = scanner.nextInt();
			if (money == amount) {
				System.out.println("Paid successfully");
				controller.confirmTicket(name,id, from, to, seats, statement, amount,quota,trainClass);
			} else {
				System.out.println("Please pay the correct amount");
				payAmount(amount, string);
			}
		} else
			selectQuota();
	}

}