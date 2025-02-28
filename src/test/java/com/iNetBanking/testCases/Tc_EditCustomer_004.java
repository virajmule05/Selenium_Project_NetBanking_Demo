package com.iNetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.iNetBanking.pageObject.EditCustomerPage;
import com.iNetBanking.pageObject.LoginPage;

public class Tc_EditCustomer_004 extends BaseClass {

	
	@Test
	
	public void editCustomer() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		
		logger.info("username is provided");
		
		lp.setpass(password);
		
		logger.info("password is provided");
		
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		logger.info("Editing customer details!!!");
		
		EditCustomerPage editcust=new EditCustomerPage(driver);
		
		editcust.clickEditCustomer();
		
		editcust.custId("42962");
		
		editcust.clickSubmit();
		
		Thread.sleep(3000);
		
		boolean res = driver.getPageSource().contains("Edit Customer");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("testcase is passed !!");
		}
		else
		{
			logger.info("testcase is failed");
			driver.switchTo().alert().accept();
			Assert.assertTrue(false);
		}
	}
}
