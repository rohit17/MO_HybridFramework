package com.learnAutomation.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage 
{
	WebDriver driver;
	
	public LoginPage(WebDriver local_driver)
	{
		this.driver=local_driver;
	}
	
	
	//----Creating "Login Page" Object Repository ---------
	
	@FindBy(name="username") WebElement uname;
	@FindBy(name="password") WebElement pass;
	@FindBy(xpath="//input[@value='Login']") WebElement loginButton;
	
	
	//----Creating "Login Page" Action Methods ---------
	
	public void loginToCRM(String Username_Application,String Password_Application)
	{
		uname.sendKeys(Username_Application);
		pass.sendKeys(Password_Application);
		loginButton.click();
		
	}
}
