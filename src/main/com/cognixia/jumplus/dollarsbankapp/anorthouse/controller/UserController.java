package com.cognixia.jumplus.dollarsbankapp.anorthouse.controller;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.cognixia.jumplus.dollarsbankapp.anorthouse.application.UserView;
import com.cognixia.jumplus.dollarsbankapp.anorthouse.model.User;

public class UserController {
	static ArrayList<User> users = new ArrayList<User>();
	private User model;
	private UserView view;
	
	public UserController() {
		this.model = null;
		this.view = new UserView();
	}
	
	//User / model
	public void setCurrentUser(User user) {
		this.model = user;
	}
	public boolean attemptLogin(String userId, String password) {
		
		//for loop to iterate over all users
		//	- not enhanced because users can be empty at this point
		for (int counter = 0; counter < users.size(); counter++) {
			
			//checks for matching userId
			if (users.get(counter).getUserId().equals(userId)) {
				
				//then checks if the passwords are equal
				if (users.get(counter).getPassword().equals(password)) {
					setCurrentUser(users.get(counter));
					return true;
				}
				
				//this breaks the loop, as a matching userId was found
				return false;
			}
		}
		
		return false;
	}
	public boolean createUser(String userId, String password, String name, String contactNumber, double balance) {
		
		//first checks for any matching userId
		for (int counter = 0; counter < users.size(); counter++) {
			if (users.get(counter).getUserId().equals(userId)) {
				return false;
			}
		}
		
		//then just creates the user
		User newUser = new User(userId, password, name, contactNumber, balance);
		updateLog(newUser, "Created Account with initial balance of: $" + balance + ".");
		users.add(newUser);
		
		
		return true;
	}
	
	//id
	public Long getUserId() {
		return model.getId();
	}
	
	//userId
	public String getUserUserId() {
		return model.getUserId();
	}
	public void setUserUserId(String userId) {
		model.setUserId(userId);
	}
	
	//password
	public String getUserPassword() {
		return model.getPassword();
	}
	public void setUserPassword(String password) {
		model.setPassword(password);
	}
	
	//name
	public String getUserName() {
		return model.getName();
	}
	public void setUserName(String name) {
		model.setName(name);
	}
	
	//contactNumber
	public String getUserContactNumber() {
		return model.getContactNumber();
	}
	public void setUserContactNumber(String contactNumber) {
		model.setContactNumber(contactNumber);
	}
	
	//balance
	public double getUserBalance() {
		return model.getBalance();
	}
	public void setUserBalance(double balance) {
		model.setBalance(balance);
	}
	public void addDeposit(double userInput) {
		double balance = model.getBalance() + userInput;
		model.setBalance(balance);
		String message = "Deposited $" + userInput + " to bring Balance to: $" + balance + ".";
		updateLog(model, message);
	}
	public void addDeposit(User user, String transferUserId, double userInput) {
		double balance = user.getBalance() + userInput;
		user.setBalance(balance);
		String message = "Received $" + userInput + " from " + transferUserId + ", Balance now: $" + balance + ".";
		updateLog(user, message);
	}
	public void subtractWithdraw(double userInput) {
		double balance = model.getBalance() - userInput;
		model.setBalance(balance);
		String message = "Withdrew $" + userInput + " to bring Balance to: $" + balance + ".";
		updateLog(model, message);
	}
	public void subtractWithdraw(User user, String transferUserId, double userInput) {
		double balance = user.getBalance() - userInput;
		user.setBalance(balance);
		String message = "Transfered $" + userInput + " to " + transferUserId + ", Balance now: $" + balance + ".";
		updateLog(user, message);
	}

	public boolean attemptTransfer(String transferUserId, double amount) {
		//temp user for the transfer
		User tempUser = null;
		
		//first checks for any matching userId
		for (int counter = 0; counter < users.size(); counter++) {
			
			//stops loop if a matching userId is found
			if (users.get(counter).getUserId().equals(transferUserId)) {
				tempUser = users.get(counter);
				break;
			}
			
			//returns false if no matching userIds were found
			if (counter - 1 == users.size()) {
				return false;
			}
		}
		
		//subtracts withdrawl and then adds deposit
		subtractWithdraw(model, tempUser.getUserId(), amount);
		addDeposit(tempUser, model.getUserId(), amount);
		
		return true;
	}
	
	//log
	public ArrayList<String> getUserLog() {
		return model.getLog();
	}
	public void setUserLog(ArrayList<String> log) {
		model.setLog(log);
	}
	public void updateLog(User user, String message) {
		//generates date:
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy - HH:mm:ss z"); 
		String date = (ZonedDateTime.now().format(formatter) + "\n");
		
		//gets log, adds new entry, then sets log
		ArrayList<String> tempLog = user.getLog();
		tempLog.add(date + message);
		user.setLog(tempLog);
	}
	
	//view
	public String showUserInfo() {
		return view.printUserDetails(model);
	}

	public void showLastTransactions(int numOfTransactions) {
		// gets variables
		ArrayList<String> log = model.getLog();
		int logSize = log.size(), iterations;
		
		// calculates how many times to run for loop
		if (logSize < numOfTransactions) {
			iterations = log.size();
		} else {
			iterations = numOfTransactions;
		}
		
		//for loop:
		for (int counter = 0; counter < iterations; counter++) {
			// TODO move print to view
			System.out.println(log.get(logSize - iterations + counter));
			System.out.println("");
		}
	}



}
