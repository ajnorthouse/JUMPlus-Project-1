package com.cognixia.jumplus.dollarsbankapp.anorthouse.application;

import com.cognixia.jumplus.dollarsbankapp.anorthouse.controller.UserController;
import com.cognixia.jumplus.dollarsbankapp.anorthouse.model.User;

public class DollarsBankApplication {
	
    public static void main( String[] args ) {
    	User testUser = new User();
    	UserController testController = new UserController(testUser, new UserView());
    	testController.updateView();
	}
}
