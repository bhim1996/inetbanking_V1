package com.inetbanking.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver){               //Constructor
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")                         //Identification
	WebElement txtUserName;
	
	@FindBy(name="password")
	WebElement txtpasswordName;
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	@FindBy(xpath="//a[text()='Log out']")
	WebElement linLogout;
	
	
	public void setUserName(String uname) {      //Action Method
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		txtpasswordName.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		btnLogin.click();	
	}

	public void clickLogout() {
		linLogout.click();	
	}

}
