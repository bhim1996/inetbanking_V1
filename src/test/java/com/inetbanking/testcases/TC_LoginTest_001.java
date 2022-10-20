package com.inetbanking.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobject.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() {
		
	LoginPage lp=new LoginPage(driver);
	lp.setUserName(username);
	lp.setPassword(password);
	lp.clickSubmit();
	
	if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
		Assert.assertTrue(true);
		
	}
	else {
//		captureScreenshot(driver,"TC_LoginTest_001");
		Assert.assertTrue(false);
		
	}
	}
}
