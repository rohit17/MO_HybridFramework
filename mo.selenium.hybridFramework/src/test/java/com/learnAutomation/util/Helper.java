package com.learnAutomation.util;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper 
{
/*
 * This class will contain the code of all the custom functions functionality e.g. screenshot, handling frames, 
 * alerts etc, windows interaction(using AutoIT), sync issue, javascript executor etc
 * 
 * we make all the methods static here so that the methods can be accessed by the name of the class itself
 * 
 * */
	
	public static String captureScreenShot(WebDriver driver)
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenShotPath=System.getProperty("user.dir")+"/screenshot/CRM_"+getCurrentDateTime()+".png";
		
		try
		{
			FileHandler.copy(src,new File(screenShotPath));
		}
		
		catch(Exception e)
		{
			System.out.println("Unable to capture screenshot"+e.getMessage());
		}
		
		return screenShotPath;
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat currentFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date date=new Date();
		
		return currentFormat.format(date);
		
	}
	
	
	
	
}
