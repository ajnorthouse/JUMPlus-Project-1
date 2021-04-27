package com.cognixia.jumplus.dollarsbankapp.anorthouse.model;

import java.util.ArrayList;

public class User {
	// Class Variables
	private static Long currentID = 1L;
	private Long id;
	private String username;
	private String password;
	private String name;
	private String contactNumber;
	private double balance;
	private ArrayList<String> log;
	
	
	// Constructors
	public User() {
		super();
		id = currentID++;
		username = "N/A";
		password = "";
		name = "N/A";
		contactNumber = "N/A";
		balance = 0.0;
		log = null;
	}
	public User(String username, String password, String name, String contactNumber, double balance) {
		this();
		this.username = username;
		this.password = password;
		this.name = name;
		this.contactNumber = contactNumber;
		this.balance = balance;
		this.log = new ArrayList<String>();
	}
	
	
	// Getters
	public static Long getCurrentID() {
		return currentID;
	}
	public Long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public double getBalance() {
		return balance;
	}
	public ArrayList<String> getLog() {
		return log;
	}
	
	
	// Setters
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void setLog(ArrayList<String> log) {
		this.log = log;
	}
	
}
