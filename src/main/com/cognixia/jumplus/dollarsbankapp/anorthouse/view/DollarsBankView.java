package com.cognixia.jumplus.dollarsbankapp.anorthouse.view;

import com.cognixia.jumplus.dollarsbankapp.anorthouse.utility.ColorUtil;
import com.cognixia.jumplus.dollarsbankapp.anorthouse.utility.ConsoleUtil;
import com.cognixia.jumplus.dollarsbankapp.anorthouse.utility.ColorUtil.ANSI_FONT_COLOR;

public class DollarsBankView {
	
	StringBuilder page = new StringBuilder();

	public void signOut() {
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.RED, "== Signing out... Thank you! ==\n"));
	}

	public void displayInformation() {
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "+---------------------------+\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "|    Display Information    |\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "+---------------------------+\n"));
		ConsoleUtil.printStatement(page.toString());
		page.setLength(0);
	}

	public void recentTransactions() {
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "+---------------------------+\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "| View Last 5 Transactions  |\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "+---------------------------+\n"));
		ConsoleUtil.printStatement(page.toString());
		page.setLength(0);
	}

	public void fundsTransfer() {
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "+---------------------------+\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "|       Funds Transfer      |\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "+---------------------------+\n"));
		ConsoleUtil.printStatement(page.toString());
		page.setLength(0);
	}

	public void withdrawAmount() {
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "+---------------------------+\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "|      Withdraw Amount      |\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "+---------------------------+\n"));
		ConsoleUtil.printStatement(page.toString());
		page.setLength(0);
	}

	public void depositAmount() {
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "+---------------------------+\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "|       Deposit Amount      |\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "+---------------------------+\n"));
		ConsoleUtil.printStatement(page.toString());
		page.setLength(0);
	}

	public void mainScreen() {
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "+---------------------------+\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "|        Home Screen        |\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "+---------------------------+\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLACK, "1. Deposit Amount\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLACK, "2. Withdraw Amount\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLACK, "3. Funds Transfer\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLACK, "4. View 5 Last Transactions\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLACK, "5. Display Account Information\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLACK, "6. Sign Out\n"));
		ConsoleUtil.printStatement(page.toString());
		page.setLength(0);
	}

	public void loginScreen() {
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "+---------------------------+\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "|    Enter Login Details    |\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "+---------------------------+\n"));
		ConsoleUtil.printStatement(page.toString());
		page.setLength(0);
	}

	public void createNewAccount() {
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "+---------------------------+\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "| Enter New Account Details |\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "+---------------------------+\n"));
		ConsoleUtil.printStatement(page.toString());
		page.setLength(0);
	}

	public void welcomeScreen() {
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "+---------------------------+\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "| DOLLARSBANK Welcomes You! |\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLUE, "+---------------------------+\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLACK, "1. Create New Account\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLACK, "2. Login\n"));
		page.append(ColorUtil.combineAnsi(ANSI_FONT_COLOR.BLACK, "3. Exit\n"));
		ConsoleUtil.printStatement(page.toString());
		page.setLength(0);
	}
	
}
