package com.cognixia.jumplus.dollarsbankapp.anorthouse.application;

import java.util.Scanner;

import com.cognixia.jumplus.dollarsbankapp.anorthouse.controller.DollarsBankController;
import com.cognixia.jumplus.dollarsbankapp.anorthouse.view.ColoredOutput.ANSI_FONT_COLOR;

public class DollarsBankApplication {
	
	static DollarsBankController loggedInUser = new DollarsBankController();
    
    public static void main( String[] args ) {
    	Scanner scanner = new Scanner(System.in);
    	welcomeScreen(scanner);
	}
    
    
    // Menu Screens:
    public static void welcomeScreen(Scanner scanner) {
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "| DOLLARSBANK Welcomes You! |");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "1. Create New Account");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "2. Login");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "3. Exit\n");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.GREEN, "Enter Choice (1, 2, or 3):");
    	
    	
    	int userInput;
    	try {
    		userInput = takeIntInput(scanner);
    	} catch (Exception e) {
    		loggedInUser.colorOut(ANSI_FONT_COLOR.RED, "Bad Input! Restarting Application.");
    		userInput = 3;
    	}
    	
    	
    	switch (userInput) {
	    	case 1:
	    		createNewAccount(scanner);
	        	loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "");
	    		welcomeScreen(scanner);
	    		break;
	    	case 2:
	    		loginScreen(scanner);
	        	loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "");
	    		welcomeScreen(scanner);
	    		break;
	    	case 3:
	    		loggedInUser.colorOut(ANSI_FONT_COLOR.GREEN, "Thank You for using Dollars Bank!");
	    		break;
	    	default:
	    		loggedInUser.colorOut(ANSI_FONT_COLOR.RED, "No option matching that input, Restarting Welcome Screen.");
	        	loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "");
	    		welcomeScreen(scanner);
    	}
    	
    }
    
    public static void createNewAccount(Scanner scanner) {
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "| Enter New Account Details |");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
    	
    	String[] userInput = new String[4];
    	double amountInput = 0.00;
    	boolean encounterdError = false;
		int counter = 0;
    	
    	while (counter < 5 && !encounterdError) {
    		
    		switch(counter) {
	    		case 0:
	    	    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "Customer Name:");
	    			break;
	    		case 1:
	    	    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "Customer Contact Number:");
	    			break;
	    		case 2:
	    	    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "User Id:");
	    			break;
	    		case 3:
	    	    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "Password:");
	    	    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "Password:");
	    			break;
	    		case 4:
	    	    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "Initial Deposit Amount:");
	    			break;
    		}
    		
    		
    		//input cleaners
    		if (counter == 4) {
        		//specific test for the double
        		try {
        			amountInput = takeDoubleInput(scanner);
        		} catch (Exception e) {
            		encounterdError = true;
        		}
    		} else {
    			//generic test for other inputs
        		try {
            		userInput[counter] = takeStringInput(scanner);
        		} catch (Exception e) {
            		encounterdError = true;
        		}
    		}
    		
    		counter++;
    	}
    	
    	if (encounterdError) {
    		loggedInUser.colorOut(ANSI_FONT_COLOR.RED, "There was an error with your inputs.");
    		loggedInUser.colorOut(ANSI_FONT_COLOR.RED, "Returning to Welcome Screen...");
    	} else {
    		if (loggedInUser.createUser(userInput[2], userInput[3], userInput[0], userInput[1], amountInput)) {
        		loggedInUser.colorOut(ANSI_FONT_COLOR.GREEN, "Successfully created new account!");
        		loggedInUser.colorOut(ANSI_FONT_COLOR.GREEN, "Please login on the Welcome screen.");
        		loggedInUser.colorOut(ANSI_FONT_COLOR.GREEN, "Returning to Welcome Screen...");
    		} else {
        		loggedInUser.colorOut(ANSI_FONT_COLOR.RED, "UserId already taken! Please try again.");
        		loggedInUser.colorOut(ANSI_FONT_COLOR.RED, "Returning to Welcome Screen...");
    		}
    	}
    }
    
    public static void loginScreen(Scanner scanner) {
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "|    Enter Login Details    |");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");

    	//temp variables
    	boolean encounteredError = false;
    	String userId = null, password = null;

    	//takes userId input
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "User Id:");
    	try {
    		userId = takeStringInput(scanner);
    	} catch (Exception e) {
    		encounteredError = true;
    	}

    	//checks for error, then takes password input if no errors
    	if (!encounteredError) {
        	loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "Password:");
        	try {
        		password = takeStringInput(scanner);
        	} catch (Exception e) {
        		encounteredError = true;
        	}
    	}
    	
    	//checks for any errors, then attempts to login user or return to welcome screen
    	if (encounteredError) {
    		loggedInUser.colorOut(ANSI_FONT_COLOR.RED, "There was an error with your inputs.");
    		loggedInUser.colorOut(ANSI_FONT_COLOR.RED, "Returning to Welcome Screen...");
    	} else {
    		if (loggedInUser.attemptLogin(userId, password)) {
        		loggedInUser.colorOut(ANSI_FONT_COLOR.GREEN, "Successfully logged in!");
        		loggedInUser.colorOut(ANSI_FONT_COLOR.GREEN, "Redirecting to Home Screen...");
        		mainScreen(scanner);
    		} else {
        		loggedInUser.colorOut(ANSI_FONT_COLOR.RED, "Invalid Credentials. Try Again!!");
    		}
    	}
    }
    
    public static void mainScreen(Scanner scanner) {
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "|        Home Screen        |");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "1. Deposit Amount");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "1. Withdraw Amount");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "1. Funds Transfer");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "1. View 5 Last Transactions");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "1. Display Account Information");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "6. Sign Out\n");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.GREEN, "Enter Choice (1, 2, 3, 4, 5, or 6):");
    	
    	//checks input
    	int userInput;
    	try {
    		userInput = takeIntInput(scanner);
    	} catch (Exception e) {
    		loggedInUser.colorOut(ANSI_FONT_COLOR.RED, "Bad Input! Restarting Application.");
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
	    		loggedInUser.colorOut(ANSI_FONT_COLOR.RED, "No option matching that input, restarting Home Screen...");
	    		mainScreen(scanner);
    	}
    	
    }
    
    public static void depositAmount(Scanner scanner) {
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "|       Deposit Amount      |");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "Amount to be Deposited:");
    	
    	//checks input
    	boolean encounteredError = false;
    	double userInput = 0.00;
    	try {
    		userInput = takeDoubleInput(scanner);
    	} catch (Exception e) {
    		loggedInUser.colorOut(ANSI_FONT_COLOR.RED, "Bad Input! Returning to Home Screen...");
    		encounteredError = true;
    	}
    	
    	//logic
    	if (!encounteredError) {
    		loggedInUser.addDeposit(userInput);
    		loggedInUser.colorOut(ANSI_FONT_COLOR.GREEN, "Deposited " + userInput + " into your account!");
    	}
    	
    }
    
    public static void withdrawAmount(Scanner scanner) {
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "|      Withdraw Amount      |");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "Amount to be Deposited:");
    	
    	//checks input
    	boolean encounteredError = false;
    	double userInput = 0.00;
    	try {
    		userInput = takeDoubleInput(scanner);
    	} catch (Exception e) {
    		loggedInUser.colorOut(ANSI_FONT_COLOR.RED, "Bad Input! Returning to Home Screen...");
    		encounteredError = true;
    	}
    	
    	//logic
    	if (!encounteredError) {
    		loggedInUser.subtractWithdraw(userInput);
    		loggedInUser.colorOut(ANSI_FONT_COLOR.GREEN, "Withdrew " + userInput + " from your account!");
    	}
    	
    }
    
    public static void fundsTransfer(Scanner scanner) {
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "|       Funds Transfer      |");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "Enter UserId of User to transfer funds to:");
    	
    	
    	//sets up variables
    	String transferUserId = null;
    	double amount = 0.00;
    	boolean encounteredError = false;
    	
    	
    	//tests input
    	try {
    		transferUserId = takeStringInput(scanner);
    	} catch(Exception e) {
    		loggedInUser.colorOut(ANSI_FONT_COLOR.RED, "Bad Input for the other user's id!");
    		encounteredError = true;
    	}
    	
    	
    	//takes second input if no errors already
    	if (!encounteredError) {
        	loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "Enter ammount to transfer:");
        	try {
        		amount = takeDoubleInput(scanner);
        	} catch(Exception e) {
        		loggedInUser.colorOut(ANSI_FONT_COLOR.RED, "Bad Input for the amount to transfer!");
        		encounteredError = true;
        	}
    	}
    	
    	
    	//checks for any errors, then attempts to login user or return to welcome screen
    	if (encounteredError) {
    		loggedInUser.colorOut(ANSI_FONT_COLOR.RED, "Returning to Home Screen...");
    	} else {
    		if (loggedInUser.attemptTransfer(transferUserId, amount)) {
        		loggedInUser.colorOut(ANSI_FONT_COLOR.GREEN, "Successfully transfered funds!");
        		loggedInUser.colorOut(ANSI_FONT_COLOR.GREEN, "Returning to Home Screen...");
    		} else {
        		loggedInUser.colorOut(ANSI_FONT_COLOR.RED, "Unable to find user with that User Id!");
        		loggedInUser.colorOut(ANSI_FONT_COLOR.RED, "Returning to Home Screen...");
    		}
    	}
    }
    
    public static void recentTransactions(Scanner scanner) {
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "| View Last 5 Transactions  |");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
    	loggedInUser.showLastTransactions(5);
    }
    
    public static void displayInformation(Scanner scanner) {
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "|    Display Information    |");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
    	loggedInUser.showUserInfo();
    }
    
    public static void signOut(Scanner scanner) {
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "|          Sign Out         |");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
    	loggedInUser.colorOut(ANSI_FONT_COLOR.RED, "Signing out... Thank you!");
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
}
