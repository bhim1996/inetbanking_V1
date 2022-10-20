package com.inetbanking.testcases;




import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	public String baseUrl=readconfig.getApplicationURL();
    public String username=readconfig.getusername();
    public String password=readconfig.getpassword();
    public static WebDriver driver;
    
   
    @Parameters("browser")
    @BeforeClass
    public void setup(String br) {
    	
    	
    	if(br.equals("chrome")) {
    		
    	
    		System.setProperty("webdriver.chrome.driver", readconfig.getchromepath());
    	    driver=new ChromeDriver();
    	}
    	else if(br.equals("firefox"))
    	{
    		System.setProperty("webdriver.gecko.driver", readconfig.getfirefoxepath());
        	driver=new FirefoxDriver();
    	
    	
    }
    	else if(br.equals("ie")) {
    		System.setProperty("webdriver.ie.driver", readconfig.getIEpath());
        	driver=new InternetExplorerDriver();
    	}
    	
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	driver.get(baseUrl);
    }
    
    @AfterClass
    public void tearDown() {
    	driver.quit();
    }
    
//  Take the Screenshot on test case failure  
    
    /*public void captureScreenshot(WebDriver driver,String tname) throws IOException {
    	TakesScreenshot ts=(TakesScreenshot)driver;
    	File source=ts.getScreenshotAs(OutputType.FILE);
    	File target=new File(System.getProperty("user.dir") + "/Screenshot/" + tname +".png");
    	FileUtils.copyFile(source, target);
    	System.out.println("Screenshot taken");
    	*/
    
//    public String random() {
//		String generate=RandomStringUtils.randomAlphabetic(8);
//		return generate;
//		
//	}
//	
//	public String random1() {
//		String generate=RandomStringUtils.randomNu(8);
//		return generate;
//		
//	}
    	
    }
    
    
    
    
    

