package com.learnAutomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.learnAutoation.common.BaseClass;
import com.learnAutomation.util.BrowserFactory;
import com.learnAutomation.util.ExcelDataProvider;
import com.learnAutomation.webpages.LoginPage;

public class LoginTestCRM extends BaseClass
{
	WebDriver driver;
	
	@Test(priority=1)
	public void Testcase1()
	{
		//creation of test case reference into the extent report
		logger=report.createTest("TC01_Login to CRM");
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		
		//Provides description of the test steps
		logger.info("Starting application");
		loginPage.loginToCRM(excel.getStringData("login", 0, 0), excel.getStringData("login", 0, 1));
		
		logger.pass("Login Sucess");
		
	}
	
	
	@Test(priority=2)
	public void Testcase2()
	{
		//creation of test case reference into the extent report
		logger=report.createTest("TC02_Logout");
		
		logger.fail("Logout failed");
		
	}
}
