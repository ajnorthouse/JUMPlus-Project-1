package com.cognixia.jumplus.project1.anorthouse.application;

import java.util.Scanner;

import com.cognixia.jumplus.project1.anorthouse.controller.DollarsBankController;
import com.cognixia.jumplus.project1.anorthouse.utility.ColorUtil;
import com.cognixia.jumplus.project1.anorthouse.utility.ConsoleUtil;
import com.cognixia.jumplus.project1.anorthouse.utility.ColorUtil.ANSI_FONT_COLOR;
import com.cognixia.jumplus.project1.anorthouse.view.DollarsBankView;

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
		ConsoleUtil.printStatement(view.welcomeScreen());
		int userInput = controller.welcomeScreen(scanner);
		
		switch (userInput) {
			case 1:
				createNewAccount(scanner);
				ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.BLACK, ""));
				welcomeScreen(scanner);
				break;
			case 2:
				loginScreen(scanner);
				ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.BLACK, ""));
				welcomeScreen(scanner);
				break;
			case 3:
				ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.BLACK, ""));
				ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.GREEN, "Thank You for using Dollars Bank!"));
				break;
			
			//case 0 is for an input-type error, while default is for just a bad input
			case 0:
				ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.BLACK, ""));
				welcomeScreen(scanner);
			default:
				ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.RED, "No option matching that input, Reseting Welcome Screen."));
				ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.BLACK, ""));
				welcomeScreen(scanner);
		}
	}
	
	private static void createNewAccount(Scanner scanner) {
		ConsoleUtil.printStatement(view.createNewAccount());
		controller.createNewAccount(scanner);
	}

	private static void loginScreen(Scanner scanner) {
		ConsoleUtil.printStatement(view.loginScreen());
		if (controller.loginScreen(scanner)) {
			mainScreen(scanner);
		}
	}
	
	private static void mainScreen(Scanner scanner) {
		ConsoleUtil.printStatement(view.mainScreen());
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
				ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.BLACK, ""));
				welcomeScreen(scanner);
			default:
				ConsoleUtil.printStatement(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.RED, "No option matching that input, restarting Home Screen..."));
				mainScreen(scanner);
		}
	}
	
	private static void depositAmount(Scanner scanner) {
		ConsoleUtil.printStatement(view.depositAmount());
		controller.depositAmount(scanner);
	}
	
	private static void withdrawAmount(Scanner scanner) {
		ConsoleUtil.printStatement(view.withdrawAmount());
		controller.withdrawAmount(scanner);
	}
	
	private static void fundsTransfer(Scanner scanner) {
		ConsoleUtil.printStatement(view.fundsTransfer());
		controller.fundsTransfer(scanner);
	}
	
	private static void recentTransactions(Scanner scanner) {
		ConsoleUtil.printStatement(view.recentTransactions());
		controller.recentTransactions(5);
	}
	
	private static void displayInformation(Scanner scanner) {
		ConsoleUtil.printStatement(view.displayInformation());
		controller.getUserDetails();
	}
	
	private static void signOut(Scanner scanner) {
		controller.signOut();
		ConsoleUtil.printStatement(view.signOut());
	}

}
