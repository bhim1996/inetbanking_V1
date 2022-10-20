package com.inetbanking.testcases;


import static org.testng.Assert.assertTrue;

import org.junit.Assert;

import org.testng.annotations.Test;

import com.inetbanking.pageobject.AddCustomerPage;
import com.inetbanking.pageobject.LoginPage;



public class TC_AddCustomerTest_003 extends BaseClass{

	@Test
	public void addNewCustomer() throws InterruptedException {
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
//		logger.info("user name provided")
		lp.setPassword(password);
//		logger.info("password provided")
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.clkAddNewCust();
//		logger.info("providing customer details")
		addcust.custName("bhim");
		addcust.radiobuttonMale("male");
//		addcust.radiobuttonFemale("female");
		addcust.custdob("08", "18", "1996");
		addcust.custAddr("taligao");
		addcust.custCity("panjim");
		addcust.custState("goa");
		addcust.custPin("403002");
		addcust.mobilenumber("1234567891");
		addcust.custEmail("kcbhim76@gmail.com");
//		String email=random()+@gmail.com;
//		addcust.custEmail(email);
		addcust.custPasswordd("12345777");
		Thread.sleep(3000);
		addcust.submitBtn();
		
//		logger.info("validation started")
//		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
//		
//		if(res==true) {
//			Assert.assertTrue(true);
////			logger.info("test case is passed");
//		}
//		else {
////			CaptureScreen(driver,"addNewCustomer");
//			Assert.assertTrue(false);
////			logger.info("test case is failed");
//		}
	}
	
//	public String random() {
//		String generate=RandomStringUtils.randomAlphabetic(8);
//		return generate;
//		
//	}
//	
//	public String random1() {
//		String generate=RandomStringUtils.randomNumeric(8);
//		return generate;
//		
//	}
	
	
	
}
