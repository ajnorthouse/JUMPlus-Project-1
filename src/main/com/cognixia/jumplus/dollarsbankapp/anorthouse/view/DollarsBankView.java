package com.cognixia.jumplus.dollarsbankapp.anorthouse.view;

import com.cognixia.jumplus.dollarsbankapp.anorthouse.utility.ColorUtil;
import com.cognixia.jumplus.dollarsbankapp.anorthouse.utility.ColorUtil.ANSI_FONT_COLOR;


public class DollarsBankView {
	
	private StringBuilder page = new StringBuilder();
	private StringBuilder temp = new StringBuilder();


	
	public String welcomeScreen() {
		page.setLength(0);
		temp.setLength(0);
		
		page.append("+---------------------------+\n");
		page.append("| DOLLARSBANK Welcomes You! |\n");
		page.append("+---------------------------+\n");
		temp.append(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.BLUE, page.toString()));

		page.setLength(0);
		page.append("1. Create New Account\n");
		page.append("2. Login\n");
		page.append("3. Exit\n");
		temp.append(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.BLACK, page.toString()));
		
		return temp.toString();
	}

	
	
	public String createNewAccount() {
		page.setLength(0);
		page.append("\n");
		page.append("+---------------------------+\n");
		page.append("| Enter New Account Details |\n");
		page.append("+---------------------------+\n");
		return ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.BLUE, page.toString());
	}

	
	
	public String loginScreen() {
		page.setLength(0);
		page.append("\n");
		page.append("+---------------------------+\n");
		page.append("|    Enter Login Details    |\n");
		page.append("+---------------------------+\n");
		return ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.BLUE, page.toString());
	}


	
	public String mainScreen() {
		page.setLength(0);
		temp.setLength(0);
		
		page.append("\n");
		page.append("+---------------------------+\n");
		page.append("|        Home Screen        |\n");
		page.append("+---------------------------+\n");
		temp.append(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.BLUE, page.toString()));

		page.setLength(0);
		page.append("1. Deposit Amount\n");
		page.append("2. Withdraw Amount\n");
		page.append("3. Funds Transfer\n");
		page.append("4. View 5 Last Transactions\n");
		page.append("5. Display Account Information\n");
		page.append("6. Sign Out\n");
		temp.append(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.BLACK, page.toString()));

		return temp.toString();
	}


	
	public String depositAmount() {
		page.setLength(0);
		page.append("\n");
		page.append("+---------------------------+\n");
		page.append("|       Deposit Amount      |\n");
		page.append("+---------------------------+\n");
		return ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.BLUE, page.toString());
	}


	
	public String withdrawAmount() {
		page.setLength(0);
		page.append("\n");
		page.append("+---------------------------+\n");
		page.append("|      Withdraw Amount      |\n");
		page.append("+---------------------------+\n");
		return ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.BLUE, page.toString());
	}


	
	public String fundsTransfer() {
		page.setLength(0);
		page.append("\n");
		page.append("+---------------------------+\n");
		page.append("|       Funds Transfer      |\n");
		page.append("+---------------------------+\n");
		return ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.BLUE, page.toString());
	}


	
	public String recentTransactions() {
		page.setLength(0);
		page.append("\n");
		page.append("+---------------------------+\n");
		page.append("| View Last 5 Transactions  |\n");
		page.append("+---------------------------+\n");
		return ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.BLUE, page.toString());
	}


	
	public String displayInformation() {
		page.setLength(0);
		page.append("\n");
		page.append("+---------------------------+\n");
		page.append("|    Display Information    |\n");
		page.append("+---------------------------+\n");
		return ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.BLUE, page.toString());
	}
	

	
	public String signOut() {
		page.setLength(0);
		page.append(ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.RED, "== Signing out... Thank you! ==\n"));
		return page.toString();
	}
	
}
