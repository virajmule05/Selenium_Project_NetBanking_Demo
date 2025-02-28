package com.iNetBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(name="btnLogin")
	private WebElement loginbutton;
	
	
	@FindBy(xpath="//a[text()='Log out']")
	private WebElement logoutlink;
	
	public void setUsername(String uname)
	{
		username.sendKeys(uname);
	}
	
	public void setpass(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickSubmit() throws InterruptedException
	{
		Thread.sleep(2000);
		 loginbutton.click();
	}
	
	public void clickLogout1()
	{
		logoutlink.click();
	}

	public void clickLogout() {
		logoutlink.click();
		
	}
	
	

}
