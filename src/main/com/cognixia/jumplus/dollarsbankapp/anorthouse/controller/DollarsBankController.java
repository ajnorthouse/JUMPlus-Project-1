package com.cognixia.jumplus.dollarsbankapp.anorthouse.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.cognixia.jumplus.dollarsbankapp.anorthouse.model.User;
import com.cognixia.jumplus.dollarsbankapp.anorthouse.utility.ColorUtil;
import com.cognixia.jumplus.dollarsbankapp.anorthouse.utility.ConsoleUtil;
import com.cognixia.jumplus.dollarsbankapp.anorthouse.utility.InputParserUtil;
import com.cognixia.jumplus.dollarsbankapp.anorthouse.utility.RegexUtil;
import com.cognixia.jumplus.dollarsbankapp.anorthouse.view.UserView;
import com.cognixia.jumplus.dollarsbankapp.anorthouse.utility.ColorUtil.ANSI_FONT_COLOR;


public class DollarsBankController {
	
	static ArrayList<User> users = new ArrayList<User>();
	private UserController uController = new UserController();
	private UserView uView = new UserView();
	private User currentUser = null;
	
	
	// account methods
	
	public boolean attemptLogin(String userId, String password) {
		
		//for loop to iterate over all users
		//	- not enhanced because users can be empty at this point
		for (int counter = 0; counter < users.size(); counter++) {
			
			//checks for matching userId
			if (uController.getUsername(users.get(counter)).equals(userId)) {
				
				//then checks if the passwords are equal
				if (users.get(counter).getPassword().equals(password)) {
					currentUser = users.get(counter);
					return true;
				}
				
				//this breaks the loop, as a matching userId was found
				return false;
			}
		}
		
		return false;
	}
	
	public void signOut() {
		this.currentUser = null;
	}
	
	public boolean createUser(String userId, String password, String name, String contactNumber, double balance) {
		
		//first checks for any matching userId
		for (int counter = 0; counter < users.size(); counter++) {
			if (uController.getUsername(users.get(counter)).equals(userId)) {
				return false;
			}
		}
		
		//then just creates the user
		User newUser = new User(userId, password, name, contactNumber, balance);
		uController.updateLog(newUser, "Created Account with initial balance of: $" + balance + ".");
		users.add(newUser);
		
		return true;
	}
	
	
	// deposit methods
	
	public void addDeposit(double userInput) {
		double balance = uController.getBalance(currentUser);
		uController.setBalance(currentUser, balance + userInput);
		
		//update log
		String message = "Deposited $" + userInput + " to bring Balance to: $" + balance + ".";
		uController.updateLog(currentUser, message);
	}
	
	
	// withdrawal methods
	
	public void subtractWithdrawal(double userInput) throws Exception {
		double balance = uController.getBalance(currentUser);
		
		//checks if the account has enough funds
		if (balance < userInput) {
			throw new Exception("Not enough funds!");
		}
		
		//update log
		String message = "Withdrew $" + userInput + " to bring Balance to: $" + balance + ".";
		uController.updateLog(currentUser, message);
	}
	
	
	// transfer methods
	
	public void attemptTransfer(String transferUserId, double amount) throws Exception {
		//temp user for the transfer
		User tempUser = null;
		
		//checks if the user is attempting to transfer funds to themselves
		if (uController.getUsername(currentUser).equals(transferUserId)) {
			throw new Exception("Can't transfer to yourself!");
		}
		
		//then checks for any matching userId
		for (int counter = 0; counter < users.size(); counter++) {
			
			//stops loop if a matching userId is found
			if (uController.getUsername(users.get(counter)).equals(transferUserId)) {
				tempUser = users.get(counter);
				break;
			}
			
			//returns false if no matching userIds were found
			if (counter - 1 == users.size()) {
				throw new Exception("Username not found!");
			}
		}
		
		//subtracts withdrawal and then adds deposit
		transferWithdrawal(currentUser, uController.getUsername(tempUser), amount);
		transferDeposit(tempUser, uController.getUsername(currentUser), amount);
	}
	
	public void transferDeposit(User user, String transferUserId, double userInput) {
		double balance = uController.getBalance(currentUser);
		uController.setBalance(currentUser, balance + userInput);
		
		//update log
		String message = "Deposited $" + userInput + " to bring Balance to: $" + balance + ".";
		uController.updateLog(currentUser, message);
	}
	
	public void transferWithdrawal(User user, String transferUserId, double userInput) throws Exception {
		double balance = uController.getBalance(currentUser);
		
		//checks if the account has enough funds
		if (balance < userInput) {
			throw new Exception("Not enough funds!");
		}
		
		//update log
		String message = "Transfered $" + userInput + " to " + transferUserId + ", Balance now: $" + balance + ".";
		uController.updateLog(currentUser, message);
	}


	
	
	//Screen Methods
	
	public int welcomeScreen(Scanner scanner) {
		
		ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.GREEN, "Enter Choice (1, 2, or 3):"));
		
		
		int userInput;
		try {
			userInput = InputParserUtil.parseInt(scanner.nextLine());
		} catch (Exception e) {
			ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.RED, "Bad Input! Restarting Welcome Screen."));
			userInput = 0;
		}
		
		return userInput;
	}

	
	public void createNewAccount(Scanner scanner) {
		
		
		String[] userInput = new String[4];
		double amountInput = 0.00;
		boolean encounterdError = false;
		int counter = 0;
		
		while (counter < 5 && !encounterdError) {
			
			switch(counter) {
				//Customer Name
				case 0:
					ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.CYAN, "Customer Name:"));
					//standard input logic
					try {
						userInput[counter] = InputParserUtil.parseString(scanner.nextLine());
					} catch (Exception e) {
						encounterdError = true;
					}
					break;
				
				//Contact Number
				case 1:
					ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.CYAN, "Customer Contact Number:"));
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
					ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.CYAN, "User Id:"));
					//standard input logic
					try {
						userInput[counter] = InputParserUtil.parseString(scanner.nextLine());
					} catch (Exception e) {
						encounterdError = true;
					}
					break;
				
				//Password
				case 3:
					ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.CYAN, "Password: \n"
							+ "- At least 8 chracters with one or more: uppercase letter, lowercase letter, special character, and number. -"));
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
					ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.CYAN, "Initial Deposit Amount:"));
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
			ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.RED, "There was an error with your inputs."));
			ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.RED, "Returning to Welcome Screen..."));
		} else {
			if (createUser(userInput[2], userInput[3], userInput[0], userInput[1], amountInput)) {
				ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.GREEN, "Successfully created new account!"));
				ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.GREEN, "Please login on the Welcome screen."));
			} else {
				ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.RED, "UserId already taken! Please try again."));
				ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.RED, "Returning to Welcome Screen..."));
			}
		}
	}

	
	public boolean loginScreen(Scanner scanner) {
		

		//temp variables
		boolean encounteredError = false;
		String userId = null, password = null;

		//takes userId input
		ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.CYAN, "User Id:"));
		try {
			userId = InputParserUtil.parseString(scanner.nextLine());
		} catch (Exception e) {
			encounteredError = true;
		}

		//checks for error, then takes password input if no errors
		if (!encounteredError) {
			ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.CYAN, "Password:"));
			try {
				password = InputParserUtil.parseString(scanner.nextLine());
			} catch (Exception e) {
				encounteredError = true;
			}
		}
		
		//checks for any errors, then attempts to login user or return to welcome screen
		if (encounteredError) {
			ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.RED, "There was an error with your inputs."));
			ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.RED, "Returning to Welcome Screen..."));
			return false;
		} else {
			if (attemptLogin(userId, password)) {
				ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.GREEN, "Successfully logged in!"));
				ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.GREEN, "Redirecting to Home Screen..."));
				return true;
			} else {
				ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.RED, "Invalid Credentials. Try Again!!"));
				return false;
			}
		}
	}

	
	public int mainScreen(Scanner scanner) {
		
		ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.GREEN, "Enter Choice (1, 2, 3, 4, 5, or 6):"));
		
		//checks input
		int userInput;
		try {
			userInput = InputParserUtil.parseInt(scanner.nextLine());
		} catch (Exception e) {
			ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.RED, "Bad Input! Restarting Home Screen."));
			userInput = 0;
		}
		
		return userInput;
	}

	
	public void depositAmount(Scanner scanner) {
		
		ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.CYAN, "Amount to be Deposited:"));
		
		//checks input
		boolean encounteredError = false;
		double userInput = 0.00;
		try {
			userInput = InputParserUtil.parseDouble(scanner.nextLine());
		} catch (Exception e) {
			ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.RED, "Bad Input! Returning to Home Screen..."));
			encounteredError = true;
		}
		
		//logic
		if (!encounteredError) {
			addDeposit(userInput);
			ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.GREEN, "Deposited " + userInput + " into your account!"));
		}
	}

	
	public void withdrawAmount(Scanner scanner) {
		
		ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.CYAN, "Amount to be Deposited:"));
		
		//checks input
		boolean encounteredError = false;
		double userInput = 0.00;
		try {
			userInput = InputParserUtil.parseDouble(scanner.nextLine());
		} catch (Exception e) {
			ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.RED, "Bad Input! Returning to Home Screen..."));
			encounteredError = true;
		}
		
		//logic
		if (!encounteredError) {
			try {
				subtractWithdrawal(userInput);
				ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.GREEN, "Withdrew " + userInput + " from your account!"));
			} catch (Exception e) {
				ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.RED, e.getMessage()));
			}
		}
	}

	
	public void fundsTransfer(Scanner scanner) {
		
		ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.CYAN, "Enter UserId of User to transfer funds to:"));
		
		
		//sets up variables
		String transferUserId = null;
		double amount = 0.00;
		boolean encounteredError = false;
		
		
		//tests input
		try {
			transferUserId = InputParserUtil.parseString(scanner.nextLine());
		} catch(Exception e) {
			ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.RED, "Bad Input for the other user's id!"));
			encounteredError = true;
		}
		
		
		//takes second input if no errors already
		if (!encounteredError) {
			ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.CYAN, "Enter ammount to transfer:"));
			try {
				amount = InputParserUtil.parseDouble(scanner.nextLine());
			} catch(Exception e) {
				ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.RED, "Bad Input for the amount to transfer!"));
				encounteredError = true;
			}
		}
		
		
		//checks for any errors, then attempts to login user or return to welcome screen
		if (!encounteredError) {
			try {
				attemptTransfer(transferUserId, amount);
				ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.GREEN, "Successfully transfered funds!"));
			} catch (Exception e) {
				ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.RED, e.getMessage()));
			}
		}
	}

	
	public void recentTransactions(int numOfTransactions) {
		ConsoleUtil.printStatement(uView.showLastTransactions(currentUser, numOfTransactions));
	}

	
	public void getUserDetails() {
		ConsoleUtil.printStatement(uView.getUserDetails(currentUser));
	}
	
}
