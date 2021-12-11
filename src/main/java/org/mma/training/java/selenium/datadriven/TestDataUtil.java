package org.mma.training.java.selenium.datadriven;

import java.util.ArrayList;

import org.mma.training.java.selenium.util.Excel_Reader;

public class TestDataUtil {
	static Excel_Reader reader;
	
	 /* ***************************************************************************************************
	  *  Get data from Excel for Web Tours Login 
	  * ***************************************************************************************************
	  */ 
	    public static ArrayList<Object[]> getLoginTestData() {
	      ArrayList<Object[]> myData = new ArrayList<Object[]>();
	        try {
	        	reader = new Excel_Reader("./testdata/testdata.xlsx");
	        	//reader = new Excel_Reader("/InputDataFile/testdata.xlsx");
	              
	            }catch (Exception e) {
	              e.printStackTrace(); 
	            }
	        
	        for (int rowCnt = 2; rowCnt <= reader.getRowCount("LoginTestData"); rowCnt++) {
	        
	        String UserID = reader.getCellData("LoginTestData", "Username", rowCnt);
	        String Passwd = reader.getCellData("LoginTestData", "Password", rowCnt);         
	         
	        Object ob[] = {UserID, Passwd};	        
	        myData.add(ob);
	     
	     }
	return myData;
	    }
	 /* ***************************************************************************************************
	  *  Get data from Excel for Web Tours Registration 
	  * ***************************************************************************************************
	  */
	 
	    public static ArrayList<Object[]> getRegistrationPage() {
	      ArrayList<Object[]> myData = new ArrayList<Object[]>();
	        try {
	        	reader = new Excel_Reader("./testdata/testdata.xlsx");
	        	//reader = new Excel_Reader("/InputDataFile/testdata.xlsx");
	              
	            }catch (Exception e) {
	              e.printStackTrace(); 
	            }
	        
	        for (int rowCnt = 2; rowCnt <= reader.getRowCount("RegistrationPage"); rowCnt++) {
	        
	        String userFirstName = reader.getCellData("RegistrationPage", "FirstName", rowCnt);
	        String userLastName = reader.getCellData("RegistrationPage", "LastName", rowCnt);     
	        String userPhone = reader.getCellData("RegistrationPage", "Phone", rowCnt);
	        String userEmail = reader.getCellData("RegistrationPage", "Email", rowCnt);    
	        String userAddress = reader.getCellData("RegistrationPage", "Address", rowCnt);
	        String userCity = reader.getCellData("RegistrationPage", "City", rowCnt); 
	        String userState = reader.getCellData("RegistrationPage", "State", rowCnt);
	        String userPostalCode = reader.getCellData("RegistrationPage", "PostalCode", rowCnt);     
	        String userCountry = reader.getCellData("RegistrationPage", "Country", rowCnt);
	        String userID = reader.getCellData("RegistrationPage", "Username", rowCnt);      
	        String Passwd = reader.getCellData("RegistrationPage", "Password", rowCnt);   
	        String userConfirmPassword = reader.getCellData("RegistrationPage", "ConfirmPassword", rowCnt);
	        
	        Object ob[] = {userFirstName, userLastName, userPhone, userEmail, userAddress, userCity,
	        		userState, userPostalCode, userCountry, userID, Passwd, userConfirmPassword};	        
	        myData.add(ob); 
	     }
	return myData;
	    }
		
	

}
