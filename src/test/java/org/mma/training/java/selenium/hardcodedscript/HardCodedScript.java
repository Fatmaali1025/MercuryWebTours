package org.mma.training.java.selenium.hardcodedscript;

import java.util.List;
/**
 * ***********************
 * Author: Salma Akhter
 * Class Name: TestNewToursApp
 * Description: 
 * Reviewer Name:
 * Comments:
 * ***********************
 */
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HardCodedScript { 
	public WebDriver driver;
	public String baseurl = "http://sampleapp.tricentis.com/101/index.php";

	@Test (priority = 0)
	public void camperQuoteValidation () {
		try {
			// Enter Vehicle Data
			driver.findElement(By.linkText("Camper")).click();
			Thread.sleep(2000);
			String txt = driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[1]/div[1]/label")).getText();
			System.out.println(txt);
			
			Select camperMake = new Select(driver.findElement(By.name("Make")));
			camperMake.selectByVisibleText("Honda");
			Thread.sleep(2000);
			driver.findElement(By.name("[kW]")).sendKeys("222");
			Thread.sleep(2000);
			//driver.findElement(By.xpath("//*[@id=\"opendateofmanufacturecalender\"]/i")).click();
		//	Thread.sleep(5000);	
			//driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div")).click();
		//	Thread.sleep(5000);
		//	driver.findElement(By.linkText("02")).click();
	

			driver.findElement(By.name("Date of Manufacture")).sendKeys("10/02/2021");
			
			
			//driver.findElement(By.xpath("//*[@id=\"opendateofmanufacturecalender\"]/i")).sendKeys("11/02/2021");
			Thread.sleep(2000);
			Select numberOfSeats = new Select(driver.findElement(By.name("Number of Seats")));
			numberOfSeats.selectByVisibleText("4");
			Thread.sleep(2000);
			Select fuelType = new Select(driver.findElement(By.name("Fuel Type")));
			fuelType.selectByVisibleText("Petrol");
			Thread.sleep(2000);
			driver.findElement(By.name("Payload")).sendKeys("222");
			driver.findElement(By.name("Total Weight")).sendKeys("222");
			driver.findElement(By.name("List Price")).sendKeys("2222");
			driver.findElement(By.name("Annual Mileage")).sendKeys("2222");
			driver.findElement(By.name("Next (Enter Insurant Data)")).click();
			Thread.sleep(2000);
			// Validate that the user are on the [Enter Insurant Data] page
			WebElement enterInsurantDataPage = driver.findElement(By.name("Enter Insurant Data"));
			System.out.println(enterInsurantDataPage.getText());
			Assert.assertTrue(enterInsurantDataPage.isDisplayed(), "enterInsurantDataPage web element is not displayed");


			// Enter Insurant Data
			driver.findElement(By.name("First Name")).sendKeys("Tome");
			Thread.sleep(2000);
			driver.findElement(By.name("Last Name")).sendKeys("Cate");
			Thread.sleep(2000);
			driver.findElement(By.name("Date of Birth")).sendKeys("09/04/1999");
			Thread.sleep(2000);
			Select country = new Select(driver.findElement(By.name("Country")));
			country.selectByVisibleText("Afghanistan");
			Thread.sleep(5000);
			driver.findElement(By.name("Zip Code")).sendKeys("19981");
			Thread.sleep(2000);
			Select occupation = new Select(driver.findElement(By.name("Occupation")));
			occupation.selectByVisibleText("Farmer");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[10]/p/label[1]/span")).click();
			Thread.sleep(5000);
			driver.findElement(By.name("Next (Enter Product Data)")).click();
			Thread.sleep(2000);
			// Validate that the user are on the [Enter Insurant Data] page
			WebElement enterProductDataPage = driver.findElement(By.name("Enter Product Data"));
			System.out.println(enterProductDataPage.getText());
			Assert.assertTrue(enterProductDataPage.isDisplayed(), "enterProductDataPage web element is not displayed");

			// Enter Product Data
			driver.findElement(By.name("Start Date")).sendKeys("12/04/2021");
			Thread.sleep(5000);

			Select insuranceSum = new Select(driver.findElement(By.xpath("//*[@id=\"insurancesum\"]")));
			insuranceSum.selectByValue("7000000");
			// Thread.sleep(5000);
			Select damageInsurance = new Select(driver.findElement(By.xpath("//*[@id=\"damageinsurance\"]")));
			damageInsurance.selectByVisibleText("Full Coverage");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[3]/div[4]/p/label[1]/span")).click();
			// Thread.sleep(5000);
			driver.findElement(By.name("Next (Select Price Option)")).click();
			// Thread.sleep(2000);
			// Validate that the user are on the [Select Price Option] page
			WebElement selectPriceOptionPage = driver.findElement(By.name("Select Price Option"));
			System.out.println(selectPriceOptionPage.getText());
			Assert.assertTrue(selectPriceOptionPage.isDisplayed(), "selectPriceOptionPage web element is not displayed");

			driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tfoot/tr/th[2]/label[1]/span")).click();
			driver.findElement(By.name("Next (Send Quote)")).click();


			// Send Quote
			driver.findElement(By.name("E-Mail")).sendKeys("tomcat@yahoo.com");
			Thread.sleep(2000);
			driver.findElement(By.name("Username")).sendKeys("Tomcat");
			Thread.sleep(2000);
			driver.findElement(By.name("Password")).sendKeys("Tomcat1");
			Thread.sleep(2000);
			driver.findElement(By.name("Confirm Password")).sendKeys("Tomcat1");
			Thread.sleep(2000);
			driver.findElement(By.name("Send E-Mail")).click();
			Thread.sleep(2000);

			// Validate that the user are on the [Select Price Option] page
			WebElement confirmationMessage = driver.findElement(By.xpath("//h2[contains(text(),'Sending e-mail success!')]"));
			System.out.println(confirmationMessage.getText());
			Assert.assertTrue(confirmationMessage.isDisplayed(), "confirmationMessage web element is not displayed");

		} catch (Exception e) {
		}	
	} 

	@BeforeClass
	public void beforeClass(){
		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			driver.get(baseurl); // Navigate to the expected URL
			Thread.sleep(6000);
		} catch (Exception e) {
		}	
	}    

	
		@AfterClass
		public void afterClass(){
			try {
				driver.quit();
			} catch (Exception e) {
			}	  
		}
	 	 
}


