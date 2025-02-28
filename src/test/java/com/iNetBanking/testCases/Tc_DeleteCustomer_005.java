package com.iNetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.iNetBanking.pageObject.DeleteCustomerPage;
import com.iNetBanking.pageObject.LoginPage;

public class Tc_DeleteCustomer_005 extends BaseClass {
	
	@Test
	
	public void deleteCustomer() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		
		lp.setUsername(username);
		logger.info("username is updated");
		lp.setpass(password);
		logger.info("password is used");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		
		logger.info("Delete the customer details!!!!");
		DeleteCustomerPage dc=new DeleteCustomerPage(driver);
		
		dc.clickCustomer();
		
		dc.custId("42962");
		
		dc.clickSubmit();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		boolean res = driver.getPageSource().contains("Delete Customer Form");
		
		if(res==true)
		{
			
			Assert.assertTrue(true);
			logger.info("testcase is passed!!");
		}
		else
		{
			logger.info("testcase is failed!!");
			Assert.assertTrue(false);
		}
		
	}

}
