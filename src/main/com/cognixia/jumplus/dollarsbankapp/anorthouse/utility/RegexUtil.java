package com.cognixia.jumplus.dollarsbankapp.anorthouse.utility;

import java.util.regex.Pattern;

//TODO - JavaDoc description
public class RegexUtil {
	
	static Pattern lengthPattern = Pattern.compile(".{8,}?");
	static Pattern upperCasePattern = Pattern.compile("[A-Z]+");
	static Pattern lowerCasePattern = Pattern.compile("[a-z]+");
	static Pattern specialCharPattern = Pattern.compile("[$&+,:;=?@#|'<>.^*()%!-]");
	static Pattern numberCharPattern = Pattern.compile("[0-9]+");


	//TODO - JavaDoc description
	public static void checkPassword(String password) throws Exception {
		//checks for a length of 8 first
		if (!lengthPattern.matcher(password).find()) {
			throw new Exception("Password too short!");
		}
		
		//checks for at least one special character
		if (!specialCharPattern.matcher(password).find()) {
			throw new Exception("Missing at least 1 Special Character!");
		}
		
		//checks for at least one number
		if (!numberCharPattern.matcher(password).find()) {
			throw new Exception("Missing at least 1 Number!");
		}
		
		//checks for at least one upper-case character
		if (!upperCasePattern.matcher(password).find()) {
			throw new Exception("Missing at least 1 Upper-Case Letter!");
		}
		
		//checks for at least one lower-case character
		if (!lowerCasePattern.matcher(password).find()) {
			throw new Exception("Missing at least 1 Lower-Case Letter!");
		}
	}


	//TODO - JavaDoc description
	public static String checkContactNumber(String contactNumber) throws Exception {
		//first strips any characters not digits
		contactNumber = contactNumber.replaceAll("[^0-9]", "");
		
		//then checks for length of 10 or 11
		if (contactNumber.matches("^.{10,11}$")) {
			return contactNumber;
		}
		throw new Exception();
	}
	

	//TODO - JavaDoc description
	public static void checkUsername(String username) throws Exception {
		//must be at least 8 characters
		if (!lengthPattern.matcher(username).find()) {
			throw new Exception("Username too short!");
		}
		
		
		//contain at least 1 letter
		if (!upperCasePattern.matcher(username).find()) {
			throw new Exception("Username missing a letter!");
		}
		
		
		//contain at least 1 number
		if (!numberCharPattern.matcher(username).find()) {
			throw new Exception("Username missing a number!");
		}
		
		
		//contain NO special characters
		if (specialCharPattern.matcher(username).find()) {
			throw new Exception("Username has a special symbol!");
		}
		
		
	}

}
