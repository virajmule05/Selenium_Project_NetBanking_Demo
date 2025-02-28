package com.iNetBanking.testCases;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.iNetBanking.pageObject.LoginPage;

public class Tc_LoginTest_001 extends BaseClass {
	
	@Test
	
	public void loginTest() throws InterruptedException, IOException
	{
		driver.get(url);
		
     logger.info("url is opened");
		LoginPage lp=new LoginPage(driver);
		
		lp.setUsername(username);
		
		logger.info("username is sucessfully");
		

		lp.setpass(password);
		logger.info("pass is sucessfully");
		
		Thread.sleep(2000);
		
		lp.clickSubmit();
		
		String expected="Guru99 Bank Manager HomePage";
		
		String actual = driver.getTitle();
		System.out.println(actual);
		
		
		
		
		if(expected.equals(actual))
		{
			Assert.assertTrue(true);
			logger.info("title is matching");
		}
		
		else
		{
			//captureScrren( driver,"LoginTest");
			Assert.assertTrue(false);
			logger.info("title is not matching");
			
		}
	}
	

}
