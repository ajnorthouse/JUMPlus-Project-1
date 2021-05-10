package com.cognixia.jumplus.project1.anorthouse.view;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.cognixia.jumplus.project1.anorthouse.view.DollarsBankView;

class DollarsBankViewTest {
	
	static private DollarsBankView view = new DollarsBankView();
	@SuppressWarnings("serial")
	static private HashMap<String, String> commonStrings = new HashMap<String, String>(){{
		put("menuLine","+---------------------------+\n");
		put("ansiBlue","\u001B[34m");
		put("ansiBlack","\u001B[30m");
		put("ansiReset","\u001B[0m");
	}};

	@Test
	@DisplayName("welcomeScreen()")
	final void testWelcomeScreen() {
		String expected = commonStrings.get("ansiBlue") + commonStrings.get("menuLine")
				+ "| DOLLARSBANK Welcomes You! |\n"
				+ commonStrings.get("menuLine") + commonStrings.get("ansiReset")
				+ commonStrings.get("ansiBlack")
				+ "1. Create New Account\n2. Login\n3. Exit\n"
				+ commonStrings.get("ansiReset");
		String actual = view.welcomeScreen();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("createNewAccount()")
	final void testCreateNewAccount() {
		String expected = commonStrings.get("ansiBlue") + "\n" + commonStrings.get("menuLine")
				+ "| Enter New Account Details |\n"
				+ commonStrings.get("menuLine") + commonStrings.get("ansiReset");
		String actual = view.createNewAccount();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("loginScreen()")
	final void testLoginScreen() {
		String expected = commonStrings.get("ansiBlue") + "\n" + commonStrings.get("menuLine")
				+ "|    Enter Login Details    |\n"
				+ commonStrings.get("menuLine") + commonStrings.get("ansiReset");
		String actual = view.loginScreen();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("mainScreen()")
	final void testMainScreen() {
		String expected = commonStrings.get("ansiBlue") + "\n" + commonStrings.get("menuLine")
				+ "|        Home Screen        |\n"
				+ commonStrings.get("menuLine") + commonStrings.get("ansiReset")
				+ commonStrings.get("ansiBlack")
				+ "1. Deposit Amount\n2. Withdraw Amount\n3. Funds Transfer\n"
				+ "4. View 5 Last Transactions\n5. Display Account Information\n6. Sign Out\n"
				+ commonStrings.get("ansiReset");
		String actual = view.mainScreen();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("depositAmount()")
	final void testDepositAmount() {
		String expected = commonStrings.get("ansiBlue") + "\n" + commonStrings.get("menuLine")
				+ "|       Deposit Amount      |\n"
				+ commonStrings.get("menuLine") + commonStrings.get("ansiReset");
		String actual = view.depositAmount();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("withdrawAmount()")
	final void testWithdrawAmount() {
		String expected = commonStrings.get("ansiBlue") + "\n" + commonStrings.get("menuLine")
				+ "|      Withdraw Amount      |\n"
				+ commonStrings.get("menuLine") + commonStrings.get("ansiReset");
		String actual = view.withdrawAmount();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("fundsTransfer()")
	final void testFundsTransfer() {
		String expected = commonStrings.get("ansiBlue") + "\n" + commonStrings.get("menuLine")
				+ "|       Funds Transfer      |\n"
				+ commonStrings.get("menuLine") + commonStrings.get("ansiReset");
		String actual = view.fundsTransfer();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("recentTransactions()")
	final void testRecentTransactions() {
		String expected = commonStrings.get("ansiBlue") + "\n" + commonStrings.get("menuLine")
				+ "| View Last 5 Transactions  |\n"
				+ commonStrings.get("menuLine") + commonStrings.get("ansiReset");
		String actual = view.recentTransactions();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("displayInformation()")
	final void testDisplayInformation() {
		String expected = commonStrings.get("ansiBlue") + "\n" + commonStrings.get("menuLine")
				+ "|    Display Information    |\n"
				+ commonStrings.get("menuLine") + commonStrings.get("ansiReset");
		String actual = view.displayInformation();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("signOut()")
	final void testSignOut() {
		String expected = "\u001B[31m== Signing out... Thank you! ==\n\u001B[0m";
		String actual = view.signOut();
		assertEquals(expected, actual);
	}
	
}
