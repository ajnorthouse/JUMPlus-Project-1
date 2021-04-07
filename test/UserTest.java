import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.cognixia.jumplus.dollarsbankapp.anorthouse.model.User;

@DisplayName("Test User Model")
class UserTest {
	//class objects needed for testing
	static User testGetUser = new User("Foobar", "password", 
			"John Doe", "8885558888", 100.0);
	static User testSetUser = new User("Foobar", "password", 
			"John Doe", "8885558888", 100.0);
	static User testDefaultUser = new User();
	
	@Nested
	@DisplayName("Setters")
	class setters {
		
		@DisplayName("Set User Id")
		@Test
		void testSetUserId() {
			String expected = "BarFoo";
			testSetUser.setUserId(expected);
			String actual = testSetUser.getUserId();
			assertEquals(expected, actual);
		}
		
		@DisplayName("Set Password")
		@Test
		void testSetPassword() {
			String expected = "drowssap";
			testSetUser.setPassword(expected);
			String actual = testSetUser.getPassword();
			assertEquals(expected, actual);
		}
		
		@DisplayName("Set Name")
		@Test
		void testSetName() {
			String expected = "Jane Dane";
			testSetUser.setName(expected);
			String actual = testSetUser.getName();
			assertEquals(expected, actual);
		}
		
		@DisplayName("Set Contact Number")
		@Test
		void testSetContactNumber() {
			String expected = "5558885555";
			testSetUser.setContactNumber(expected);
			String actual = testSetUser.getContactNumber();
			assertEquals(expected, actual);
		}
		
		@DisplayName("Set Balance")
		@Test
		void testSetBalance() {
			double expected = 1000.00;
			testSetUser.setBalance(expected);
			double actual = testSetUser.getBalance();
			assertEquals(expected, actual);
		}
		
		@DisplayName("Set Log")
		@Test
		void testSetLog() {
			ArrayList<String> expected = new ArrayList<String>();
			expected.add("This is a test log.");
			testSetUser.setLog(expected);
			ArrayList<String> actual = testSetUser.getLog();
			assertEquals(expected, actual);
		}
	}
	
	@Nested
	@DisplayName("Getters")
	class getters {
		
		@DisplayName("Get Id")
		@Test
		void testGetId() {
			Long expected = 1L;
			Long actual = testGetUser.getId();
			assertEquals(expected, actual);
		}
		
		@DisplayName("Get User Id")
		@Test
		void testGetUserId() {
			String expected = "Foobar";
			String actual = testGetUser.getUserId();
			assertEquals(expected, actual);
		}
		
		@DisplayName("Get Password")
		@Test
		void testGetPassword() {
			String expected = "password";
			String actual = testGetUser.getPassword();
			assertEquals(expected, actual);
		}
		
		@DisplayName("Get Name")
		@Test
		void testGetName() {
			String expected = "John Doe";
			String actual = testGetUser.getName();
			assertEquals(expected, actual);
		}
		
		@DisplayName("Get Contact Number")
		@Test
		void testGetContactNumber() {
			String expected = "8885558888";
			String actual = testGetUser.getContactNumber();
			assertEquals(expected, actual);
		}
		
		@DisplayName("Get Balance")
		@Test
		void testGetBalance() {
			double expected = 100.00;
			double actual = testGetUser.getBalance();
			assertEquals(expected, actual);
		}
		
		@DisplayName("Get Log")
		@Test
		void testGetLog() {
			ArrayList<String> expected = new ArrayList<String>();
			ArrayList<String> actual = testGetUser.getLog();
			assertEquals(expected, actual);
		}
	}
	
	@Nested
	@DisplayName("Constructors")
	class constructors {

		@DisplayName("Default Values Test")
		@Test
		void testDefaultConstructor() {
			Boolean[] expected = {true, true, true, true, true, true, true};
			Boolean[] actual = {
					(testDefaultUser.getId() == 3), 
					(testDefaultUser.getUserId() == "N/A"), 
					(testDefaultUser.getPassword() == ""), 
					(testDefaultUser.getName() == "N/A"), 
					(testDefaultUser.getContactNumber() == "N/A"), 
					(testDefaultUser.getBalance() == 0.0), 
					(testDefaultUser.getLog() == null)
			};
			assertArrayEquals(expected, actual);
		}

		@DisplayName("Auto Incrementing ID Test")
		@Test
		void testCurrentIdIncrement() {
			assertEquals(4L, User.getCurrentID());
		}
	}
	
}
