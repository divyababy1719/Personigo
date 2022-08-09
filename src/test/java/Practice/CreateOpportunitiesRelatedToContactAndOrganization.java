package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.Mobicentrum.GenericUtility.ExcelUtility;
import com.crm.Mobicentrum.GenericUtility.FileUtility;
import com.crm.Mobicentrum.GenericUtility.JavaUtility;
import com.crm.Mobicentrum.GenericUtility.WebDriverUtility;

public class CreateOpportunitiesRelatedToContactAndOrganization {

	
		public static void main(String[] args) throws Throwable {
		     FileUtility fLib=new FileUtility();
		     ExcelUtility eLib=new ExcelUtility();
		     WebDriverUtility wLib=new WebDriverUtility();
		     JavaUtility jLib=new JavaUtility();
		     
		    WebDriver driver=new ChromeDriver();
		    driver.manage().window().maximize();
		    wLib.wiatForElementimplicitily(driver);
		    
		   String url = fLib.getPropertyData("url");
		   String un = fLib.getPropertyData("username");
		   String pwd = fLib.getPropertyData("password");
		   
		   driver.get(url);
		   driver.findElement(By.name("user_name")).sendKeys(un);
		   driver.findElement(By.name("user_password")).sendKeys(pwd);
		   driver.findElement(By.id("submitButton")).click();
		   
		   //click on opportunities link
		   driver.findElement(By.linkText("Opportunities")).click();
		   
		   //create new opportunity
		   driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
		     
		   //write opportunity name and read from excel 
		   
		   eLib.setDataToExcel("Opportunity",1,1,"Annual Discount");
		   String opportunityName = eLib.getDataFromExcel("Opportunity", 1, 1);
		   int randomValue = jLib.getRandomNumber();
		   driver.findElement(By.name("potentialname")).sendKeys(opportunityName+randomValue);
		   
		 }

	}


