package com.crm.Mobicentrum.GenericUtility;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener{
private ExtentReports report;
private ExtentTest test;

//AfterMethod
	public void onTestFailure(ITestResult result) 
	{
		String res=result.getMethod().getMethodName();
		EventFiringWebDriver edriv=new EventFiringWebDriver(BaseClass.lDriver);
		//TakesScreenshot ts=(TakesScreenshot) BaseClass.lDriver;
		File source = edriv.getScreenshotAs(OutputType.FILE);
		//LocalDateTime ltime = LocalDateTime.now();
		String dt = new Date().toString().replace(":", "_");
		File f=new File("./Screens/"+res+dt+".png");
	    try {
			FileUtils.copyFile(source, f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	    test.fail(result.getMethod().getMethodName());
	  test.fail(result.getThrowable()); 
	    test.addScreenCaptureFromPath(f.getAbsolutePath());
	}
	//BeforeTest
	public void onTestStart(ITestResult result)
	{
		test=report.createTest(result.getMethod().getMethodName());
		
	}
	//AfterMethod
	public void onTestSuccess(ITestResult result)
	{
		test.pass(result.getMethod().getMethodName()+"is passed");
	}

	//AfterMethod
	public void onTestSkipped(ITestResult result) 
	{
		test.skip(result.getMethod().getMethodName());
	}
//AfterMethod
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
	}

	public void onTestFailedWithTimeout(ITestResult result)
	{
	}

	//@BeforeTest
	public void onStart(ITestContext context) 
	{
		ExtentSparkReporter es=new ExtentSparkReporter("./extent-output/emailble-Report.html");
		es.config().setDocumentTitle("Extent Report for SampleExtends");
		es.config().setReportName("ExtentReporter-SampleExtends");
		es.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(es);
		report.setSystemInfo("Reporter:", "Divya");
		report.setSystemInfo("platform:", "windows 10");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("version", "103.0.5060.134");
		
		
		
	}

	//@AfterTest

	public void onFinish(ITestContext context)
	{
		report.flush();
	}
	

	

	
}
