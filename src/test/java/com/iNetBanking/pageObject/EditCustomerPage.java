package com.iNetBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
	
	
	WebDriver ldriver;

	public EditCustomerPage(WebDriver rdriver) {
		super();
		this.ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[text()='Edit Customer']")
	WebElement linkeditcustomer;
	
	@FindBy(name="cusid") 
	WebElement customerid;
	
	@FindBy(name="AccSubmit")
	WebElement btnsubmit;
	
	
	public void clickEditCustomer()
	{
		linkeditcustomer.click();
	}
	
	public void custId(String cid)
	{
		customerid.sendKeys(cid);
	}
	public void clickSubmit()
	{
		btnsubmit.click();
	}
	
	
	
	
	
}
