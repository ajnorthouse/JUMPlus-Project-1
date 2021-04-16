package com.cognixia.jumplus.dollarsbankapp.anorthouse.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.cognixia.jumplus.dollarsbankapp.anorthouse.model.User;

@DisplayName("Test User methods in Controller")
class DollarsBankControllerTest {
	//class objects for testing:
	static User testUser = new User("Foobar", "password", "John Doe", "8885558888", 100.0);
	static DollarsBankController testController = new DollarsBankController();
	
	@BeforeAll
	static void setUp() {
		testController.setCurrentUser(testUser);
	}
	
	@DisplayName("Get Id")
	@Test
	final void testGetUserId() {
		Long expected = 1L;
		Long actual = testController.getUserId();
		assertEquals(expected, actual);
	}

	@DisplayName("Get UserId")
	@Test
	final void testGetUserUserId() {
		String expected = "Foobar";
		String actual = testController.getUserUserId();
		assertEquals(expected, actual);
	}

	@DisplayName("Set UserId")
	@Test
	final void testSetUserUserId() {
		String expected = "BarFoo";
		testController.setUserUserId(expected);
		String actual = testController.getUserUserId();
		assertEquals(expected, actual);
	}

	@DisplayName("Get Password")
	@Test
	final void testGetUserPassword() {
		String expected = "password";
		String actual = testController.getUserPassword();
		assertEquals(expected, actual);
	}

	@DisplayName("Set Password")
	@Test
	final void testSetUserPassword() {
		String expected = "password";
		testController.setUserPassword(expected);
		String actual = testController.getUserPassword();
		assertEquals(expected, actual);
	}

	@DisplayName("Get Name")
	@Test
	final void testGetUserName() {
		String expected = "Dane Smith";
		String actual = testController.getUserName();
		assertEquals(expected, actual);
	}

	@DisplayName("Set Name")
	@Test
	final void testSetUserName() {
		String expected = "Dane Smith";
		testController.setUserName(expected);
		String actual = testController.getUserName();
		assertEquals(expected, actual);
	}

	@DisplayName("Get ContactNumber")
	@Test
	final void testGetUserContactNumber() {
		String expected = "8885558888";
		testController.setUserContactNumber(expected);
		String actual = testController.getUserContactNumber();
		assertEquals(expected, actual);
	}

	@DisplayName("Set ContactNumber")
	@Test
	final void testSetUserContactNumber() {
		String expected = "5558885555";
		testController.setUserContactNumber(expected);
		String actual = testController.getUserContactNumber();
		assertEquals(expected, actual);
	}

	@DisplayName("Get UserBalance")
	@Test
	final void testGetUserBalance() {
		Double expected = 200.0;
		Double actual = testController.getUserBalance();
		assertEquals(expected, actual);
	}

	@DisplayName("Set UserBalance")
	@Test
	final void testSetUserBalance() {
		Double expected = 200.0;
		testController.setUserBalance(expected);
		Double actual = testController.getUserBalance();
		assertEquals(expected, actual);
	}

	@DisplayName("Get UserLog")
	@Test
	final void testGetUserLog() {
		ArrayList<String> expected = new ArrayList<String>();
		ArrayList<String> actual = testController.getUserLog();
		assertEquals(expected, actual);
	}

	@DisplayName("Set UserLog")
	@Test
	final void testSetUserLog() {
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("Testy");
		testController.setUserLog(expected);
		ArrayList<String> actual = testController.getUserLog();
		assertEquals(expected, actual);
	}

	@DisplayName("Test UpdateView()")
	@Test
	final void testUpdateView() {
		String expected = "User Details: \n"
			+ "- Name: " + testUser.getName() +"\n"
			+ "- Contact Number: " + testUser.getContactNumber() + "\n"
			+ "- Balance: " + testUser.getBalance() + "\n";
		Object actual = testController.showUserInfo();
		assertEquals(expected, actual);
	}

}
