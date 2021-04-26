package com.cognixia.jumplus.dollarsbankapp.anorthouse.view;

import com.cognixia.jumplus.dollarsbankapp.anorthouse.model.User;

public class UserView {
	
	//gets the user's details
	public String getUserDetails(User user) {
		//TODO add color implementation
		String message = "User Details: \n"
				+ "- Name: " + user.getName() +"\n"
				+ "- Contact Number: " + user.getContactNumber() + "\n"
				+ "- Balance: " + user.getBalance() + "\n";
		
		return message;
	}
	
	//TODO create logs message
}
