package com.ticketbooking.repository;

import java.util.List;

import com.ticketbooking.dto.User;

public class Data {

	private List<User> users;
	
	public void setUsers(List<User> users) {
		this.users = users;
	}

	Data() {

	}

	public List<User> getUsers() {
		return users;
	}

	@Override
	public String toString() {
		return "Data [users=" + users + "]";
	}
	
}
