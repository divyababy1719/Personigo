package com.crm.Mobicentrum.GenericUtility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.Mobicentrum.PomRepository.HomePage;
import com.crm.Mobicentrum.PomRepository.LoginPage;

public class BaseClass {

	FileUtility fLib=new FileUtility();
	WebDriverUtility wLib=new WebDriverUtility();
	ExcelUtility eLib=new ExcelUtility();
	JavaUtility jLib=new JavaUtility();
	DataBaseUtility dLib=new DataBaseUtility();
	
	public  WebDriver driver;
	public static WebDriver lDriver;

//establish database conncetion
	@BeforeSuite(groups= {"SmokeTest","RegressionTest"})
	public void ConnectDB() throws SQLException
	{
		System.out.println("Establish DB Conncection");
		dLib.connectDB();
	}
//open the browser
	//@Parameters("Browser")
	@BeforeClass(groups= {"SmokeTest","RegressionTest"})
	public void launchBrowser() throws Throwable 
	{
		/*String browser = fLib.getPropertyData("Browser");
		if (browser.equalsIgnoreCase("chrome")) 
			driver=new ChromeDriver();
		else if(browser.equalsIgnoreCase("Firefox"))
			driver=new FirefoxDriver();
		else
			driver=new ChromeDriver();
		System.out.println("Opening browser");*/
		
		  String browser = System.getProperty("browser", "chrome");

	        if(browser.contains("chrome")){
	            driver = new ChromeDriver();
	        }else
	        if(browser.contains("firefox")){
	            driver = new FirefoxDriver();
	        }

	    lDriver=driver;	
      //  driver=new ChromeDriver();
		driver.manage().window().maximize();
		wLib.wiatForElementimplicitily(driver);
	}
	
//Login to vtiger
	@BeforeMethod(groups= {"SmokeTest","RegressionTest"})
	public void login() throws Throwable
	{
		System.out.println("Login");
	  String url = fLib.getPropertyData("url");
	  String un = fLib.getPropertyData("username");
	  String pwd = fLib.getPropertyData("password");
	  LoginPage lp=new LoginPage(driver);
	  lp.loginToVtiger(url, un, pwd);
	}	 
//logout from vtiger
	
	@AfterMethod(groups= {"SmokeTest","RegressionTest"})
	public void logout()
	{
		System.out.println("Logout");
		HomePage hp=new HomePage(driver);
		hp.logoutFromVtiger();
	}
	
//close all the browsers
	@AfterClass(groups= {"SmokeTest","RegressionTest"})
	public void closeBroswer()
	{
		System.out.println("Close Browser");
		driver.quit();
	}
	
//Closing database connection	
	@AfterSuite(groups= {"SmokeTest","RegressionTest"})
	public void closeDB() throws SQLException 
	{
		System.out.println("Close DB Connection");
		dLib.closeDB();
	}
	
	
	
}
