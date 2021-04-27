package com.cognixia.jumplus.dollarsbankapp.anorthouse.controller;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.cognixia.jumplus.dollarsbankapp.anorthouse.model.User;

public class UserController {
	
	// id methods
	public Long getId(User user) {
		return user.getId();
	}
	
	
	// username methods
	public static String getUsername(User user) {
		return user.getUsername();
	}
	public static void setUsername(User user, String username) {
		user.setUsername(username);
	}
	
	
	// password methods
	public static String getPassword(User user) {
		return user.getPassword();
	}
	public static void setPassword(User user, String password) {
		user.setPassword(password);
	}
	
	
	// name methods
	public static String getName(User user) {
		return user.getName();
	}
	public static void setName(User user, String name) {
		user.setName(name);
	}
	
	
	// contactNumber methods
	public static String getContactNumber(User user) {
		return user.getContactNumber();
	}
	public static void setContactNumber(User user, String contactNumber) {
		user.setContactNumber(contactNumber);
	}
	

	// balance methods
	public static double getBalance(User user) {
		return user.getBalance();
	}
	public static void setBalance(User user, double balance) {
		user.setBalance(balance);
	}
	

	// log methods
	public static ArrayList<String> getUserLog(User user) {
		return user.getLog();
	}
	public static void setUserLog(User user, ArrayList<String> log) {
		user.setLog(log);
	}
	/**
	 * Function for updating the log with what happened to that account.
	 * @param user
	 * @param message
	 */
	public static void updateLog(User user, String message) {
		//generates date:
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy - HH:mm:ss z"); 
		String date = (ZonedDateTime.now().format(formatter) + "\n");
		
		//gets log, adds new entry, then sets log
		ArrayList<String> tempLog = user.getLog();
		tempLog.add(date + message);
		user.setLog(tempLog);
	}

}
