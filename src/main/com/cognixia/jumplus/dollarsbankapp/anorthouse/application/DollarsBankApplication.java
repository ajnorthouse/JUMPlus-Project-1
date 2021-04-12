package com.cognixia.jumplus.dollarsbankapp.anorthouse.application;

import java.util.ArrayList;
import java.util.Scanner;

import com.cognixia.jumplus.dollarsbankapp.anorthouse.controller.UserController;
import com.cognixia.jumplus.dollarsbankapp.anorthouse.model.User;

public class DollarsBankApplication {
	
	static ArrayList<User> users = new ArrayList<User>();
	static UserController loggedInUser = new UserController(null, new UserView());
	enum Color {
		RED, ORANGE, YELLOW, GREEN, BLUE, PURPLE, BLACK
	}
	
	/**
	 * 
	 * @param args
	 */
    public static void main( String[] args ) {
    	Scanner scanner = new Scanner(System.in);
    	welcomeScreen(scanner);
	}
    
    // Menu Screens:
    /**
     * 
     * @param scanner
     * @param loggedInUser
     */
    public static void welcomeScreen(Scanner scanner) {
    	colorOut(Color.BLUE, "+---------------------------+");
    	colorOut(Color.BLUE, "| DOLLARSBANK Welcomes You! |");
    	colorOut(Color.BLUE, "+---------------------------+");
    	colorOut(Color.BLACK, "1. Create New Account");
    	colorOut(Color.BLACK, "2. Login");
    	colorOut(Color.BLACK, "3. Exit\n");
    	colorOut(Color.GREEN, "Enter Choice (1, 2, or 3):");
    	
    	
    	int userInput;
    	try {
    		userInput = takeIntInput(scanner);
    	} catch (Error e) {
    		colorOut(Color.RED, "Bad Input! Restarting Application.");
    		userInput = 3;
    	}
    	
    	
    	switch (userInput) {
	    	case 1:
	    		createNewAccount(scanner);
	    		break;
	    	case 2:
	    		loginScreen(scanner);
	    		break;
	    	case 3:
	    		welcomeScreen(scanner);
	    		break;
    	}
    }
    
    /**
     * 
     */
    public static void createNewAccount(Scanner scanner) {
    	colorOut(Color.BLUE, "+---------------------------+");
    	colorOut(Color.BLUE, "| Enter New Account Details |");
    	colorOut(Color.BLUE, "+---------------------------+");
    	
    	String[] userInput = new String[6];
    	boolean encounterdError = false;
		int counter = 0;
    	
    	while (counter < 6 && !encounterdError) {
    		
    		switch(counter) {
	    		case 0:
	    	    	colorOut(Color.BLACK, "Customer Name:");
	    			break;
	    		case 1:
	    	    	colorOut(Color.BLACK, "Customer Address:");
	    			break;
	    		case 2:
	    	    	colorOut(Color.BLACK, "Customer Contact Number:");
	    			break;
	    		case 3:
	    	    	colorOut(Color.BLACK, "User Id:");
	    			break;
	    		case 4:
	    	    	colorOut(Color.BLACK, "Password:");
	    	    	colorOut(Color.BLACK, "Password:");
	    			break;
	    		case 5:
	    	    	colorOut(Color.BLACK, "Initial Deposit Amount:");
	    			break;
    		}
    		
    		try {
        		userInput[counter] = takeStringInput(scanner);
    		} catch (Error e) {
        		encounterdError = true;
    		}
    		
    		counter++;
    	}
    	
    	if (encounterdError) {
    		colorOut(Color.RED, "There was an error with your inputs.");
    		colorOut(Color.RED, "Returning to Welcome Screen...");
    	} else {
    		users.add(new User(userInput[3], userInput[4], userInput[0], userInput[2], Double.parseDouble(userInput[5])));
    		colorOut(Color.GREEN, "Successfully created new account!");
    		colorOut(Color.GREEN, "Please login on the Welcome screen.");
    		colorOut(Color.GREEN, "Returning to Welcome Screen...");
    	}
    	
    	welcomeScreen(scanner);
    }
    
    /**
     * 
     */
    public static void loginScreen(Scanner scanner) {
    	// TODO
    	colorOut(Color.BLUE, "+---------------------------+");
    	colorOut(Color.BLUE, "|    Enter Login Details    |");
    	colorOut(Color.BLUE, "+---------------------------+");
    	takeStringInput(scanner);
    }

    /**
     * 
     */
    public static void mainScreen(Scanner scanner) {
    	// TODO
    	colorOut(Color.BLUE, "+---------------------------+");
    	colorOut(Color.BLUE, "|        Home Screen        |");
    	colorOut(Color.BLUE, "+---------------------------+");
    	takeIntInput(scanner);
    }
    
    /**
     * 
     */
    public static void depositAmount(Scanner scanner) {
    	// TODO
    	colorOut(Color.BLUE, "+---------------------------+");
    	colorOut(Color.BLUE, "|       Deposit Amount      |");
    	colorOut(Color.BLUE, "+---------------------------+");
    	takeIntInput(scanner);
    }
    
    /**
     * 
     */
    public static void withdrawAmount(Scanner scanner) {
    	// TODO
    	colorOut(Color.BLUE, "+---------------------------+");
    	colorOut(Color.BLUE, "|      Withdraw Amount      |");
    	colorOut(Color.BLUE, "+---------------------------+");
    	takeIntInput(scanner);
    }
    
    /**
     * 
     */
    public static void fundsTransfer(Scanner scanner) {
    	// TODO
    	colorOut(Color.BLUE, "+---------------------------+");
    	colorOut(Color.BLUE, "|       Funds Transfer      |");
    	colorOut(Color.BLUE, "+---------------------------+");
    	takeIntInput(scanner);
    }
    
    /**
     * 
     */
    public static void recentTransactions(Scanner scanner) {
    	// TODO
    	colorOut(Color.BLUE, "+---------------------------+");
    	colorOut(Color.BLUE, "| View Last 5 Transactions  |");
    	colorOut(Color.BLUE, "+---------------------------+");
    }
    
    /**
     * 
     */
    public static void displayInformation(Scanner scanner) {
    	// TODO
    	colorOut(Color.BLUE, "+---------------------------+");
    	colorOut(Color.BLUE, "|    Display Information    |");
    	colorOut(Color.BLUE, "+---------------------------+");
    }
    
    /**
     * 
     */
    public static void signOut(Scanner scanner) {
    	// TODO
    	colorOut(Color.BLUE, "+---------------------------+");
    	colorOut(Color.BLUE, "|          Sign Out         |");
    	colorOut(Color.BLUE, "+---------------------------+");
    }

    // Helper Functions:
	private static int takeIntInput(Scanner scanner) {
    	// TODO
		//int userChoice = Integer.parseInt(scanner.nextLine());
		return 3;
	}
	private static double takeDoubleInput(Scanner scanner) {
    	// TODO
		//int userChoice = Integer.parseInt(scanner.nextLine());
		return 10.0;
	}
	private static String takeStringInput(Scanner scanner) {
    	// TODO
		//int userChoice = Integer.parseInt(scanner.nextLine());
		return "foob";
	}
    private static void colorOut(Color color, String message) {
    	System.out.println(message);
    }
}
