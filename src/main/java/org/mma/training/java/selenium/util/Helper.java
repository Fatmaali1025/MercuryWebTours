package org.mma.training.java.selenium.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	//Screenshot, 
	
	public static void captureScreenshot (WebDriver driver) {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			System.out.println("user.dir - "+currentDir);
			FileUtils.copyFile(scrFile, new File(currentDir + "/Fatma/" + System.currentTimeMillis() + ".png"));
			
			
		      FileHandler.copy(src, new File("./Screenshots/WebTours" + getCurrentDateTime() +".png"));
		    } catch (IOException e) {
		    	
		    	System.out.println("Unable to capture screenshot  "+ e.getMessage());
		    }
	    }
	public static String getCurrentDateTime() {
	
	     DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
	     Date currentDate = new Date();
	     return customFormat.format(currentDate);
	     
		
	}

}