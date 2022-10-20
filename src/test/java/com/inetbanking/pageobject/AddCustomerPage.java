package com.inetbanking.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver){               //Constructor
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);

}
	
	@FindBy(xpath="//a[text()='New Customer']")
	WebElement lnkAddNewCustomer;
	
	@FindBy(name="name")
	WebElement txtCustomerName;
	
	@FindBy(name="rad1")
	WebElement rdGender;
	
//	@FindBy(xpath="//a[text()='female']")
//	WebElement rdFemale;
	
	@FindBy(name="dob")
	WebElement txtdob;
	
	@FindBy(name="addr")
	WebElement txtaddr;
	
	@FindBy(name="city")
	WebElement txtcity;
	
	@FindBy(name="state")
	WebElement txtstate;
	
	@FindBy(name="pinno")
	WebElement txtpinno;
	
	@FindBy(name="telephoneno")
	WebElement txtteephonum;
	
	@FindBy(name="emailid")
	WebElement txtemailid;
	
	@FindBy(name="password")
	WebElement txtpassword;
	
	@FindBy(name="sub")
	WebElement txtsub;

	
	
	
	public void clkAddNewCust() {
		lnkAddNewCustomer.click();
		
	}
	
	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);
	}
	
	public void radiobuttonMale(String rmale) {
		rdGender.click();
	}
	
//	public void radiobuttonFemale(String rfemale)  {
//		rdFemale.click();
//		}
	
	public void custdob(	String mm,String dd,String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
		
	}
	
	public void custAddr(String custaddr) {
		txtaddr.sendKeys(custaddr);
	}
	
	public void custCity(String custcity) {
		txtcity.sendKeys(custcity);
	}
	
	public void custState(String cstate) {
		txtstate.sendKeys(cstate);
	}
	
	public void custPin(String cpin) {//(int cpin)
		txtpinno.sendKeys(cpin);      //txtpinno.sendKeys(String.valueof(cpin));//coverting int to string
	}
	
	public void mobilenumber(String mobnum) {
		txtteephonum.sendKeys(mobnum);
	}
	
	public void custEmail(String cemail) {
		txtemailid.sendKeys(cemail);
	}
	
	public void custPasswordd(String custpwd) {
		txtpassword.sendKeys(custpwd);
	}
	
	public void submitBtn() {
		txtsub.click();
		
	}

	
	
}
