package com.cognixia.jumplus.dollarsbankapp.anorthouse.application;

import java.util.Scanner;

import com.cognixia.jumplus.dollarsbankapp.anorthouse.controller.UserController;

public class DollarsBankApplication {
	
	static UserController loggedInUser = new UserController();
	enum COLOR {
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
    	colorOut(COLOR.BLUE, "+---------------------------+");
    	colorOut(COLOR.BLUE, "| DOLLARSBANK Welcomes You! |");
    	colorOut(COLOR.BLUE, "+---------------------------+");
    	colorOut(COLOR.BLACK, "1. Create New Account");
    	colorOut(COLOR.BLACK, "2. Login");
    	colorOut(COLOR.BLACK, "3. Exit\n");
    	colorOut(COLOR.GREEN, "Enter Choice (1, 2, or 3):");
    	
    	
    	int userInput;
    	try {
    		userInput = takeIntInput(scanner);
    	} catch (Exception e) {
    		colorOut(COLOR.RED, "Bad Input! Restarting Application.");
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
	    		colorOut(COLOR.GREEN, "Thank You! Restarting Application.");
	    		break;
	    	default:
	    		colorOut(COLOR.RED, "No option matching that input, Restarting Application.");
    	}
    	
    	colorOut(COLOR.BLACK, "");
		welcomeScreen(scanner);
    }
    
    /**
     * 
     */
    public static void createNewAccount(Scanner scanner) {
    	colorOut(COLOR.BLUE, "");
    	colorOut(COLOR.BLUE, "+---------------------------+");
    	colorOut(COLOR.BLUE, "| Enter New Account Details |");
    	colorOut(COLOR.BLUE, "+---------------------------+");
    	
    	String[] userInput = new String[6];
    	boolean encounterdError = false;
		int counter = 0;
    	
    	while (counter < 6 && !encounterdError) {
    		
    		switch(counter) {
	    		case 0:
	    	    	colorOut(COLOR.BLACK, "Customer Name:");
	    			break;
	    		case 1:
//	    	    	colorOut(COLOR.BLACK, "Customer Address:");
	    			break;
	    		case 2:
	    	    	colorOut(COLOR.BLACK, "Customer Contact Number:");
	    			break;
	    		case 3:
	    	    	colorOut(COLOR.BLACK, "User Id:");
	    			break;
	    		case 4:
	    	    	colorOut(COLOR.BLACK, "Password:");
	    	    	colorOut(COLOR.BLACK, "Password:");
	    			break;
	    		case 5:
	    	    	colorOut(COLOR.BLACK, "Initial Deposit Amount:");
	    			break;
    		}
    		
    		try {
        		userInput[counter] = takeStringInput(scanner);
    		} catch (Exception e) {
        		encounterdError = true;
    		}
    		
    		counter++;
    	}
    	
    	if (encounterdError) {
    		colorOut(COLOR.RED, "There was an error with your inputs.");
    		colorOut(COLOR.RED, "Returning to Welcome Screen...");
    	} else {
    		if (loggedInUser.createUser(userInput[3], userInput[4], userInput[0], userInput[2], Double.parseDouble(userInput[5]))) {
        		colorOut(COLOR.GREEN, "Successfully created new account!");
        		colorOut(COLOR.GREEN, "Please login on the Welcome screen.");
        		colorOut(COLOR.GREEN, "Returning to Welcome Screen...");
    		} else {
        		colorOut(COLOR.RED, "UserId already taken! Please try again.");
        		colorOut(COLOR.RED, "Returning to Welcome Screen...");
    		}
    	}
    }
    
    /**
     * 
     */
    public static void loginScreen(Scanner scanner) {
    	colorOut(COLOR.BLUE, "");
    	colorOut(COLOR.BLUE, "+---------------------------+");
    	colorOut(COLOR.BLUE, "|    Enter Login Details    |");
    	colorOut(COLOR.BLUE, "+---------------------------+");

    	//temp variables
    	boolean encounteredError = false;
    	String userId = null, password = null;

    	//takes userId input
    	colorOut(COLOR.BLACK, "User Id:");
    	try {
    		userId = takeStringInput(scanner);
    	} catch (Exception e) {
    		encounteredError = true;
    	}

    	//checks for error, then takes password input if no errors
    	if (!encounteredError) {
        	colorOut(COLOR.BLACK, "Password:");
        	try {
        		password = takeStringInput(scanner);
        	} catch (Exception e) {
        		encounteredError = true;
        	}
    	}
    	
    	//checks for any errors, then attempts to login user or return to welcome screen
    	if (encounteredError) {
    		colorOut(COLOR.RED, "There was an error with your inputs.");
    		colorOut(COLOR.RED, "Returning to Welcome Screen...");
    	} else {
    		if (loggedInUser.attemptLogin(userId, password)) {
        		colorOut(COLOR.GREEN, "Successfully logged in!");
        		colorOut(COLOR.GREEN, "Redirecting to Home Screen...");
        		mainScreen(scanner);
    		} else {
        		colorOut(COLOR.RED, "Invalid Credentials. Try Again!!");
    		}
    	}
    }

	/**
     * 
     */
    public static void mainScreen(Scanner scanner) {
    	colorOut(COLOR.BLUE, "");
    	colorOut(COLOR.BLUE, "+---------------------------+");
    	colorOut(COLOR.BLUE, "|        Home Screen        |");
    	colorOut(COLOR.BLUE, "+---------------------------+");
    	colorOut(COLOR.BLACK, "1. Deposit Amount");
    	colorOut(COLOR.BLACK, "1. Withdraw Amount");
    	colorOut(COLOR.BLACK, "1. Funds Transfer");
    	colorOut(COLOR.BLACK, "1. View 5 Last Transactions");
    	colorOut(COLOR.BLACK, "1. Display Account Information");
    	colorOut(COLOR.BLACK, "6. Sign Out\n");
    	colorOut(COLOR.GREEN, "Enter Choice (1, 2, 3, 4, 5, or 6):");
    	
    	//checks input
    	int userInput;
    	try {
    		userInput = takeIntInput(scanner);
    	} catch (Exception e) {
    		colorOut(COLOR.RED, "Bad Input! Restarting Application.");
    		userInput = 6;
    	}
    	
    	//switch case on deciding where to send user based on input
    	switch (userInput) {
	    	case 1:
	    		depositAmount(scanner);
	    		mainScreen(scanner);
	    		break;
	    	case 2:
	    		withdrawAmount(scanner);
	    		mainScreen(scanner);
	    		break;
	    	case 3:
	    		fundsTransfer(scanner);
	    		mainScreen(scanner);
	    		break;
	    	case 4:
	    		recentTransactions(scanner);
	    		mainScreen(scanner);
	    		break;
	    	case 5:
	    		displayInformation(scanner);
	    		mainScreen(scanner);
	    		break;
	    	case 6:
	    		break;
	    	default:
	    		colorOut(COLOR.RED, "No option matching that input, restarting Home Screen...");
	    		mainScreen(scanner);
    	}
    	
    }
    
    /**
     * 
     */
    public static void depositAmount(Scanner scanner) {
    	colorOut(COLOR.BLUE, "");
    	colorOut(COLOR.BLUE, "+---------------------------+");
    	colorOut(COLOR.BLUE, "|       Deposit Amount      |");
    	colorOut(COLOR.BLUE, "+---------------------------+");
    	colorOut(COLOR.BLACK, "Amount to be Deposited:");
    	
    	//checks input
    	boolean encounteredError = false;
    	double userInput = 0.00;
    	try {
    		userInput = takeDoubleInput(scanner);
    	} catch (Exception e) {
    		colorOut(COLOR.RED, "Bad Input! Returning to Home Screen...");
    		encounteredError = true;
    	}
    	
    	//logic
    	if (!encounteredError) {
    		loggedInUser.addDeposit(userInput);
    		colorOut(COLOR.GREEN, "Deposited " + userInput + " into your account!");
    	}
    	
    }
    
    /**
     * 
     */
    public static void withdrawAmount(Scanner scanner) {
    	colorOut(COLOR.BLUE, "");
    	colorOut(COLOR.BLUE, "+---------------------------+");
    	colorOut(COLOR.BLUE, "|      Withdraw Amount      |");
    	colorOut(COLOR.BLUE, "+---------------------------+");
    	colorOut(COLOR.BLACK, "Amount to be Deposited:");
    	
    	//checks input
    	boolean encounteredError = false;
    	double userInput = 0.00;
    	try {
    		userInput = takeDoubleInput(scanner);
    	} catch (Exception e) {
    		colorOut(COLOR.RED, "Bad Input! Returning to Home Screen...");
    		encounteredError = true;
    	}
    	
    	//logic
    	if (!encounteredError) {
    		loggedInUser.subtractWithdraw(userInput);
    		colorOut(COLOR.GREEN, "Withdrew " + userInput + " from your account!");
    	}
    	
    }
    
    /**
     * 
     */
    public static void fundsTransfer(Scanner scanner) {
    	colorOut(COLOR.BLUE, "");
    	colorOut(COLOR.BLUE, "+---------------------------+");
    	colorOut(COLOR.BLUE, "|       Funds Transfer      |");
    	colorOut(COLOR.BLUE, "+---------------------------+");
    	colorOut(COLOR.BLACK, "Enter UserId of User to transfer funds to:");
    	
    	
    	//sets up variables
    	String transferUserId = null;
    	double amount = 0.00;
    	boolean encounteredError = false;
    	
    	
    	//tests input
    	try {
    		transferUserId = takeStringInput(scanner);
    	} catch(Exception e) {
    		colorOut(COLOR.RED, "Bad Input for the other user's id!");
    		encounteredError = true;
    	}
    	
    	
    	//takes second input if no errors already
    	if (!encounteredError) {
        	colorOut(COLOR.BLACK, "Enter ammount to transfer:");
        	try {
        		amount = takeDoubleInput(scanner);
        	} catch(Exception e) {
        		colorOut(COLOR.RED, "Bad Input for the amount to transfer!");
        		encounteredError = true;
        	}
    	}
    	
    	
    	//checks for any errors, then attempts to login user or return to welcome screen
    	if (encounteredError) {
    		colorOut(COLOR.RED, "Returning to Home Screen...");
    	} else {
    		if (loggedInUser.attemptTransfer(transferUserId, amount)) {
        		colorOut(COLOR.GREEN, "Successfully transfered funds!");
        		colorOut(COLOR.GREEN, "Returning to Home Screen...");
    		} else {
        		colorOut(COLOR.RED, "Unable to find user with that User Id!");
        		colorOut(COLOR.RED, "Returning to Home Screen...");
    		}
    	}
    }
    
    /**
     * 
     */
    public static void recentTransactions(Scanner scanner) {
    	colorOut(COLOR.BLUE, "");
    	colorOut(COLOR.BLUE, "+---------------------------+");
    	colorOut(COLOR.BLUE, "| View Last 5 Transactions  |");
    	colorOut(COLOR.BLUE, "+---------------------------+");
    	loggedInUser.showLastTransactions(5);
    }
    
    /**
     * 
     */
    public static void displayInformation(Scanner scanner) {
    	colorOut(COLOR.BLUE, "");
    	colorOut(COLOR.BLUE, "+---------------------------+");
    	colorOut(COLOR.BLUE, "|    Display Information    |");
    	colorOut(COLOR.BLUE, "+---------------------------+");
    	loggedInUser.showUserInfo();
    }
    
    /**
     * 
     */
    public static void signOut(Scanner scanner) {
    	colorOut(COLOR.BLUE, "");
    	colorOut(COLOR.BLUE, "+---------------------------+");
    	colorOut(COLOR.BLUE, "|          Sign Out         |");
    	colorOut(COLOR.BLUE, "+---------------------------+");
    	colorOut(COLOR.RED, "Signing out... Thank you!");
    	loggedInUser.setCurrentUser(null);
    }

    
    // Helper Functions:
	private static int takeIntInput(Scanner scanner) throws Exception {
		String tempString = scanner.next();
		int tempInt = 0;
		
		try {
			//attempts to parse input
			tempString = tempString.trim().toLowerCase();
			tempInt = Integer.parseInt(tempString);

			//then checks for non=negative
			if (tempInt < 0) {
				throw new Exception();
			}
		//throws generic exception to allow for caller to handle issue
		} catch (Exception e) {
			throw e;
		}
		
		//returns parsed input
		return tempInt;
	}
	private static double takeDoubleInput(Scanner scanner) throws Exception {
		String tempString = scanner.next();
		double tempDouble = 0.00;
		
		try {
			//attempts to parse input
			tempString = tempString.trim().toLowerCase();
			tempDouble = Double.parseDouble(tempString);

			//then checks for non=negative
			if (tempDouble < 0.00) {
				throw new Exception();
			}
		//throws generic exception to allow for caller to handle issue
		} catch (Exception e) {
			throw e;
		}
		
		//returns parsed input
		return tempDouble;
	}
	private static String takeStringInput(Scanner scanner) throws Exception {
		String tempString = scanner.next();
		
		try {
			//attempts to parse input
			tempString = tempString.trim().toLowerCase();
			
			//checks for empty string
			if (tempString.equals("")) {
				throw new Exception();
			}
		//throws generic exception to allow for caller to handle issue
		} catch (Exception e) {
			throw e;
		}
		
		//returns parsed input
		return tempString;
	}
    private static void colorOut(COLOR color, String message) {
    	System.out.println(message);
    }
}
