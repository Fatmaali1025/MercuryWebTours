package org.mma.training.java.selenium.webpages;
/**
 * *********************************************************************************
 * Author: Aya Turki
 * Class Name: Login page
 * Description: This class will store all the locator and methods of Login page
 * Reviewer Name:
 * Comments:
 * **********************************************************************************
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
public class LoginPage {

	public WebDriver driver;
	public LoginPage(WebDriver driver){
		this.driver = driver;	
	}
	// Web elements - Login page	
	@FindBy(xpath="//img[@alt='Mercury Tours']") WebElement systemLogo;
	@FindBy(xpath="//input[@name='userName']") WebElement userInput;
	@FindBy(xpath="//input[@name='password']") WebElement passInput;
	@FindBy(xpath="//input[@name='submit']") WebElement submitBtn;
	@FindBy(xpath="//h3[normalize-space()='Login Successfully']") WebElement confirmationMessage;
	
	
	@Test	
	public void loginPageElementsAndMethods(String uname, String pwd) {
		try {
			Thread.sleep(4000); // Wait statement

			// Methods - Login page
			Assert.assertTrue(systemLogo.isDisplayed(), "web element is not displayed");
			Thread.sleep(2000); // Wait statement
			userInput.sendKeys(uname);
			Thread.sleep(2000); // Wait statement
			passInput.sendKeys(pwd);
			
			// Create object of WebDriver class
			WebDriverWait waitSubmitBtn = new WebDriverWait(driver,240);
			// wait until element is visible/enable
			waitSubmitBtn.until(ExpectedConditions.elementToBeClickable(submitBtn));
			submitBtn.click();
			Thread.sleep(2000); // Wait statement
			System.out.println("Validate the confirmation message is-> "+confirmationMessage.getText()); 
			Assert.assertTrue(confirmationMessage.isDisplayed(), "confirmationMessage web element is not displayed");	
			
		} catch (InterruptedException e) {
		}	
	}
}

/**
 * *********************************************************************
 * End of the file
 * *********************************************************************
 */
