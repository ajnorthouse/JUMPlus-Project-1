package com.cognixia.jumplus.dollarsbankapp.anorthouse.controller;



import static org.junit.jupiter.api.Assertions.*;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.cognixia.jumplus.dollarsbankapp.anorthouse.model.User;

@DisplayName("UserController Tests")
class UserControllerTest {
	
	static private UserController controller = new UserController();
	static private User testUser = null;
	

	DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("E, MMM dd yyyy");
	DateTimeFormatter tmzFormat = DateTimeFormatter.ofPattern("z");
	
	@BeforeAll
	public static void setUp() {
		testUser = new User();
		testUser.setLog(new ArrayList<String>());
	}
	
	@Nested
	@DisplayName("updateLog()")
	class updateLog {

		@Test
		@DisplayName("Test for Correct Date")
		final void testDate() {
			//updates log
			String logEntry = controller.updateLog(testUser, "Date Test!");
			
			//gets date and edge-case date
			String date1 = (ZonedDateTime.now().format(dateFormat));
			String date2 = (ZonedDateTime.now().plusDays(1L).format(dateFormat));
			
			//tests for date
			boolean containedText = false;
			if (logEntry.contains(date1) || logEntry.contains(date2)) {
				containedText = true;
			} 
			
			//gives JUnit result
			assertEquals(true, containedText);
		}

		@Test
		@DisplayName("Test for Correct Time Zone")
		final void testTimeZone() {
			//updates log
			String logEntry = controller.updateLog(testUser, "TimeZone Test!");
			
			//gets date and edge-case date
			String date1 = (ZonedDateTime.now().format(tmzFormat));
			
			//tests for time zone
			boolean containedText = false;
			if (logEntry.contains(date1)) {
				containedText = true;
			} 
			
			//gives JUnit result
			assertEquals(true, containedText);
		}

		@Test
		@DisplayName("Test for Correct Content")
		final void testContent() {
			//updates log
			String logEntry = controller.updateLog(testUser, "Content Test!");
			
			//tests for the content
			boolean containedText = false;
			if (logEntry.contains("Content Test!")) {
				containedText = true;
			} 
			
			//gives JUnit result
			assertEquals(true, containedText);
		}
		
	}

}
