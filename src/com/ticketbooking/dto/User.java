package com.ticketbooking.dto;

import java.util.ArrayList;
import java.util.List;

public class User {

	String name, password, address, mailID;
	long phoneNumber;

	List<MyBooking> booking = new ArrayList<>();

	User() {

	}

	public User(String name, String password, String address, long phoneNumber, String mailID) {
		this.name = name;
		this.password = password;
		this.address = address;
		this.mailID = mailID;
		this.phoneNumber = phoneNumber;
	}

	public List<MyBooking> getBooking() {
		return booking;
	}

	public void setBooking(List<MyBooking> booking) {
		this.booking = booking;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMailID() {
		return mailID;
	}

	public void setMailID(String mailID) {
		this.mailID = mailID;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}