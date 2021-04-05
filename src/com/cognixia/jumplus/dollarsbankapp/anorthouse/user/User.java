package com.cognixia.jumplus.dollarsbankapp.anorthouse.user;

import java.util.ArrayList;

public class User {
	private static Long currentID = 0L;
	private Long id;
	private String userId;
	private String password;
	private String name;
	private String contactNumber;
	private double balance;
	private ArrayList<String> log;
	
	//constructors:
	// empty constructor
	public User() {
		super();
		id = currentID++;
	}
	// default constructor
	public User(String userId, String password, String name, String contactNumber, double balance) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.contactNumber = contactNumber;
		this.balance = balance;
		this.log = new ArrayList<String>();
	}

	/* userId methods */
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/* password methods */
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	/* name methods */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	/* contactNumber methods */
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	/* balance methods */
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/* log methods */
	public ArrayList<String> getLog() {
		return log;
	}
	public void setLog(ArrayList<String> log) {
		this.log = log;
	}
	
}
