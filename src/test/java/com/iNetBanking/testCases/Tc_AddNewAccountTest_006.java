package com.iNetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.iNetBanking.pageObject.AddNewAccountPage;
import com.iNetBanking.pageObject.LoginPage;

public class Tc_AddNewAccountTest_006 extends BaseClass {
	
	@Test
	
	public void addNewAccount() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		
		lp.setUsername(username);
		logger.info("username is provided");
		
		lp.setpass(password);
		logger.info("password is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		logger.info("Add new  customer details!!!!");
		
		AddNewAccountPage newacc=new AddNewAccountPage(driver);
		
		newacc.clickNewAccount();
		Thread.sleep(3000);
		
		newacc.custId("42962");
		
		//newacc.accountType("saving");
		
		newacc.initaldeposit("15000");
		Thread.sleep(5000);
		
		newacc.clickSubmit();
		
		 Thread.sleep(5000);
		 
		 driver.switchTo().alert().accept();
		 
		 Thread.sleep(3000);
		 
		 boolean res = driver.getPageSource().contains("Add new account form");
		 if(res==true)
		 {
			 Assert.assertTrue(true);
			 logger.info("Test case is passed!!");
		 }
		 else
		 {
			 logger.info("Testcase is failed");
			 Assert.assertTrue(false);
		 }
			 
		 
	}

}
