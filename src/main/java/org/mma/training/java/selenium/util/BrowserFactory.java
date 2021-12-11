package org.mma.training.java.selenium.util;


/**
 * ***********************************************************************************
 * Author: Salma Akhter
 * Class Name: Browser Factory
 * Description: This class will store all the browsers to navigate the system
 * Reviewer Name:
 * Comments:
 * ***********************************************************************************
 */


import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
  public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) {
  
  if(browserName.equals("Chrome"))
  {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
  }
 
  else if(browserName.equals("Firefox"))
  {
    WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver();
  
  }
  
  else if(browserName.equals("IE"))
  {
    WebDriverManager.iedriver().setup();
    driver = new InternetExplorerDriver();
  }
  
  else
  {
	  System.out.println("We do not support this browser");
  }
  
  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
  driver.manage().window().maximize();
  driver.get(appURL);
  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
  return driver;
  }
  
  public static void closeBrowser(WebDriver driver) {
	 driver.quit();
  }
}

/**
 * *********************************************************************
 * End of the file
 * *********************************************************************
 */

