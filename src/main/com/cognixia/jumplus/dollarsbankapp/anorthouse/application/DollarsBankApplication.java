package com.cognixia.jumplus.dollarsbankapp.anorthouse.application;

import java.util.Scanner;

import com.cognixia.jumplus.dollarsbankapp.anorthouse.controller.DollarsBankController;
import com.cognixia.jumplus.dollarsbankapp.anorthouse.utility.ColorUtil.ANSI_FONT_COLOR;
import com.cognixia.jumplus.dollarsbankapp.anorthouse.utility.InputParserUtil;
import com.cognixia.jumplus.dollarsbankapp.anorthouse.utility.RegexUtil;

public class DollarsBankApplication {
	
	static DollarsBankController loggedInUser = new DollarsBankController();
	
	public static void main( String[] args ) {
		Scanner scanner = new Scanner(System.in);
		welcomeScreen(scanner);
		scanner.close();
	}
	
	
	// Menu Screens:
	private static void welcomeScreen(Scanner scanner) {
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "| DOLLARSBANK Welcomes You! |");
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "1. Create New Account");
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "2. Login");
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "3. Exit\n");
		loggedInUser.colorOut(ANSI_FONT_COLOR.GREEN, "Enter Choice (1, 2, or 3):");
		
		
		int userInput;
		try {
			userInput = InputParserUtil.parseInt(scanner.nextLine());
		} catch (Exception e) {
			loggedInUser.colorOut(ANSI_FONT_COLOR.RED, "Bad Input! Restarting Welcome Screen.");
			userInput = 0;
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
				loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "");
				loggedInUser.colorOut(ANSI_FONT_COLOR.GREEN, "Thank You for using Dollars Bank!");
				break;
			
			//case 0 is for an input-type error, while default is for just a bad input
			case 0:
				loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "");
				welcomeScreen(scanner);
			default:
				loggedInUser.colorOut(ANSI_FONT_COLOR.RED, "No option matching that input, Reseting Welcome Screen.");
				loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "");
				welcomeScreen(scanner);
		}
		
	}
	
	private static void createNewAccount(Scanner scanner) {
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
				//Customer Name
				case 0:
					loggedInUser.colorOut(ANSI_FONT_COLOR.CYAN, "Customer Name:");
					//standard input logic
					try {
						userInput[counter] = InputParserUtil.parseString(scanner.nextLine());
					} catch (Exception e) {
						encounterdError = true;
					}
					break;
				
				//Contact Number
				case 1:
					loggedInUser.colorOut(ANSI_FONT_COLOR.CYAN, "Customer Contact Number:");
					//standard input logic & Regex
					try {
						userInput[counter] = InputParserUtil.parseString(scanner.nextLine());
						RegexUtil.checkContactNumber(userInput[counter]);
					} catch (Exception e) {
						encounterdError = true;
					}
					break;
				
				//Username / User-Id
				case 2:
					loggedInUser.colorOut(ANSI_FONT_COLOR.CYAN, "User Id:");
					//standard input logic
					try {
						userInput[counter] = InputParserUtil.parseString(scanner.nextLine());
					} catch (Exception e) {
						encounterdError = true;
					}
					break;
				
				//Password
				case 3:
					loggedInUser.colorOut(ANSI_FONT_COLOR.CYAN, "Password: \n"
							+ "- At least 8 chracters with one or more: uppercase letter, lowercase letter, special character, and number. -");
					//standard input logic & Regex
					try {
						userInput[counter] = InputParserUtil.parseString(scanner.nextLine());
						RegexUtil.checkPassword(userInput[counter]);
					} catch (Exception e) {
						encounterdError = true;
					}
					break;
				
				//Initial Deposit
				case 4:
					loggedInUser.colorOut(ANSI_FONT_COLOR.CYAN, "Initial Deposit Amount:");
					//double input logic
					try {
						amountInput = InputParserUtil.parseDouble(scanner.nextLine());
					} catch (Exception e) {
						encounterdError = true;
					}
					break;
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


	private static void loginScreen(Scanner scanner) {
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "");
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "|    Enter Login Details    |");
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");

		//temp variables
		boolean encounteredError = false;
		String userId = null, password = null;

		//takes userId input
		loggedInUser.colorOut(ANSI_FONT_COLOR.CYAN, "User Id:");
		try {
			userId = InputParserUtil.parseString(scanner.nextLine());
		} catch (Exception e) {
			encounteredError = true;
		}

		//checks for error, then takes password input if no errors
		if (!encounteredError) {
			loggedInUser.colorOut(ANSI_FONT_COLOR.CYAN, "Password:");
			try {
				password = InputParserUtil.parseString(scanner.nextLine());
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
	
	private static void mainScreen(Scanner scanner) {
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "");
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "|        Home Screen        |");
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "1. Deposit Amount");
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "2. Withdraw Amount");
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "3. Funds Transfer");
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "4. View 5 Last Transactions");
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "5. Display Account Information");
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "6. Sign Out\n");
		loggedInUser.colorOut(ANSI_FONT_COLOR.GREEN, "Enter Choice (1, 2, 3, 4, 5, or 6):");
		
		//checks input
		int userInput;
		try {
			userInput = InputParserUtil.parseInt(scanner.nextLine());
		} catch (Exception e) {
			loggedInUser.colorOut(ANSI_FONT_COLOR.RED, "Bad Input! Restarting Home Screen.");
			userInput = 0;
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
				signOut(scanner);
				break;
				
			//case 0 is for an input-type error, while default is for just a bad input
			case 0:
				loggedInUser.colorOut(ANSI_FONT_COLOR.BLACK, "");
				welcomeScreen(scanner);
			default:
				loggedInUser.colorOut(ANSI_FONT_COLOR.RED, "No option matching that input, restarting Home Screen...");
				mainScreen(scanner);
		}
		
	}
	
	private static void depositAmount(Scanner scanner) {
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "");
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "|       Deposit Amount      |");
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
		loggedInUser.colorOut(ANSI_FONT_COLOR.CYAN, "Amount to be Deposited:");
		
		//checks input
		boolean encounteredError = false;
		double userInput = 0.00;
		try {
			userInput = InputParserUtil.parseDouble(scanner.nextLine());
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
	
	private static void withdrawAmount(Scanner scanner) {
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "");
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "|      Withdraw Amount      |");
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
		loggedInUser.colorOut(ANSI_FONT_COLOR.CYAN, "Amount to be Deposited:");
		
		//checks input
		boolean encounteredError = false;
		double userInput = 0.00;
		try {
			userInput = InputParserUtil.parseDouble(scanner.nextLine());
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
	
	private static void fundsTransfer(Scanner scanner) {
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "");
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "|       Funds Transfer      |");
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
		loggedInUser.colorOut(ANSI_FONT_COLOR.CYAN, "Enter UserId of User to transfer funds to:");
		
		
		//sets up variables
		String transferUserId = null;
		double amount = 0.00;
		boolean encounteredError = false;
		
		
		//tests input
		try {
			transferUserId = InputParserUtil.parseString(scanner.nextLine());
		} catch(Exception e) {
			loggedInUser.colorOut(ANSI_FONT_COLOR.RED, "Bad Input for the other user's id!");
			encounteredError = true;
		}
		
		
		//takes second input if no errors already
		if (!encounteredError) {
			loggedInUser.colorOut(ANSI_FONT_COLOR.CYAN, "Enter ammount to transfer:");
			try {
				amount = InputParserUtil.parseDouble(scanner.nextLine());
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
	
	private static void recentTransactions(Scanner scanner) {
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "");
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "| View Last 5 Transactions  |");
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
		loggedInUser.showLastTransactions(5);
	}
	
	private static void displayInformation(Scanner scanner) {
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "");
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "|    Display Information    |");
		loggedInUser.colorOut(ANSI_FONT_COLOR.BLUE, "+---------------------------+");
		loggedInUser.showUserInfo();
	}
	
	private static void signOut(Scanner scanner) {
		loggedInUser.colorOut(ANSI_FONT_COLOR.RED, "== Signing out... Thank you! ==");
		loggedInUser.setCurrentUser(null);
	}
}
