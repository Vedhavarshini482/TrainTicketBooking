package com.ticketbooking.repository;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ticketbooking.dto.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketbooking.dto.Admin;
import com.ticketbooking.dto.Amount;
import com.ticketbooking.dto.MyBooking;
import com.ticketbooking.dto.Reservation;
import com.ticketbooking.dto.Tatkal;
import com.ticketbooking.dto.Train;
import com.ticketbooking.dto.TrainSeats;

public class Repository {

	private List<Admin> adminDetails = new ArrayList<>();
	private Data data;
	private TrainData trainData;
	private Reservation reservation = new Reservation();
	private Tatkal tatkal = new Tatkal();
	private HashMap<String, User> users = new HashMap<>();
	private HashMap<Integer, Train> available = new HashMap<>();

	private List<String> chennaiToSengottai = new ArrayList<>();
	private List<String> sengottaiToChennai = new ArrayList<>();
	private List<String> chennaiToKollam = new ArrayList<>();
	private List<String> kollamToChennai = new ArrayList<>();

	private static Repository repository;

	private Repository() {
		this.readFile();
		this.readTrainFile();
	}

	public void exit() {
		this.writeFile();
		this.writeTrainFile();
	}

	public static Repository getInstance() {
		if (repository == null) {
			repository = new Repository();
			repository.adminInfo();
			repository.exit();
		}
		return repository;
	}

	private void writeFile() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File("src//com//ticketbooking//repository//UserDetails.json").getAbsoluteFile(),
					data);
		} catch (IOException e) {
			System.out.println("Cannot write file");
		}
	}

	private void readFile() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			data = (Data) mapper.readValue(
					new File("src//com//ticketbooking//repository//UserDetails.json").getAbsoluteFile(), Data.class);
			for (User user : data.getUsers()) {
				users.put(user.getName(), user);
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Cannot read file");
		}
	}

	private void writeTrainFile() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File("src//com//ticketbooking//repository//TrainData.json").getAbsoluteFile(),
					trainData);
		} catch (IOException e) {
			System.out.println("Cannot write train file");
		}
	}

	private void readTrainFile() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			trainData = (TrainData) mapper.readValue(
					new File("src//com//ticketbooking//repository//TrainData.json").getAbsoluteFile(), TrainData.class);
			for (Train train : trainData.getTrain()) {
				available.put(train.getId(), train);
			}
		} catch (Exception e) {
			System.out.println("Cannot read train file");
		}
	}

	private void adminInfo() {
		adminDetails.add(new Admin("Varsha", "0000"));
		adminDetails.add(new Admin("Admin", "0000"));
		trainInfo();
	}

	private void trainInfo() {

		chennaiToSengottai();
		sengottaiToChennai();
		kollamToChennai();
		chennaiToKollam();

		trainData();
	}

	private void trainData() {

		TrainSeats reserve = new TrainSeats(15, 15, 10, 10, 10);
		reservation.getReservation().add(reserve);

		Amount amount = new Amount(2500, 1500, 1000, 600, 300);
		reservation.getAmount().add(amount);

		TrainSeats tatkalSeat = new TrainSeats(15, 15, 5, 5, 5);
		Amount amount2 = new Amount(2500, 1500, 1000, 600, 300);

		tatkal.getTatkal().add(tatkalSeat);
		tatkal.getAmount().add(amount2);
	}

	public Admin validAdmin(String userName, String password) {
		for (Admin admin : adminDetails) {
			if (admin.getUserName().equals(userName) && admin.getPassword().equals(password))
				return admin;
		}
		return null;
	}

	public User validUser(String name, String password) {
		for (User user : data.getUsers()) {
			if (user.getName().equalsIgnoreCase(name) && user.getPassword().equals(password))
				return user;
		}
		return null;
	}

	public void removeUser(String name, String password) {
		for (User user : data.getUsers()) {
			if (user.getName().equalsIgnoreCase(name) && user.getPassword().equals(password)) {
				data.getUsers().remove(user);
				exit();
				break;
			}
		}
	}

	public void createAccount(String name, String password, String address, long mobileNumber, String mailID) {
		User user = new User(name, password, address, mobileNumber, mailID);
		data.getUsers().add(user);
		users.put(name, user);
		exit();
	}

	public List<ArrayList<String>> bookings() {
		List<ArrayList<String>> userList = new ArrayList<>();
		for (User user : data.getUsers()) {
			if (user.getBooking() != null) {
				ArrayList<String> userDetails = new ArrayList<>();
				userDetails.add(user.getName());
				userDetails.add(user.getMailID());
				userDetails.add(user.getAddress());
				userDetails.add(Long.toString(user.getPhoneNumber()));
				userList.add(userDetails);
			}
		}
		return userList;
	}

	private void sengottaiToChennai() {
		sengottaiToChennai.add("Sengottai");
		sengottaiToChennai.add("Tenkasi");
		sengottaiToChennai.add("Kadayanallur");
		sengottaiToChennai.add("Pamba kovil Shandy");
		sengottaiToChennai.add("Sankarankovil");
		sengottaiToChennai.add("Rajapalayam");
		sengottaiToChennai.add("Srivilliputtur");
		sengottaiToChennai.add("Sivakasi");
		sengottaiToChennai.add("Thiruttangal");
		sengottaiToChennai.add("Virudhunagar");
		sengottaiToChennai.add("Madurai");
		sengottaiToChennai.add("Dindigul");
		sengottaiToChennai.add("Tiruchirappalli");
		sengottaiToChennai.add("Vriddhachalam");
		sengottaiToChennai.add("Villupuram");
		sengottaiToChennai.add("Chengalpattu");
		sengottaiToChennai.add("Tambaram");
		sengottaiToChennai.add("Chennai");

	}

	private void chennaiToSengottai() {
		chennaiToSengottai.add("Chennai");
		chennaiToSengottai.add("Tambaram");
		chennaiToSengottai.add("Chengalpattu");
		chennaiToSengottai.add("Villupuram");
		chennaiToSengottai.add("Vriddhachalam");
		chennaiToSengottai.add("Tiruchirappalli");
		chennaiToSengottai.add("Dindigul");
		chennaiToSengottai.add("Madurai");
		chennaiToSengottai.add("Virudhunagar");
		chennaiToSengottai.add("Thiruttangal");
		chennaiToSengottai.add("Sivakasi");
		chennaiToSengottai.add("Srivilliputtur");
		chennaiToSengottai.add("Rajapalayam");
		chennaiToSengottai.add("Pamba kovil Shandy");
		chennaiToSengottai.add("Kadayanallur");
		chennaiToSengottai.add("Tenkasi");
		chennaiToSengottai.add("Sengottai");
	}

	private void chennaiToKollam() {
		chennaiToKollam.add("Chennai");
		chennaiToKollam.add("Tambaram");
		chennaiToKollam.add("Chengalpattu");
		chennaiToKollam.add("Villupuram");
		chennaiToKollam.add("Vriddhachalam");
		chennaiToKollam.add("Tiruchirappalli");
		chennaiToKollam.add("Dindigul");
		chennaiToKollam.add("Madurai");
		chennaiToKollam.add("Virudhunagar");
		chennaiToKollam.add("Thiruttangal");
		chennaiToKollam.add("Sivakasi");
		chennaiToKollam.add("Srivilliputtur");
		chennaiToKollam.add("Rajapalayam");
		chennaiToKollam.add("Pamba kovil Shandy");
		chennaiToKollam.add("Kadayanallur");
		chennaiToKollam.add("Tenkasi");
		chennaiToKollam.add("Sengottai");
		chennaiToKollam.add("Punalur");
		chennaiToKollam.add("Auvaneeswaram");
		chennaiToKollam.add("Kottarakara");
		chennaiToKollam.add("kundara");
		chennaiToKollam.add("Kollam");
	}

	private void kollamToChennai() {
		kollamToChennai.add("Kollam");
		kollamToChennai.add("kundara");
		kollamToChennai.add("Kottarakara");
		kollamToChennai.add("Auvaneeswaram");
		kollamToChennai.add("Punalur");
		kollamToChennai.add("Sengottai");
		kollamToChennai.add("Tenkasi");
		kollamToChennai.add("Kadayanallur");
		kollamToChennai.add("Pamba kovil Shandy");
		kollamToChennai.add("Sankarankovil");
		kollamToChennai.add("Rajapalayam");
		kollamToChennai.add("Srivilliputtur");
		kollamToChennai.add("Sivakasi");
		kollamToChennai.add("Thiruttangal");
		kollamToChennai.add("Virudhunagar");
		kollamToChennai.add("Madurai");
		kollamToChennai.add("Dindigul");
		kollamToChennai.add("Tiruchirappalli");
		kollamToChennai.add("Vriddhachalam");
		kollamToChennai.add("Villupuram");
		kollamToChennai.add("Chengalpattu");
		kollamToChennai.add("Tambaram");
		kollamToChennai.add("Chennai");
	}

	public List<List<String>> checkTrainAvailability(String from, String to) {
		List<List<String>> trains = new ArrayList<>();
		List<String> array1 = new ArrayList<>();
		array1 = checksengottaiChennai(from, to);
		List<String> array2 = new ArrayList<>();
		array2 = checkChennaiKollam(from, to);

		if (array1.size() != 0)
			trains.add(array1);
		if (array2.size() != 0)
			trains.add(array2);

		return trains;
	}

	private List<String> checkChennaiKollam(String from, String to) {
		int start = -1, end = -1, id = 0;
		for (int i = 0; i < kollamToChennai.size(); i++) {
			System.out.println(kollamToChennai.get(i));
			if (kollamToChennai.get(i).equalsIgnoreCase(from))
				start = i;
			else if (kollamToChennai.get(i).equalsIgnoreCase(to))
				end = i;
		}

		if (start < end)
			id = 4;
		else if (start > end)
			id = 2;
		List<String> array = new ArrayList<>();
		if (id != 0 && start != -1 && end != -1) {
			Train train = available.get(id);
			array.add(Integer.toString(train.getId()));
			array.add(train.getTrainName());
			array.add(train.getTrainNo());
			array.add(train.getFromStation());
			array.add(train.getToStation());
			array.add(train.getTime());
			array.add(Integer.toString(train.getTotalSeats()));
		}

		return array;
	}

	private List<String> checksengottaiChennai(String from, String to) {
		int start = -1, end = -1, id = 0;
		for (int i = 0; i < chennaiToSengottai.size(); i++) {
			System.out.println(chennaiToSengottai.get(i));
			if (chennaiToSengottai.get(i).equalsIgnoreCase(from))
				start = i;
			else if (chennaiToSengottai.get(i).equalsIgnoreCase(to))
				end = i;
		}
		if (start < end)
			id = 1;
		else if (start > end)
			id = 3;

		List<String> array = new ArrayList<>();
		if (id != 0 && start != -1 && end != -1) {
			Train train = available.get(id);
			array.add(Integer.toString(train.getId()));
			array.add(train.getTrainName());
			array.add(train.getTrainNo());
			array.add(train.getFromStation());
			array.add(train.getToStation());
			array.add(train.getTime());
			array.add(Integer.toString(train.getTotalSeats()));
		}
		return array;
	}

	public int showFirstAc(String quota) {
		int seats;
		if (quota.equals("Reservation"))
			seats = reservation.getReservation().get(0).getFirstAC();
		else
			seats = tatkal.getTatkal().get(0).getFirstAC();
		return seats;
	}

	public int showSecondAc(String quota) {
		int seats;
		if (quota.equals("Reservation")) {
			seats = reservation.getReservation().get(0).getFirstAC();
			System.out.println(seats);
		} else
			seats = tatkal.getTatkal().get(0).getSecondAC();
		return seats;
	}

	public int showThirdAc(String quota) {
		int seats;
		if (quota.equals("Reservation"))
			seats = reservation.getReservation().get(0).getThirdAC();
		else
			seats = tatkal.getTatkal().get(0).getThirdAC();
		return seats;
	}

	public int showSleeper(String quota) {
		int seats;
		if (quota.equals("Reservation"))
			seats = reservation.getReservation().get(0).getSleeper();
		else
			seats = tatkal.getTatkal().get(0).getSleeper();
		return seats;
	}

	public int showSecondSitting(String quota) {
		int seats;
		if (quota.equals("Reservation"))
			seats = reservation.getReservation().get(0).getSecondSitting();
		else
			seats = tatkal.getTatkal().get(0).getSecondSitting();
		return seats;
	}

	public boolean ticketAvailable(int ticketCount, String seating) {
		switch (seating) {
		case "AC First Class(1A)":
			if (ticketCount <= reservation.getReservation().get(0).getFirstAC())
				return true;
		case "AC 2Tier(2A)":
			if (ticketCount <= reservation.getReservation().get(0).getSecondAC())
				return true;
		case "AC 3Tier(3A)":
			if (ticketCount <= reservation.getReservation().get(0).getThirdAC())
				return true;
		case "Sleeper(SL)":
			if (ticketCount <= reservation.getReservation().get(0).getSleeper())
				return true;
		case "Second Sitting(2S)":
			if (ticketCount <= reservation.getReservation().get(0).getSecondSitting())
				return true;
		}
		return false;
	}

	public boolean ticketAvailableTatkal(int ticketCount, String seating) {
		switch (seating) {
		case "AC First Class(1A)":
			if (ticketCount <= tatkal.getTatkal().get(0).getFirstAC())
				return true;
		case "AC 2Tier(2A)":
			if (ticketCount <= tatkal.getTatkal().get(0).getSecondAC())
				return true;
		case "AC 3Tier(3A)":
			if (ticketCount <= tatkal.getTatkal().get(0).getThirdAC())
				return true;
		case "Sleeper(SL)":
			if (ticketCount <= tatkal.getTatkal().get(0).getSleeper())
				return true;
		case "Second Sitting(2S)":
			if (ticketCount <= tatkal.getTatkal().get(0).getSecondSitting())
				return true;
		}
		return false;
	}

	public boolean checkOpened() {
		LocalTime localTime = LocalTime.now();
		String time = localTime.toString();
		time = time.substring(0, 2);

		if (Integer.parseInt(time.toString()) >= 11 && Integer.parseInt(time.toString()) <= 15)
			return true;
		else
			return false;
	}

	public int paymentReservation(int ticketCount, String seating) {
		int amount = 0;
		switch (seating) {
		case "AC First Class(1A)":
			amount = ticketCount * reservation.getAmount().get(0).getFirstAC();
		case "AC 2Tier(2A)":
			amount = ticketCount * reservation.getAmount().get(0).getSecondAC();
		case "AC 3Tier(3A)":
			amount = ticketCount * reservation.getAmount().get(0).getThirdAC();
			break;
		case "Sleeper(SL)":
			amount = ticketCount * reservation.getAmount().get(0).getSleeper();
			break;
		case "Second Sitting(2S)":
			amount = ticketCount * reservation.getAmount().get(0).getSecondSitting();
			break;
		}
		return amount;
	}

	public void confirmTicket(String name, String id, String from, String to, int seats, String statement, int amount,
			String quota, String trainClass, List<String> seatType) {
		this.users.get(name.toUpperCase()).getBooking()
				.add(new MyBooking(Integer.parseInt(id), amount, seats,
						available.get(Integer.parseInt(id)).getTrainName(), from, to,
						available.get(Integer.parseInt(id)).getTrainNo(), quota, statement, seatType));

		trainData.getTrain().get(Integer.parseInt(id)).setTrainName(available.get(Integer.parseInt(id)).getTrainName());
		trainData.getTrain().get(Integer.parseInt(id))
				.setFromStation(available.get(Integer.parseInt(id)).getFromStation());
		trainData.getTrain().get(Integer.parseInt(id))
				.setFromStation(available.get(Integer.parseInt(id)).getToStation());
		trainData.getTrain().get(Integer.parseInt(id))
				.setAvailableSeats(trainData.getTrain().get(0).getAvailableSeats() - seats);
		if (quota.equals("Tatkal"))
			trainData.getTrain().get(Integer.parseInt(id)).setBookedTatkalSeats(seats);
		else
			trainData.getTrain().get(Integer.parseInt(id)).setBookedReservationSeats(seats);

		exit();
	}

	public int paymentTatkal(int ticketCount, String seating) {
		int amount = 0;
		switch (seating) {
		case "AC First Class(1A)":
			amount = ticketCount * tatkal.getAmount().get(0).getFirstAC();
		case "AC 2Tier(2A)":
			amount = ticketCount * tatkal.getAmount().get(0).getSecondAC();
		case "AC 3Tier(3A)":
			amount = ticketCount * tatkal.getAmount().get(0).getThirdAC();
			break;
		case "Sleeper(SL)":
			amount = ticketCount * tatkal.getAmount().get(0).getSleeper();
			break;
		case "Second Sitting(2S)":
			amount = ticketCount * tatkal.getAmount().get(0).getSecondSitting();
			break;
		}
		return amount;

	}

	public List<ArrayList<String>> trainDetails() {
		List<ArrayList<String>> trainList = new ArrayList<>();
		for (Train train : trainData.getTrain()) {
			ArrayList<String> trainDetails = new ArrayList<>();
			trainDetails.add(Integer.toString(train.getId()));
			trainDetails.add(train.getTrainName());
			trainDetails.add(train.getTrainNo());
			trainDetails.add(train.getFromStation());
			trainDetails.add(train.getToStation());
			trainDetails.add(train.getTime());
			trainDetails.add(Integer.toString(train.getAvailableSeats()));
			trainDetails.add(Integer.toString(train.getTotalSeats()));
			trainDetails.add(Integer.toString(train.getBookedReservationSeats()));
			trainDetails.add(Integer.toString(train.getBookedTatkalSeats()));
			trainList.add(trainDetails);
		}
		return trainList;
	}

}