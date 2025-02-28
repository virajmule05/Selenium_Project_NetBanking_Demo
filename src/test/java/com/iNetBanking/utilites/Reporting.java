package com.iNetBanking.utilites;


//Lister class
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext testContext)
	{
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); 
		String repName="Test-Report-"+timestamp+".html";
		htmlReporter.loadXMLConfig("C:\\Users\\HP\\eclipse-workspace\\iNetBanking\\src\\test\\java\\com\\iNetBanking\\utilites\\Reporting.java"+repName);
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "viraj");
		
		htmlReporter.config().setDocumentTitle("InetBanking Test Project ");
		htmlReporter.config().setReportName("Fuctional Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);//LOCATION of the chart
		htmlReporter.config().setTheme(Theme.DARK);
		
	}
	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());//crete new entry in the report
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN ));
	}
	public void onTestFailure(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());//crete new entrt in the report
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED ));
		
		String scrrenshotpath=".\\Screenshots"+tr.getName()+".png";
		
		File f=new File(scrrenshotpath);
		if(f.exists())
		{
			try {
				logger.fail("Screenshot is below:"+logger.addScreenCaptureFromPath(scrrenshotpath));
				
			 }
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void onTestSkipped(ITestContext tr)
	{
		logger=extent.createTest(tr.getName());//crete new entry in the report
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE ));
	}
	public void onFinish(ITestContext tr )
	{
		extent.flush();
	}
	
	

}
