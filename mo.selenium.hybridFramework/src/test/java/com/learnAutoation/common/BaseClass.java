package com.learnAutoation.common;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnAutomation.util.BrowserFactory;
import com.learnAutomation.util.ConfigDataProvider;
import com.learnAutomation.util.ExcelDataProvider;
import com.learnAutomation.util.Helper;

public class BaseClass 
{
	public WebDriver driver;
	
	//declaring object of ExcelDataProvider
	public ExcelDataProvider excel;
	
	//declaring object of ConfigDataProvider
	public ConfigDataProvider config;
	
	//declaring object of Extent report
	public ExtentReports report;
	
	//declaring object of log to capture log in extent reports
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupSuite()
	{
		//Setting up logs for the test cases
		Reporter.log("Test is getting ready",true);
		excel=new ExcelDataProvider();
		config=new ConfigDataProvider();
		
		//code for extent report
		ExtentHtmlReporter extent =new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/report/FreeCRM"+Helper.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Test execution started",true);
	}
	
	@BeforeClass
	public void setup()
	{
		Reporter.log("Trying to start browser",true);
		driver=BrowserFactory.launchApp(driver, config.getBrowser(), config.getTestingURL());
		Reporter.log("Browser is up and running",true);
	}
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void screenShotOnFailure(ITestResult result) throws IOException
	
	{
		Reporter.log("Test is about to end",true);
		//capture screenshot in case of failure
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		}
		//capture screenshot in case of success
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		}
		report.flush();
		
		Reporter.log("Test completed");
	}
}
