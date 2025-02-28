package com.iNetBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage {
	
	WebDriver ldriver;

	public DeleteCustomerPage(WebDriver rdriver) {
		super();
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[text()='Delete Customer']")
	WebElement linkdeletecustomer;
	
	@FindBy(name="cusid")
	WebElement custid;
	
	@FindBy(name="AccSubmit")
	WebElement btnsubmit;
	
	public void clickCustomer()
	{
		linkdeletecustomer.click();
	}
	
	public void custId(String customerid)
	{
		custid.sendKeys(customerid);
	}
	public void clickSubmit()
	{
		btnsubmit.click();
	}
	
	
	

}
