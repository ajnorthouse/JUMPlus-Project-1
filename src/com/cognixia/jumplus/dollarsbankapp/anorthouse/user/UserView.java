package com.cognixia.jumplus.dollarsbankapp.anorthouse.user;

public class UserView {
	public void printUserDetails(String userId, String name, String contactNumber, double balance) {
		System.out.println("User: ");
		System.out.println("Name: " + userId);
		System.out.println("Contact Number: " + contactNumber);
		System.out.println("Balance: " + balance);
	}
}
