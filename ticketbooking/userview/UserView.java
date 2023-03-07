package com.ticketbooking.userview;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.ticketbooking.login.LoginView;

public class UserView implements UserViewCallBack {

	private UserControllerCallBack controller;
	private Scanner scanner = new Scanner(System.in);
	private String name, trainId, from, to;
	private String quota, userDate;
	private int firstAC, tier2A, tier3A, sleeper, secondSitting;

	public UserView() {
		controller = new UserController(this);
	}

	public void userView(String name) {
		this.name = name;
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
		System.out.println("Enter your depature and destination");
		System.out.println("From : ");
		from = scanner.nextLine();
		System.out.println("To : ");
		to = scanner.nextLine();
		controller.checkTrainAvailability(from, to);
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
		System.out.println("If you choosen your travelling train kindly enter the train ID");
		trainId = scanner.nextLine();
		selectQuota();
		if (!(trains.get(0).get(0).equals(trainId) || trains.get(1).get(0).equals(trainId))) {
			System.out.println("You entered an invalid ID");
			showTrains(trains);
		}
	}

	public void dateAvailable() {
		System.out.println("Enter the Date (Ex: 28-02-2023)");
		userDate = scanner.nextLine();
		Date now = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String date = dateFormat.format(now);
		if (quota.equals("Reservation")) {
			if (!((Integer.parseInt(userDate.substring(0, 2)) > Integer.parseInt(date.substring(0, 2))
					&& Integer.parseInt(userDate.substring(3, 5)) >= Integer.parseInt(date.substring(3, 5)))
					|| (Integer.parseInt(userDate.substring(0, 2)) < Integer.parseInt(date.substring(0, 2))
							&& Integer.parseInt(userDate.substring(3, 5)) > Integer.parseInt(date.substring(3, 5)))
							&& userDate.substring(6, 10).equals(date.substring(6, 10)))) {
				System.out.println("\t\t\t\tThere is no ticket available :(");
				selectQuota();
			} else {
				chooseSeating();
			}
		} else {
			if ((Integer.parseInt(userDate.substring(0, 2)) == Integer.parseInt(date.substring(0, 2)) + 1)
					&& (Integer.parseInt(userDate.substring(0, 2)) <= 31)) {
				controller.checkOpened();
				chooseSeating();
			} else {
				System.out.println("\t\t\t\tThere is no ticket available :(");
				selectQuota();
			}
		}
	}

	@Override
	public void notAvailable(String string) {
		System.out.println(string);
		userView();
	}

	private void selectQuota() {
		System.out.println("Enter your choice\n");
		System.out.println("1.Reservation\n2.Tatkal\n3.Back\n4.Exit");
		String choice = scanner.nextLine();
		switch (choice) {
		case "1":
			quota = "Reservation";
			dateAvailable();
			break;
		case "2":
			quota = "Tatkal";
			dateAvailable();
			break;
		case "3":
			fromAndTo();
			break;
		case "4":
			System.out.println("\t\t\t\t\t    Your account logged out");
			exit();
		default:
			System.out.println("\t\t\t\tEnter a valid number");
			selectQuota();
		}
	}

	public void chooseSeating() {
		System.out.println("We have these type of seatings..Choose seats for your convenience\n");
		System.out.println("AC First Class(1A)\nAC 2Tier(2A)\nAC 3Tier(3A)\nSleeper(SL)\nSecond Sitting(2S)");
		System.out.println("\nEnter how many tickets you want?\n");
		System.out.print("AC First Class - ");
		firstAC = scanner.nextInt();
		System.out.println();
		System.out.print("AC 2Tier(2A) - ");
		tier2A = scanner.nextInt();
		System.out.println();
		System.out.print("AC 3Tier(3A) - ");
		tier3A = scanner.nextInt();
		System.out.println();
		System.out.print("Sleeper(SL) - ");
		sleeper = scanner.nextInt();
		System.out.println();
		System.out.print("Second Sitting(2S) - ");
		secondSitting = scanner.nextInt();
		System.out.println();
		checkSeatAvailability();
	}

	public void checkSeatAvailability() {
		if (quota.equals("Tatkal"))
			controller.checkSeatTatkal(firstAC, tier2A, tier3A, sleeper, secondSitting);
		else
			controller.checkSeatReservation(firstAC, tier2A, tier3A, sleeper, secondSitting);
	}

	@Override
	public void tatkalAvailable() {
		chooseSeating();
	}

	@Override
	public void tatkalNotAvailable(String string) {
		System.out.println(string);
		selectQuota();
	}

	@Override
	public void seatsAvailable(String string) {
		System.out.println(string);
		System.out.println("1.Continue\n2.Back\n3.Exit");
		int number = scanner.nextInt();
		switch (number) {
		case 1:
			controller.paymentReservation();
			break;
		case 2:
			selectQuota();
			break;
		case 3:
			exit();
		default:
			System.out.println("\t\t\t\tYou entered an invalid number");
			exit();
		}
	}

	@Override
	public void seatNotAvailable(String string) {
		System.out.println(string);
	}

	@Override
	public void seatNotAvailableTatkal(String string) {
		System.out.println(string);
		System.out.println("1.Continue\n2.Back\n3.Exit");
		int number = scanner.nextInt();
		switch (number) {
		case 1:
			controller.paymentTakkal();
			break;
		case 2:
			selectQuota();
			break;
		case 3:
			exit();
		default:
			System.out.println("\t\t\t\tYou entered an invalid number");
			exit();
		}
	}

	@Override
	public void payAmount(String string) {
		System.out.println(string);
		System.out.println("Enter the amount");
		scanner.next();
		controller.confirm(name, trainId, from, to, quota, userDate);
		new LoginView().login();
	}

}