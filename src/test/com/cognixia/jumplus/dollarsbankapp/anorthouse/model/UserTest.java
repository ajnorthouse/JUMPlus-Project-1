package com.cognixia.jumplus.dollarsbankapp.anorthouse.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.DisplayName.class)
@DisplayName("Test User Model")
class UserTest {
	//class objects needed for testing
	static User testUser = new User();

	@DisplayName("Auto Incrementing ID Test")
	@Test
	void testCurrentIdIncrement() {
		assertEquals(3L, User.getCurrentID());
	}

	@DisplayName("Setter Methods")
	@Nested
	class setters {
		
		@DisplayName("Set User Id")
		@Test
		void testUserId() {
			String expected = "Foobar";
			testUser.setUserId(expected);
			String actual = testUser.getUserId();
			assertEquals(expected, actual);
		}
		
		@DisplayName("Set Password")
		@Test
		void testSetPassword() {
			String expected = "password";
			testUser.setPassword(expected);
			String actual = testUser.getPassword();
			assertEquals(expected, actual);
		}
		
		@DisplayName("Set Name")
		@Test
		void testSetName() {
			String expected = "John Doe";
			testUser.setName(expected);
			String actual = testUser.getName();
			assertEquals(expected, actual);
		}
		
		@DisplayName("Set Contact Number")
		@Test
		void testSetContactNumber() {
			String expected = "8885558888";
			testUser.setContactNumber(expected);
			String actual = testUser.getContactNumber();
			assertEquals(expected, actual);
		}
		
		@DisplayName("Set Balance")
		@Test
		void testSetBalance() {
			double expected = 100.0;
			testUser.setBalance(expected);
			double actual = testUser.getBalance();
			assertEquals(expected, actual);
		}
		
		@DisplayName("Set Log")
		@Test
		void testSetLog() {
			ArrayList<String> expected = new ArrayList<String>();
			expected.add("This is a test log.");
			testUser.setLog(expected);
			ArrayList<String> actual = testUser.getLog();
			assertEquals(expected, actual);
		}
	}
	
	@DisplayName("Getter Methods")
	@Nested
	class getters {
		
		@DisplayName("Get Id")
		@Test
		void testGetId() {
			Long expected = 2L;
			Long actual = testUser.getId();
			assertEquals(expected, actual);
		}
		
		@DisplayName("Get User Id")
		@Test
		void testUserId() {
			String expected = "N/A";
			String actual = testUser.getUserId();
			assertEquals(expected, actual);
		}
		
		@DisplayName("Get Password")
		@Test
		void testGetPassword() {
			String expected = "";
			String actual = testUser.getPassword();
			assertEquals(expected, actual);
		}
		
		@DisplayName("Get Name")
		@Test
		void testGetName() {
			String expected = "N/A";
			String actual = testUser.getName();
			assertEquals(expected, actual);
		}
		
		@DisplayName("Get Contact Number")
		@Test
		void testGetContactNumber() {
			String expected = "N/A";
			String actual = testUser.getContactNumber();
			assertEquals(expected, actual);
		}
		
		@DisplayName("Get Balance")
		@Test
		void testGetBalance() {
			double expected = 0.0;
			double actual = testUser.getBalance();
			assertEquals(expected, actual);
		}
		
		@DisplayName("Get Log")
		@Test
		void testGetLog() {
			ArrayList<String> expected = null;
			ArrayList<String> actual = testUser.getLog();
			assertEquals(expected, actual);
		}
	}
	
}
