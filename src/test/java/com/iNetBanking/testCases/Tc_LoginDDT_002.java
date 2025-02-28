package com.iNetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.iNetBanking.pageObject.LoginPage;
import com.iNetBanking.utilites.XLUtils;

public class Tc_LoginDDT_002 extends BaseClass {
	
	
	
	@Test(dataProvider="LoginData")
	
	public void loginDDT(String username,String pass) throws InterruptedException//  read the data execute multilple time
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("username");
		lp.setpass(pass);
		logger.info("pass");
		lp.clickSubmit();
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();//go to prvious page
			
			Assert.assertTrue(false);
			logger.warn("login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("login passed");
			
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();//focus on the login
		}
	}
	
	
	public boolean isAlertPresent()//user defined method is created alert is prsent or not
	{
		try {
		driver.switchTo().alert();
		return true;
		}
		catch (NoAlertPresentException e) {
			
			return false;
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@DataProvider(name="LoginData")//dataprovider marhos implmentation
	String[][]getData() throws IOException
	{
		String path="C:\\Users\\HP\\eclipse-workspace\\iNetBanking\\src\\test\\java\\com\\iNetBanking\\testData\\LoginData.xlsx";
	    
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		
		int colcount = XLUtils.getCellCount(path,"Sheet1", 1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
		
	
	}

}
