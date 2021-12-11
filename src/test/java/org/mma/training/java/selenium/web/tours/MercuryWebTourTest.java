package org.mma.training.java.selenium.web.tours;
/**
 * *********************************************************************************
 * Author: Fatma Ali
 * Test Name: Registration page
 * Description: This class will store locators and methods of the test
 * Reviewer Name:
 * Comments:
 * **********************************************************************************
 */


import java.io.File;

import org.apache.commons.io.FileUtils;
import org.mma.training.java.selenium.base.BaseClass;
import org.mma.training.java.selenium.webpages.LoginPage;
import org.mma.training.java.selenium.webpages.RegistrationPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class MercuryWebTourTest extends BaseClass {
	/* ***************************************************************************************************
	 *  Test Name: Registration to the Mercury Web Tours
	 * ***************************************************************************************************
	 */
	
	@Test (priority=0, dataProvider="getRegistrationPage")
	
	
	public void registrationPageValidation(String userFirstName, String userLastName, String userPhone, String userEmail,
			String userAddress, String userCity, String userState, String userPostalCode, String userCountry, String userID, 
			String Passwd, String userConfirmPassword
			) throws Exception {
		
		RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
	    registrationPage.registrationPageElementsAndMethods(userFirstName, userLastName, userPhone, userEmail,
			userAddress, userCity, userState, userPostalCode, userCountry, userID, Passwd, userConfirmPassword);	
        		
	}
	
	/* ***************************************************************************************************
	 *  Test Name: Login to the Mercury Web Tours
	 * ***************************************************************************************************
	 */
	/*
	@Test (priority=1,dataProvider="getLoginTestData")
	
	public void loginPageValidation(String UserID, String Passwd) {
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.loginPageElementsAndMethods(UserID, Passwd);
	}
*/
	
	
	
	
}
