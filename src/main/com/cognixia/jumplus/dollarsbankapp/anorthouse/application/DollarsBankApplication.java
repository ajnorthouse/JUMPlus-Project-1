package com.cognixia.jumplus.dollarsbankapp.anorthouse.application;

import java.util.ArrayList;
import java.util.Scanner;

import com.cognixia.jumplus.dollarsbankapp.anorthouse.controller.UserController;
import com.cognixia.jumplus.dollarsbankapp.anorthouse.model.User;

public class DollarsBankApplication {
	
	static ArrayList<User> users = new ArrayList<User>();
	public enum inputOptions {
		NUMBER, DOUBLE, STRING
	}
	
	/**
	 * 
	 * @param args
	 */
    public static void main( String[] args ) {
    	Scanner scanner = new Scanner(System.in);
    	UserController loggedInUser = new UserController(new User(), new UserView());
    	welcomeScreen(scanner, loggedInUser);
	}
    
    // Menu Screens:
    /**
     * 
     * @param scanner
     * @param loggedInUser
     */
    public static void welcomeScreen(Scanner scanner, UserController loggedInUser) {
    	System.out.println("+---------------------------+");
    	System.out.println("| DOLLARSBANK Welcomes You! |");
    	System.out.println("+---------------------------+");
    	System.out.println("1. Create New Account");
    	System.out.println("2. Login");
    	System.out.println("3. Exit\n");
    	System.out.println("Enter Choice (1, 2, or 3):");
    	takeInput(scanner, inputOptions.NUMBER);
    }
    
    /**
     * 
     */
    public static void createNewAccount(Scanner scanner, UserController loggedInUser) {
    	// TODO
    	System.out.println("+---------------------------+");
    	System.out.println("| Enter New Account Details |");
    	System.out.println("+---------------------------+");
    	takeInput(scanner, inputOptions.NUMBER);
    }
    
    /**
     * 
     */
    public static void loginScreen(Scanner scanner, UserController loggedInUser) {
    	// TODO
    	System.out.println("+---------------------------+");
    	System.out.println("|    Enter Login Details    |");
    	System.out.println("+---------------------------+");
    	takeInput(scanner, inputOptions.NUMBER);
    }

    /**
     * 
     */
    public static void mainScreen(Scanner scanner, UserController loggedInUser) {
    	// TODO
    	System.out.println("+---------------------------+");
    	System.out.println("|        Home Screen        |");
    	System.out.println("+---------------------------+");
    	takeInput(scanner, inputOptions.NUMBER);
    }
    
    /**
     * 
     */
    public static void depositAmount(Scanner scanner, UserController loggedInUser) {
    	// TODO
    	System.out.println("+---------------------------+");
    	System.out.println("|       Deposit Amount      |");
    	System.out.println("+---------------------------+");
    	takeInput(scanner, inputOptions.NUMBER);
    }
    
    /**
     * 
     */
    public static void withdrawAmount(Scanner scanner, UserController loggedInUser) {
    	// TODO
    	System.out.println("+---------------------------+");
    	System.out.println("|      Withdraw Amount      |");
    	System.out.println("+---------------------------+");
    	takeInput(scanner, inputOptions.NUMBER);
    }
    
    /**
     * 
     */
    public static void fundsTransfer(Scanner scanner, UserController loggedInUser) {
    	// TODO
    	System.out.println("+---------------------------+");
    	System.out.println("|       Funds Transfer      |");
    	System.out.println("+---------------------------+");
    	takeInput(scanner, inputOptions.NUMBER);
    }
    
    /**
     * 
     */
    public static void recentTransactions(Scanner scanner, UserController loggedInUser) {
    	// TODO
    	System.out.println("+---------------------------+");
    	System.out.println("| View Last 5 Transactions  |");
    	System.out.println("+---------------------------+");
    	takeInput(scanner, inputOptions.NUMBER);
    }
    
    /**
     * 
     */
    public static void displayInformation(Scanner scanner, UserController loggedInUser) {
    	// TODO
    	System.out.println("+---------------------------+");
    	System.out.println("|    Display Information    |");
    	System.out.println("+---------------------------+");
    	takeInput(scanner, inputOptions.NUMBER);
    }
    
    /**
     * 
     */
    public static void signOut(Scanner scanner, UserController loggedInUser) {
    	// TODO
    	System.out.println("+---------------------------+");
    	System.out.println("|          Sign Out         |");
    	System.out.println("+---------------------------+");
    	takeInput(scanner, inputOptions.NUMBER);
    }

    // Helper Functions:
	private static void takeInput(Scanner scanner, inputOptions inputType) {
    	// TODO
		//int userChoice = Integer.parseInt(scanner.nextLine());
	}
    
}
