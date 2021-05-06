package com.cognixia.jumplus.dollarsbankapp.anorthouse.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.cognixia.jumplus.dollarsbankapp.anorthouse.model.User;

@DisplayName("DollarsBankController Tests")
class DollarsBankControllerTest {
	
	private static DollarsBankController appControl = new DollarsBankController();
	private static DollarsBankController depositAppControl = new DollarsBankController();
	private static DollarsBankController withdrawalAppControl = new DollarsBankController();
	private static DollarsBankController transferAppControl = new DollarsBankController();
	private static DollarsBankController transferDepositAppControl = new DollarsBankController();
	private static DollarsBankController transferWithdrawalAppControl = new DollarsBankController();
	
	
	@BeforeAll
	public static void setUp() {
		//creates test list of users for testing
		List<User> list = List.of(
				new User("foobar", "P@ssw0rd", "Foo Bar", "1112223333", 1000.00), 
				new User("deposit", "P@ssw0rd", "Deposit Tester", "4445556666", 1000.00), 
				new User("withdrawal", "P@ssw0rd", "Withdrawal Tester", "4445556666", 1000.00), 
				new User("transfer1", "P@ssw0rd", "Transfer Tester 1", "4445556666", 1000.00), 
				new User("transfer2", "P@ssw0rd", "Transfer Tester 2", "4445556666", 1000.00),
				new User("transfer3", "P@ssw0rd", "Transfer Tester 3", "4445556666", 1000.00),
				new User("transfer4", "P@ssw0rd", "Transfer Tester 4", "4445556666", 1000.00));
		
		//converts them into ArrayList, then inserts them into the class
		ArrayList<User> testUsers = new ArrayList<User>(list);
		DollarsBankController.users = (ArrayList<User>) testUsers;
		
		//this then logs in users for each of the app controllers:
		depositAppControl.attemptLogin("deposit", "P@ssw0rd");
		withdrawalAppControl.attemptLogin("withdrawal", "P@ssw0rd");
		transferAppControl.attemptLogin("transfer1", "P@ssw0rd");
		transferDepositAppControl.attemptLogin("transfer3", "P@ssw0rd");
		transferWithdrawalAppControl.attemptLogin("transfer4", "P@ssw0rd");
	}
	
	
	@AfterAll
	public static void tearDown() {
		//this then nullifies the objects
		appControl = null;
		depositAppControl = null;
		withdrawalAppControl = null;
		transferAppControl = null;
		transferDepositAppControl = null;
		transferWithdrawalAppControl = null;
		
		//before finally nullifying the static list
		DollarsBankController.users = null;
	}
	
	
	@Nested
	@DisplayName("attemptLogin()")
	class attemptLogin {

		String testUserId = "foobar";
		String testPassword = "P@ssw0rd";
		String badUserId = "username";
		String badPassword = "P@ssw0rd123";
		
		
		@Test
		@DisplayName("Catch: Username Does Not Exist")
		final void testUsernameDoesNotExist() {
			assertEquals(false, appControl.attemptLogin(badUserId, testPassword));
		}
		
		@Test
		@DisplayName("Catch: Password Does Not Match")
		final void testPasswordDoesNotMatch() {
			assertEquals(false, appControl.attemptLogin(testUserId, badPassword));
		}
		
		@Test
		@DisplayName("Successful Login")
		final void testSuccessfulLogin() {
			assertEquals(true, appControl.attemptLogin(testUserId, testPassword));
		}
		
	}

	
	@Nested
	@DisplayName("createUser()")
	class createUser {
		
		String testUserId = "testuser";
		String testBadUserId = "foobar";
		String testPassword = "P@ssw0rd";
		String testName = "Test User";
		String testContactNumber = "7778889999";
		double testBalance = 100.00;
		
		
		@Test
		@DisplayName("Catch: Already Existing Username")
		final void testUsernameAlreadyExists() {
			assertEquals(false, appControl.createUser(testBadUserId, testPassword, testName, testContactNumber, testBalance));
		}
		
		
		@Test
		@DisplayName("Successful Creation")
		final void testSuccessfulCreation() {
			assertEquals(true, appControl.createUser(testUserId, testPassword, testName, testContactNumber, testBalance));
		}
		
	}

	
	@Nested
	@DisplayName("addDeposit()")
	class addDeposit {
		
		User testUser = DollarsBankController.users.get(1);
		double deposit = 100.00;
		
		@Test
		@DisplayName("Successful Deposit")
		final void testSuccessfulDeposit() {
			double expected = testUser.getBalance() + deposit;
			depositAppControl.addDeposit(deposit);
			double actual = testUser.getBalance();
			assertEquals(expected, actual);
		}
		
	}
	
	
	@Nested
	@DisplayName("subtractWithdrawal()")
	class subtractWithdrawal {

		User testUser = DollarsBankController.users.get(2);
		double testWithdrawal = 100.00;
		double badWithdrawal = 10000.00;
		
		@Test
		@DisplayName("Catch: Not Enough Funds")
		final void testNotEnoughFunds() {
		    assertThrows(Exception.class, ()-> { 
		    	withdrawalAppControl.subtractWithdrawal(badWithdrawal);
		    });
		}
		
		@Test
		@DisplayName("Successful Withdrawal")
		final void testSuccessfulWithdrawal() {
			//declare variables to check later
			double expected = testUser.getBalance() - testWithdrawal;
			double actual;
			
			//try catch needed for method call
			try {
				withdrawalAppControl.subtractWithdrawal(testWithdrawal);
				actual = testUser.getBalance();
			} catch (Exception e) {
				actual = 0.00;
			}
			
			//final JUnit test
			assertEquals(expected, actual);
		}
		
	}
	
	
	@Nested
	@DisplayName("attemptTransfer()")
	class attemptTransfer {

		User transferGiver = DollarsBankController.users.get(3);
		User transferReciever = DollarsBankController.users.get(4);
		String testUsername = "transfer2";
		String selfUsername = "transfer1";
		String badUsername = "nullvoid";
		double testTransfer = 100.00;
		
		@Test
		@DisplayName("Catch: Transfer to Self")
		final void testTransferToSelf() {
		    assertThrows(Exception.class, ()-> { 
		    	transferAppControl.attemptTransfer(selfUsername, testTransfer);
		    });
		}
		
		@Test
		@DisplayName("Catch: Second User Doesn't Exist")
		final void testTransferUserNotFound() {
		    assertThrows(Exception.class, ()-> { 
		    	transferAppControl.attemptTransfer(badUsername, testTransfer);
		    });
		}
		
		@Test
		@DisplayName("Successful Transfer")
		final void testSuccessfulTransfer() {
			//declare variables to check later
			double expGiverBal = transferGiver.getBalance() - testTransfer;
			double expRecieverBal = transferReciever.getBalance() + testTransfer;
			double actGiverBal, actRecieverBal;
			
			//try catch needed for method call
			try {
				transferAppControl.attemptTransfer(testUsername, testTransfer);
				actGiverBal = transferGiver.getBalance();
				actRecieverBal = transferReciever.getBalance();
			} catch (Exception e) {
				actGiverBal = 0.00;
				actRecieverBal = 0.00;
			}
			
			//logic for getting result
			boolean actual = (expGiverBal == actGiverBal && expRecieverBal == actRecieverBal);
			
			
			//JUnit assertEquals logic to alert result
			assertEquals(true, actual);
		}
		
	}
	
	
	@Nested
	@DisplayName("transferDeposit()")
	class transferDeposit {

		User testUser = DollarsBankController.users.get(5);
		double transferDeposit = 100.00;
		
		@Test
		@DisplayName("Successful Transfer Deposit")
		final void testSuccessfulDespositTransfer() {
			double expected = testUser.getBalance() + transferDeposit;
			transferDepositAppControl.transferDeposit(testUser, "Testing Class", transferDeposit);
			double actual = testUser.getBalance();
			assertEquals(expected, actual);
		}
		
	}
	
	
	@Nested
	@DisplayName("transferWithdrawal()")
	class transferWithdrawal {

		User testUser = DollarsBankController.users.get(6);
		double transferWithdrawal = 100.00;
		double badTransferWithdrawal = 10000.00;
		
		@Test
		@DisplayName("Catch: Not Enough Funds")
		final void testNotEnoughFundsToTransfer() {
		    assertThrows(Exception.class, ()-> { 
		    	transferWithdrawalAppControl.transferWithdrawal(testUser, "Testing Class", badTransferWithdrawal);
		    });
		}
		
		@Test
		@DisplayName("Successful Transfer Withdrawal")
		final void testSuccessfulWithdrawalTransfer() {
			//declare variables to check later
			double expected = testUser.getBalance() - transferWithdrawal;
			double actual;
			
			//try catch needed for method call
			try {
				transferWithdrawalAppControl.transferWithdrawal(testUser, "Testing Class", transferWithdrawal);
				actual = testUser.getBalance();
			} catch (Exception e) {
				actual = 0.00;
			}
			
			//final JUnit test
			assertEquals(expected, actual);
		}
		
	}

}
