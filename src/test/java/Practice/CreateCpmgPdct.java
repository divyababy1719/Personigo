package Practice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.Mobicentrum.GenericUtility.ExcelUtility;
import com.crm.Mobicentrum.GenericUtility.FileUtility;
import com.crm.Mobicentrum.GenericUtility.JavaUtility;
import com.crm.Mobicentrum.GenericUtility.WebDriverUtility;
public class CreateCpmgPdct {


	public static void main(String[] args) throws Throwable {
		
//Step 1:  open the browser and enter the vtiger url
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		wLib.wiatForElementimplicitily(driver);
		//open the browser,enter the url and login to application
		String url = fLib.getPropertyData("url");
		String un = fLib.getPropertyData("username");
		String pwd = fLib.getPropertyData("password");
		//Step 2: login to vtiger application
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
		

		
//Step 3: Naigate to product module
		driver.findElement(By.linkText("Products")).click();
		
//Step 4: click on "create  product" image 
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
//Step 5: Enter all the manadatory field and click on save button
		int value = jLib.getRandomNumber();
		String data = eLib.getDataFromExcel("Product", 1, 1);
		driver.findElement(By.name("productname")).sendKeys(data+value);
		driver.findElement(By.name("button")).click();
		
//Step 6:  click on "more" dropdown and navigate to "campaign" module
		WebElement src = driver.findElement(By.linkText("More"));
		wLib.moveToElemet(driver, src);
		driver.findElement(By.linkText("Campaigns")).click();
		
//Step 7:  click on "create campaign " image
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		
//Step 8:  Enter all the manadatory fields and click on "select " lookup it will navigate to product window
		String data1=eLib.getDataFromExcel("Campaign", 1, 1);
		driver.findElement(By.name("campaignname")).sendKeys(data1+value);
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		//String currentTiltle=driver.getTitle();
		String pwh = driver.getWindowHandle();
		eLib.setDataToExcel("Campaign", 1, 2, pwh);
		String parewindowAddr = eLib.getDataFromExcel("Campaign", 1, 2);
		
		wLib.swithToWindow(driver, parewindowAddr);
		
		
//Step 9:  search for the created product and and select it and click on "save" button
		driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(data1+value);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[@class='listFormHeaderLinks'][1]/../../..//tr[2]//td[1]//a[contains(text(),'HP Laptop')]")).click();
		
		
		wLib.swithToWindow(driver, parewindowAddr);
		//wLib.waitForElementTillTitleMatches(driver, currentTiltle);
		
		driver.findElement(By.name("button")).click();
		
//Step 10: verify wheather the campaign is created successfully 
		String verifytext = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(verifytext.contains(data1))
			System.out.println("campaign created successfully");
		else
			System.out.println("campaign not created");
		
		
//Step 11: Logout of the Vtiger application
		WebElement fsrc = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.moveToElemet(driver, fsrc);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}


/*
 * // It will return the parent window name as a String
String parent=driver.getWindowHandle();

Set<String>s=driver.getWindowHandles();

// Now iterate using Iterator
Iterator<String> I1= s.iterator();

while(I1.hasNext())
{

String child_window=I1.next();


if(!parent.equals(child_window))
{
driver.switchTo().window(child_window);

System.out.println(driver.switchTo().window(child_window).getTitle());

driver.close();
}

}
//switch to the parent window
 */


