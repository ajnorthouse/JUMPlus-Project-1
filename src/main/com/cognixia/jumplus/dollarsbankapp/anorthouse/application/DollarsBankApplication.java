package com.cognixia.jumplus.dollarsbankapp.anorthouse.application;

import java.util.Scanner;

import com.cognixia.jumplus.dollarsbankapp.anorthouse.controller.DollarsBankController;
import com.cognixia.jumplus.dollarsbankapp.anorthouse.utility.ColorUtil.ANSI_FONT_COLOR;
import com.cognixia.jumplus.dollarsbankapp.anorthouse.utility.ColorUtil;
import com.cognixia.jumplus.dollarsbankapp.anorthouse.utility.ConsoleUtil;
import com.cognixia.jumplus.dollarsbankapp.anorthouse.view.DollarsBankView;

public class DollarsBankApplication {
	
	static DollarsBankController controller = new DollarsBankController();
	static DollarsBankView view = new DollarsBankView();
	
	// main runner / starter
	public static void main( String[] args ) {
		Scanner scanner = new Scanner(System.in);
		welcomeScreen(scanner);
		scanner.close();
	}
	
	
	// Menu Screens:
	private static void welcomeScreen(Scanner scanner) {
		view.welcomeScreen();
		int userInput = controller.welcomeScreen(scanner);
		
		switch (userInput) {
			case 1:
				createNewAccount(scanner);
				ConsoleUtil.printStatement(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLACK, ""));
				welcomeScreen(scanner);
				break;
			case 2:
				loginScreen(scanner);
				ConsoleUtil.printStatement(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLACK, ""));
				welcomeScreen(scanner);
				break;
			case 3:
				ConsoleUtil.printStatement(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLACK, ""));
				ConsoleUtil.printStatement(ColorUtil.combineAnsi(ANSI_FONT_COLOR.GREEN, "Thank You for using Dollars Bank!"));
				break;
			
			//case 0 is for an input-type error, while default is for just a bad input
			case 0:
				ConsoleUtil.printStatement(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLACK, ""));
				welcomeScreen(scanner);
			default:
				ConsoleUtil.printStatement(ColorUtil.combineAnsi(ANSI_FONT_COLOR.RED, "No option matching that input, Reseting Welcome Screen."));
				ConsoleUtil.printStatement(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLACK, ""));
				welcomeScreen(scanner);
		}
	}
	
	private static void createNewAccount(Scanner scanner) {
		view.createNewAccount();
		controller.createNewAccount(scanner);
	}

	private static void loginScreen(Scanner scanner) {
		view.loginScreen();
		if (controller.loginScreen(scanner)) {
			mainScreen(scanner);
		}
	}
	
	private static void mainScreen(Scanner scanner) {
		view.mainScreen();
		int userInput = controller.mainScreen(scanner);

		
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
				ConsoleUtil.printStatement(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLACK, ""));
				welcomeScreen(scanner);
			default:
				ConsoleUtil.printStatement(ColorUtil.combineAnsi(ANSI_FONT_COLOR.RED, "No option matching that input, restarting Home Screen..."));
				mainScreen(scanner);
		}
	}
	
	private static void depositAmount(Scanner scanner) {
		view.depositAmount();
		controller.depositAmount(scanner);
	}
	
	private static void withdrawAmount(Scanner scanner) {
		view.withdrawAmount();
		controller.withdrawAmount(scanner);
	}
	
	private static void fundsTransfer(Scanner scanner) {
		view.fundsTransfer();
		controller.fundsTransfer(scanner);
	}
	
	private static void recentTransactions(Scanner scanner) {
		view.recentTransactions();
		controller.recentTransactions(5);
	}
	
	private static void displayInformation(Scanner scanner) {
		view.displayInformation();
		controller.getUserDetails();
	}
	
	private static void signOut(Scanner scanner) {
		controller.signOut();
		view.signOut();
	}

}
