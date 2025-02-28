package com.iNetBanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.iNetBanking.pageObject.AddCustomerPage;
import com.iNetBanking.pageObject.LoginPage;

public class Tc_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
	
	LoginPage lp=new LoginPage(driver);
	
	lp.setUsername(username);
	logger.info("username is provided");
	
	lp.setpass(password);
	logger.info("password is provided");
	lp.clickSubmit();
		
	Thread.sleep(3000);
	
	AddCustomerPage addcust=new AddCustomerPage(driver);
	
	addcust.clickAddNewCustomer();
	
	logger.info("Adding customer details!");
	
	addcust.custName("viraj");
	addcust.custgender("male");
	addcust.custdob("21","08","1998");
	Thread.sleep(3000);
	addcust.custaddress("INDIA");
	addcust.cuscity("Dharashiv");
	addcust.custstate("maharashtra");
	addcust.custpinno("41360555");
	addcust.custtelephoneno("1234567890");
	
	String email = randomstring()+"@gmail.com";
	addcust.custemail(email);
	addcust.custpass("abcd");
	addcust.custsubmit();
	Thread.sleep(3000);
	
	logger.info("validation is started...");
	boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
	if(res==true)
	{
		Assert.assertTrue(true);
		logger.info("Testcase is passed");
	}
	else
	{
		logger.info("testcase is failed");
		captureScreen(driver,"addNewCustomer");
		
		Assert.assertFalse(false);
		
	}
	
	}
	
	
}
