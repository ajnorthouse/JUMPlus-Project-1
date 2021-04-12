package com.cognixia.jumplus.dollarsbankapp.anorthouse.controller;

import java.util.ArrayList;

import com.cognixia.jumplus.dollarsbankapp.anorthouse.application.UserView;
import com.cognixia.jumplus.dollarsbankapp.anorthouse.model.User;

public class UserController {
	private User model;
	private UserView view;
	
	public UserController(User model, UserView view) {
		this.model = model;
		this.view = view;
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
		// TODO update log
	}
	public void subtractWithdraw(double userInput) {
		double balance = model.getBalance() - userInput;
		model.setBalance(balance);
		// TODO update log
	}
	
	//log
	public ArrayList<String> getUserLog() {
		return model.getLog();
	}
	public void setUserLog(ArrayList<String> log) {
		model.setLog(log);
	}
	
	//view
	public String updateView() {
		return view.printUserDetails(model);
	}


	
}
