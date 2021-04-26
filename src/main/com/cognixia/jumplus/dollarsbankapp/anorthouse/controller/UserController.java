package com.cognixia.jumplus.dollarsbankapp.anorthouse.controller;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.cognixia.jumplus.dollarsbankapp.anorthouse.model.User;

public class UserController {
	
	private User model;
	
	
	// id methods
	public Long getId() {
		return model.getId();
	}
	
	
	// username methods
	public String getUsername() {
		return model.getUsername();
	}
	public void setUsername(String username) {
		model.setUsername(username);
	}
	
	
	// password methods
	public String getPassword() {
		return model.getPassword();
	}
	public void setPassword(String password) {
		model.setPassword(password);
	}
	
	
	// name methods
	public String getName() {
		return model.getName();
	}
	public void setName(String name) {
		model.setName(name);
	}
	
	
	// contactNumber methods
	public String getContactNumber() {
		return model.getContactNumber();
	}
	public void setContactNumber(String contactNumber) {
		model.setContactNumber(contactNumber);
	}
	

	// balance methods
	public double getBalance() {
		return model.getBalance();
	}
	public void setBalance(double balance) {
		model.setBalance(balance);
	}
	

	// log methods
	public ArrayList<String> getUserLog() {
		return model.getLog();
	}
	public void setUserLog(ArrayList<String> log) {
		model.setLog(log);
	}
	/**
	 * Function for updating the log with what happened to that account.
	 * @param user
	 * @param message
	 */
	public void updateLog(User user, String message) {
		//generates date:
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy - HH:mm:ss z"); 
		String date = (ZonedDateTime.now().format(formatter) + "\n");
		
		//gets log, adds new entry, then sets log
		ArrayList<String> tempLog = user.getLog();
		tempLog.add(date + message);
		user.setLog(tempLog);
	}

}
