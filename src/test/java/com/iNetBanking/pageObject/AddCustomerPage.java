package com.iNetBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver) {
		super();
		this.ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//a[text()='New Customer']")
	WebElement linkaddCustomer;
	
	@FindBy(name="name")
	WebElement txtcustomername;
	
	@FindBy(name="rad1")
	WebElement rdgender;
	
	@FindBy(id="dob")
	WebElement txtdob;
	
	@FindBy(name="addr")
	WebElement txtaddress;
	
	@FindBy(name="city")
	WebElement txtcity;
	
	@FindBy(name="state")
	WebElement txtstate;
	
	@FindBy(name="pinno")
	WebElement txtpin;
	
	@FindBy(name="telephoneno")
	WebElement txttelephone;
	
	@FindBy(name="emailid")
	WebElement txtemail;
	
	@FindBy(name="password")
	WebElement txtpass;
	
	@FindBy(name="sub")
	WebElement btnsubmit;
	
	public void clickAddNewCustomer()
	{
		linkaddCustomer.click();
	}
	public void custName(String cname) { 
	
		txtcustomername.sendKeys(cname);
	}
	public void custgender(String cgender)
	{
		rdgender.sendKeys(cgender);
	}
	public void custdob(String mm,String dd,String yy)
	{
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
		
	}
	public void custaddress(String caddress)
	{
		txtaddress.sendKeys(caddress);
	}
	public void cuscity(String ccity)
	{
		txtcity.sendKeys(ccity);
	}
	public void custstate(String cstate)
	{
		txtstate.sendKeys(cstate);
	}
	public void custpinno(String cpinno)
	{
		txtpin.sendKeys(String.valueOf(cpinno));//take int cpino
		
	}
	public void custtelephoneno(String ctelephoneno)
	{
		txttelephone.sendKeys(ctelephoneno);
	}
	public void custemail(String cemailid)
	{
		txtemail.sendKeys(cemailid);
	}
	public void custpass(String cpass)
	{
		txtpass.sendKeys(cpass);
	}
	public void custsubmit()
	{
		btnsubmit.click();
	}
	
	
	
	

}
