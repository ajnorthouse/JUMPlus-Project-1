package com.cognixia.jumplus.dollarsbankapp.anorthouse.view;

import com.cognixia.jumplus.dollarsbankapp.anorthouse.model.User;

public class UserView {
	public String printUserDetails(User user) {
		//TODO add color implementaiton
		String message = "User Details: \n"
				+ "- Name: " + user.getUserId() +"\n"
				+ "- Contact Number: " + user.getContactNumber() + "\n"
				+ "- Balance: " + user.getBalance() + "\n";
		
		printToConsole(message);
		return message;
	}
	
	private void printToConsole(String message) {
		System.out.println(message);
	}
}
