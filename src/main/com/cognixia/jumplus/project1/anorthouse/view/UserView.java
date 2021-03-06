package com.cognixia.jumplus.project1.anorthouse.view;

import java.util.ArrayList;

import com.cognixia.jumplus.project1.anorthouse.model.User;

//TODO - JavaDoc description
public class UserView {
	
	StringBuilder userString = new StringBuilder();
	

	//TODO - JavaDoc description
	//gets the user's details
	public String getUserDetails(User user) {
		//TODO - add color implementation
		
		//resets string builder
		userString.setLength(0);
		
		userString.append("User Details: \n");
		userString.append("- Name: " + user.getName() +"\n");
		userString.append("- Contact Number: " + user.getContactNumber() + "\n");
		userString.append("- Balance: " + user.getBalance() + "\n");

		return userString.toString();
	}


	//TODO - JavaDoc description
	public String showLastTransactions(User user, int numOfTransactions) {
		//resets string builder
		userString.setLength(0);
		
		// gets variables
		ArrayList<String> log = user.getLog();
		int logSize = log.size(), iterations;
		
		// calculates how many times to run for loop
		if (logSize < numOfTransactions) {
			iterations = log.size();
		} else {
			iterations = numOfTransactions;
		}
		
		//for loop:
		for (int counter = 0; counter < iterations; counter++) {
			userString.append(log.get(logSize - iterations + counter) + "\n");
		}
		
		return userString.toString();
	}

}
