package com.cognixia.jumplus.dollarsbankapp.anorthouse.view;

import com.cognixia.jumplus.dollarsbankapp.anorthouse.model.User;
import com.cognixia.jumplus.dollarsbankapp.anorthouse.view.ColoredOutput.ANSI_FONT_COLOR;

public class UserView {

	//Simple print method
	public String printUserDetails(User user) {
		//TODO add color implementaiton
		String message = "User Details: \n"
				+ "- Name: " + user.getName() +"\n"
				+ "- Contact Number: " + user.getContactNumber() + "\n"
				+ "- Balance: " + user.getBalance() + "\n";
		
		printToConsole(message);
		return message;
	}

	//Calls ColoredOutput to print correctly
	private void printToConsole(String message) {
		ColoredOutput.printAnsiText(ANSI_FONT_COLOR.BLACK, message);
	}
}
