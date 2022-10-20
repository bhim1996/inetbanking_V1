package com.inetbanking.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobject.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) {//3]take the data from data provider and read the data and execute multiple time based upon the number of inputs
		
		LoginPage lp=new LoginPage(driver);

		lp.setUserName(user);
//		logger.info("user name provided")
		lp.setPassword(pwd);
//		logger.info("user pwd provided")
		lp.clickSubmit();
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();//close alaert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
//			logger.info("login failed")
			
		}
		else {
			Assert.assertTrue(true);
			lp.clickLogout();
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
		}
		
		
	}
	
	public boolean isAlertPresent() {//user defined method created to check alaert is present or not
		
		try {
		driver.switchTo().alert();
		return true;
		
	}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	String [][]getData() throws IOException{
		String path=System.getProperty("user.dir")+"provide the excel sheet path from test data";//<------
		
		int rownum=XLUtils.getRowCount(path, "sheet1");
		int colcount=XLUtils.getCellCount(path, "sheet1", 1);
		
		String logindata[][]=new String[rownum][colcount];//2] --->keep everything in two dimensional array
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				logindata[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j,path);//1]internally get the data from excel and -->
			}
		}
		return logindata;
	}
	

}
