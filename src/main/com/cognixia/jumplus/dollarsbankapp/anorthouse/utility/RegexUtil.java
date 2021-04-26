package com.cognixia.jumplus.dollarsbankapp.anorthouse.utility;

import java.util.regex.Pattern;

public class RegexUtil {
	
	static Pattern lengthPattern = Pattern.compile(".{8,}?");
	static Pattern upperCasePattern = Pattern.compile("[A-Z]+");
	static Pattern lowerCasePattern = Pattern.compile("[a-z]+");
	static Pattern specialCharPattern = Pattern.compile("[#?!@$%^&*-]+");
	static Pattern numberCharPattern = Pattern.compile("[0-9]+");
	
	//TODO add description
	public static void checkPassword(String password) throws Exception {
		System.out.println("\"" + password + "\"");
		//checks for a length of 8 first
		if (!lengthPattern.matcher(password).find()) {
			System.out.println("length");
			throw new Exception("Password too short!");
		}
		
		//checks for at least one special character
		if (!specialCharPattern.matcher(password).find()) {
			System.out.println("special");
			throw new Exception("Missing at least 1 Special Character!");
		}
		
		//checks for at least one number
		if (!numberCharPattern.matcher(password).find()) {
			System.out.println("number");
			throw new Exception("Missing at least 1 Number!");
		}
		
		//checks for at least one upper-case character
		if (!upperCasePattern.matcher(password).find()) {
			System.out.println("upper-case");
			throw new Exception("Missing at least 1 Upper-Case Letter!");
		}
		
		//checks for at least one lower-case character
		if (!lowerCasePattern.matcher(password).find()) {
			System.out.println("lower-case");
			throw new Exception("Missing at least 1 Lower-Case Letter!");
		}
	}
	
	//TODO add description
	public static String checkContactNumber(String contactNumber) throws Exception {
		//first strips any characters not digits
		contactNumber = contactNumber.replaceAll("[^0-9]", "");
		
		//then checks for length of 10 or 11
		if (contactNumber.matches("^.{10,11}$")) {
			return contactNumber;
		}
		throw new Exception();
	}

	//TODO add description
	//TODO username regex
	
}
