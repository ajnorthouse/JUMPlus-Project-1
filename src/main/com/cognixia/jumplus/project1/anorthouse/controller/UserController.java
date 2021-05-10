package com.cognixia.jumplus.project1.anorthouse.controller;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.cognixia.jumplus.project1.anorthouse.model.User;

//TODO - JavaDoc description
public class UserController {
	
	// id methods
	//TODO - JavaDoc description
	public Long getId(User user) {
		return user.getId();
	}
	
	
	// username methods
	//TODO - JavaDoc description
	public String getUsername(User user) {
		return user.getUsername();
	}
	//TODO - JavaDoc description
	public void setUsername(User user, String username) {
		user.setUsername(username);
	}
	
	
	// password methods
	//TODO - JavaDoc description
	public String getPassword(User user) {
		return user.getPassword();
	}
	//TODO - JavaDoc description
	public void setPassword(User user, String password) {
		user.setPassword(password);
	}
	
	
	// name methods
	//TODO - JavaDoc description
	public String getName(User user) {
		return user.getName();
	}
	//TODO - JavaDoc description
	public void setName(User user, String name) {
		user.setName(name);
	}
	
	
	// contactNumber methods
	//TODO - JavaDoc description
	public String getContactNumber(User user) {
		return user.getContactNumber();
	}
	//TODO - JavaDoc description
	public void setContactNumber(User user, String contactNumber) {
		user.setContactNumber(contactNumber);
	}
	

	// balance methods
	//TODO - JavaDoc description
	public double getBalance(User user) {
		return user.getBalance();
	}
	//TODO - JavaDoc description
	public void setBalance(User user, double balance) {
		user.setBalance(balance);
	}
	

	// log methods
	//TODO - JavaDoc description
	public ArrayList<String> getUserLog(User user) {
		return user.getLog();
	}
	//TODO - JavaDoc description
	public void setUserLog(User user, ArrayList<String> log) {
		user.setLog(log);
	}
	/**
	 * Function for updating the log with what happened to that account.
	 * @param user
	 * @param message
	 */
	//TODO - JavaDoc description
	public String updateLog(User user, String message) {
		//generates date:
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy - HH:mm:ss z"); 
		String date = (ZonedDateTime.now().format(formatter) + "\n");
		
		//gets log, adds new entry, then sets log
		ArrayList<String> tempLog = user.getLog();
		tempLog.add(date + message);
		user.setLog(tempLog);
		return (date + message);
	}

}
