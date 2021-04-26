package com.cognixia.jumplus.dollarsbankapp.anorthouse.utility;

public class InputParserUtil {

	//TODO add description
	//TODO username parser

	//TODO add description
	//TODO password parser
	
	//TODO add description
	public static int parseInt(String rawInput) throws Exception {
		String tempString = rawInput;
		int tempInt = 0;
		
		try {
			//attempts to parse input
			tempString = tempString.trim();
			tempInt = Integer.parseInt(tempString);

			//then checks for non=negative
			if (tempInt < 0) {
				throw new Exception();
			}
		//throws generic exception to allow for caller to handle issue
		} catch (Exception e) {
			throw e;
		}
		
		//returns parsed input
		return tempInt;
	}

	//TODO add description
	public static double parseDouble(String rawInput) throws Exception {
		String tempString = rawInput;
		double tempDouble = 0.00;
		
		try {
			//attempts to parse input
			tempString = tempString.trim();
			tempDouble = Double.parseDouble(tempString);

			//then checks for non=negative
			if (tempDouble < 0.00) {
				throw new Exception();
			}
		//throws generic exception to allow for caller to handle issue
		} catch (Exception e) {
			throw e;
		}
		
		//returns parsed input
		return tempDouble;
	}

	//TODO add description
	public static String parseString(String rawInput) throws Exception {
		String tempString = rawInput;
		
		try {
			//attempts to parse input
			tempString = tempString.trim();
			
			//checks for empty string
			if (tempString.equals("")) {
				throw new Exception();
			}
		//throws generic exception to allow for caller to handle issue
		} catch (Exception e) {
			throw e;
		}
		
		//returns parsed input
		return tempString;
	}
	
}
