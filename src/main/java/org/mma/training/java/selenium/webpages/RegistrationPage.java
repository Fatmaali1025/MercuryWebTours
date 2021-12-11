package org.mma.training.java.selenium.webpages;
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
import org.mma.training.java.selenium.util.Helper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationPage {
	
	public WebDriver driver;
	public RegistrationPage(WebDriver driver){
		this.driver = driver;	
	}
	// Web elements - Registration page	
	@FindBy(linkText="REGISTER") WebElement registerHyperlink;
	@FindBy(name="firstName") WebElement firstNameInput;
	@FindBy(name="lastName") WebElement lastNameInput;
	@FindBy(name="phone") WebElement phoneNumberInput;
	@FindBy(name="userName") WebElement emailInput;
	@FindBy(name="address1") WebElement addressInput;
	@FindBy(name="city") WebElement cityInput;
	@FindBy(name="state") WebElement stateInput;
	@FindBy(name="postalCode") WebElement postalCodeInput;
	@FindBy(name="country") WebElement countryDrp;
	@FindBy(name="email") WebElement userNameInput;
	@FindBy(name="password") WebElement passwordInput;
	@FindBy(name="confirmPassword") WebElement confirmPasswordInput;
	@FindBy(name="submit") WebElement submitBtn;
	
	// Methods - Registration page
  @Test
  public void registrationPageElementsAndMethods(String fName, String lName, String pNumber, String eMail,
		  String address, String uCity, String uState, String pCode, String uCountry, String uName, 
		  String uPassword, String uConfirmPW) throws Exception{
	  try {
			Thread.sleep(4000); // Wait statement
			// Assert.assertTrue(systemLogo.isDisplayed(), "web element is not displayed");
			registerHyperlink.click();
			Thread.sleep(2000); // Wait statement
			firstNameInput.sendKeys(fName);
			lastNameInput.sendKeys(lName);
			phoneNumberInput.sendKeys(pNumber);
			emailInput.sendKeys(eMail);
			addressInput.sendKeys(address);
			cityInput.sendKeys(uCity);
			stateInput.sendKeys(uState);		
			postalCodeInput.sendKeys(pCode);
			
			 Select selectCountry = new Select (countryDrp);
			 selectCountry.selectByVisibleText(uCountry);
			
			 userNameInput.sendKeys(uName);
			 passwordInput.sendKeys(uPassword);
			 confirmPasswordInput.sendKeys(uConfirmPW);
			 Thread.sleep(2000); // Wait statement
			 Helper.captureScreenshot(driver);
			// Create object of WebDriver class
			WebDriverWait waitSubmitBtn = new WebDriverWait(driver,240);
			// wait until element is visible/enable
			waitSubmitBtn.until(ExpectedConditions.elementToBeClickable(submitBtn));
			submitBtn.click();
			Thread.sleep(2000); // Wait statement
			// System.out.println("Validate the confirmation message is-> "+confirmationMessage.getText()); 
			// Assert.assertTrue(confirmationMessage.isDisplayed(), "confirmationMessage web element is not displayed");	
			
			
	        //goto url

	        // driver.get("http://demo.guru99.com/V4/");

	        //Call take screenshot function

	        // this.takeSnapShot(driver, "c://test.png") ;    
	        //Helper.captureScreenshot(driver);
		} catch (InterruptedException e) {
		}	
	}
  public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

      //Convert web driver object to TakeScreenshot

      TakesScreenshot scrShot =((TakesScreenshot)webdriver);

      //Call getScreenshotAs method to create image file

              File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
              

          //Move image file to new destination

              File DestFile=new File(fileWithPath);

              //Copy file at destination

              FileUtils.copyFile(SrcFile, DestFile);

  }	



/**
* *********************************************************************
* End of the file
* *********************************************************************
*/
}
