package com.learnAutomation.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory 
{
	public static WebDriver launchApp(WebDriver driver,String browserName,String appurl)
	{
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("ie"))
		{
			System.setProperty("webDriver.ie.driver","./driver/IEDriverServer.exe");
			driver=new InternetExplorerDriver();

		}
		else
		{
			System.out.println("Browser not Supported");
		}
		
		// Waits for the browser to load completely
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		//launch application url 
		driver.get(appurl);
		
		//waits to launch the application completely
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
	}
	
	//terminate whole browser session
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
	
	//closes current active tab of the browser
	public static void closeBrowser(WebDriver driver)
	{
		driver.close();
	}
	
}
