package org.mma.training.java.selenium.base;

/**
 * ********************************************************************************************************************
 * Author: Salma Akhter
 * Class Name: Base Class
 * Description: This class will store precondition (open browser) and post condition (open browser) of all the scripts
 * Reviewer Name:
 * Comments:
 * *********************************************************************************************************************
 */

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.mma.training.java.selenium.datadriven.TestDataUtil;
import org.mma.training.java.selenium.util.BrowserFactory;
import org.mma.training.java.selenium.util.Helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class BaseClass {


	public WebDriver driver;	
	public String Browser = "Chrome";
	public String baseurl = "http://demo.guru99.com/test/newtours/";


	@BeforeClass
	public void StartBrowser() {	
		try {
			driver = BrowserFactory.startApplication(driver, Browser, baseurl);

			Thread.sleep(2000);
			System.out.println(driver.getTitle());			
			Assert.assertEquals(driver.getTitle(), "Welcome: Mercury Tours");	
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
		}
	} 



	@AfterClass
	public void CloseBrowser() {	
		BrowserFactory.closeBrowser(driver);	 
	}


	@AfterMethod
	public void tearDownMethod (ITestResult result) {

		if (result.getStatus()== ITestResult.FAILURE) {
			Helper.captureScreenshot(driver);
		}

	}

	@DataProvider
	  public Iterator<Object[]> getLoginTestData() { 
		     ArrayList<Object[]> testData = TestDataUtil.getLoginTestData(); 
		     return testData.iterator(); }
	  
	  @DataProvider
	  public Iterator<Object[]> getRegistrationPage() { 
		     ArrayList<Object[]> testData = TestDataUtil.getRegistrationPage(); 
		     return testData.iterator(); }


}

/**
 * *********************************************************************
 * End of the file
 * *********************************************************************
 */
