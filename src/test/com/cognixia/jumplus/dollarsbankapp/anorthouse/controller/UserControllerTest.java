package com.cognixia.jumplus.dollarsbankapp.anorthouse.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.cognixia.jumplus.dollarsbankapp.anorthouse.application.UserView;
import com.cognixia.jumplus.dollarsbankapp.anorthouse.model.User;

class UserControllerTest {
	//class objects for testing:
	static User testGetUser = new User("Foobar", "password", "John Doe", "8885558888", 100.0);
	static UserView testView = new UserView();
	static UserController testController = new UserController(testGetUser, testView);

	/*
		@DisplayName("Set User Id")
		@Test
		void testSetUserId() {
			String expected = "BarFoo";
			testSetUser.setUserId(expected);
			String actual = testSetUser.getUserId();
			assertEquals(expected, actual);
		}
	 */
	
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
		String expected = "drowssap";
		testController.setUserPassword(expected);
		String actual = testController.getUserPassword();
		assertEquals(expected, actual);
	}

	@DisplayName("Get Name")
	@Test
	final void testGetUserName() {
		String expected = "John Doe";
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
		// TODO
		Object expected = null;
		Object actual = null;
		assertEquals(expected, actual);
	}

	@DisplayName("Set ContactNumber")
	@Test
	final void testSetUserContactNumber() {
		// TODO
		Object expected = null;
		Object actual = null;
		assertEquals(expected, actual);
	}

	@DisplayName("Get UserBalance")
	@Test
	final void testGetUserBalance() {
		// TODO
		Object expected = null;
		Object actual = null;
		assertEquals(expected, actual);
	}

	@DisplayName("Set UserBalance")
	@Test
	final void testSetUserBalance() {
		// TODO
		Object expected = null;
		Object actual = null;
		assertEquals(expected, actual);
	}

	@DisplayName("Get UserLog")
	@Test
	final void testGetUserLog() {
		// TODO
		Object expected = null;
		Object actual = null;
		assertEquals(expected, actual);
	}

	@DisplayName("Set UserLog")
	@Test
	final void testSetUserLog() {
		// TODO
		Object expected = null;
		Object actual = null;
		assertEquals(expected, actual);
	}

	@DisplayName("Test UpdateView()")
	@Test
	final void testUpdateView() {
		// TODO
		Object expected = null;
		Object actual = null;
		assertEquals(expected, actual);
	}

}



























