package com.iNetBanking.testCases;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.w3c.dom.DOMConfiguration;

import com.iNetBanking.utilites.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	
	public String url=readconfig.getApplicationUrl();
	
	public String username=readconfig.getUsername();
	
	public String password=readconfig.getPassword();
	
	public WebDriver driver;

	public static Logger logger;
	
	
	@Parameters("browser")
	
	@BeforeClass
	
	public void setup(String br)
	{
		
		//System.setProperty("WebDriver.Chrome.driver",readconfig.getchromepath());
         
       logger=Logger.getLogger("ebanking");
		
		DOMConfigurator.configure("Log4j.xml");
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		if(br.equals("chrome"))
		{
		driver=new ChromeDriver(options);
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		}
		
		else if(br.equals("firefox"))
		{
			driver=new FirefoxDriver();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
		
	}
	
	@AfterClass
	
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File("./Screenshots"+tname+".png");
		FileUtils.copyDirectory(source, target);
		System.out.println("screenshot taken");
	}
	public String randomstring()
	{
		String randomstring = RandomStringUtils.randomAlphabetic(5);
		return randomstring;
		
	}
	public static String randonnum()
	{
		String randomnum = RandomStringUtils.randomNumeric(8);
		return randomnum;
	}

	
}
