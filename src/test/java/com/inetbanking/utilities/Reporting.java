package com.inetbanking.utilities;

//Listner class used to generate extents reports

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	
	
	public void setExtent(ITestContext testContext) {
		
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());//time stamp
		String repName="Test-Report"+timeStamp+".html";
		
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "extent-config.xml");
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "bhim");
		
		htmlReporter.config().setDocumentTitle("InetBanking Test Project");//title of report
		htmlReporter.config().setReportName("Functional Test Report");//name of the report
		
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	public void onTestSuccess(ITestResult tr) {
		logger=extent.createTest(tr.getName());//create new entry on the report
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));//
		String ScreenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		
		File f=new File(ScreenshotPath);
		
		if(f.exists()) {
			
			try {
				logger.fail("screenshot is below:"+logger.addScreenCaptureFromPath(ScreenshotPath));
				
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void onTestSkipped(ITestResult tr) {
		
		logger=extent.createTest(tr.getName());//create a new entry in the report
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
		
	}
	
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}


}
