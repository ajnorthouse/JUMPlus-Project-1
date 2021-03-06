package com.cognixia.jumplus.project1.anorthouse.view;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.cognixia.jumplus.project1.anorthouse.model.User;
import com.cognixia.jumplus.project1.anorthouse.view.UserView;

@DisplayName("UserView Tests")
class UserViewTest {
	
	static private UserView view = new UserView();
	static private User testUser = null;
	
	@BeforeAll
	public static void setUp() {
		testUser = new User();
		ArrayList<String> tempLog = new ArrayList<String>();
		tempLog.add("Testing!");
		testUser.setLog(tempLog);
	}

	@Test
	@DisplayName("getUserDetails()")
	final void testGetUserDetails() {
		String expected = "User Details: \n- Name: N/A\n- Contact Number: N/A\n- Balance: 0.0\n";
		String actual = view.getUserDetails(testUser);
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("showLastTransactions()")
	final void testShowLastTransactions() {
		String expected = "Testing!\n";
		String actual = view.showLastTransactions(testUser, 5);
		assertEquals(expected, actual);
	}

}
