package com.iNetBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewAccountPage {
	WebDriver ldriver;

public AddNewAccountPage(WebDriver rdriver) {
		super();
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

    @FindBy(xpath="//a[text()='New Account']")
     WebElement linknewaccount;
    
    @FindBy(name="cusid")
    WebElement txtcustomerid;
    
    @FindBy(name="selaccount")
    WebElement dropdownaccounttype;
    
   @FindBy(name="inideposit")
   WebElement txtintialdeposit;
   
   @FindBy(name="button2")
   WebElement btnsubmit;
   
   public void clickNewAccount()
   {
	   linknewaccount.click();
   }
   
   public void custId(String custid)
   {
	   txtcustomerid.sendKeys(custid);
   }
   
   public void accountType(String accounttype)
   {
	   dropdownaccounttype.sendKeys(accounttype);
   }
   
   public void initaldeposit(String drposit)
   {
	   txtintialdeposit.sendKeys(drposit);
   }
   
   public void clickSubmit()
   {
	   btnsubmit.click();
   }
   
   
   
    
    
    
      
    
    

	

	
}
