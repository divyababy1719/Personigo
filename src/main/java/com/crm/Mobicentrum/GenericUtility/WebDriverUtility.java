package com.crm.Mobicentrum.GenericUtility;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is used to perform webdriver specific actions
 * @author JOLLU KISHORE
 *
 */
public class WebDriverUtility implements Iconstant {

	/* * This generic method is used to handle the synchronization by using implicit wait and it will wait for an element in DOM document
	 *  & release the control if element available 
	 * @param driver
	 */
	public void wiatForElementimplicitily(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
	}
	/**This generic method is used to handle the synchronization by using explicit wait and it will wait for an element till the url 
	 * contains particular condition
	 * @param driver
	 * @param partailPageURL
	 */
	public void waitForElementTillURLSatisfies(WebDriver driver,String partailPageURL)
	{
		WebDriverWait wait=new WebDriverWait(driver, explicitWaitTime);
		wait.until(ExpectedConditions.urlContains(partailPageURL));

	}
	/**
	 * This generic method is used to handle the synchronization by using explicit wait and it will wait for an element till the
	 * element is visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementTillElementVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, explicitWaitTime);
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	/**
	 * This generic method is used to handle the synchronization by using explicit wait and it will wait for an element till the
	 * title of webpage is matching
	 * @param driver
	 * @param actualTitle
	 */
	public void waitForElementTillTitleMatches(WebDriver driver,String actualTitle)
	{
		WebDriverWait wait=new WebDriverWait(driver, explicitWaitTime);
		wait.until(ExpectedConditions.titleIs(actualTitle));
	}
	/**
	 * This generic method is used to handle the synchronization by using explicit wait and it will wait for an element till the
	 * title of webpage is matching
	 * @param driver
	 * @param actualTitle
	 */
	public void waitForElementTillTitleSatisfies(WebDriver driver,String actualTitle)
	{
		WebDriverWait wait=new WebDriverWait(driver, explicitWaitTime);
		wait.until(ExpectedConditions.titleContains(actualTitle));
	}
	/**
	 * Generic method for Custom wait
	 * @param element
	 */
	public void customWaitForElementDisplayed(WebElement element) {
		int i=0;
		while(i<100) {
			try {
				element.isDisplayed();
				break;
			}
			catch(Exception e) {
				i++;
			}
		}
	}
	/**
	 *  used to Switch to Any Window based on Window Title
	 * @param driver
	 * @parampartialWindowTitle
	 */
	public void swithToWindow(WebDriver driver , String parewindowAddr) {
		Set<String>set = driver.getWindowHandles();
		Iterator<String>it = set.iterator();

		while (it.hasNext()) {
			String wID = it.next();
			driver.switchTo().window(wID);
			String currentWindowAddress= driver.getTitle();
			if(currentWindowAddress.contains(parewindowAddr)) {
				break;
			}
		}
	}
	/**This generic method is used to handle alert window and click on OK button
	 * @param driver
	 * @param expectedMsg
	 */
	public void HandleAlertWindowAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
		/*if(alert.getText().equals(expectedMsg))
			System.out.println("Successfully handled alert popup");
		else
			System.out.println("alert popup is not handled");*/
	}

	/**This generic method is used to handle alert window and click on CANCEL button
	 * @param driver
	 * @param expectedMsg
	 */
	public void HandleAlertWindowAndCancel(WebDriver driver,String expectedMsg)
	{
		Alert alert = driver.switchTo().alert();
		if(alert.getText().equals(expectedMsg))
			System.out.println("Successfully handled alert popup");
		else
			System.out.println("alert popup is not handled");
		alert.dismiss();
	}
	/**This generic method is used to move the mouse pointer to any element
	 * @param driver
	 * @param source
	 */
	public void moveToElemet(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);

		a.moveToElement(element).perform();
	}
	/**This generic method is used to right clicking on a particular element
	 * 
	 * @param driver
	 * @param source
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	/**
	 * 
	 * @param driver
	 * @param source
	 * @param target
	 */
	public void dragAndDrop(WebDriver driver,WebElement source,WebElement target)
	{
		Actions a=new Actions(driver);
		a.dragAndDrop(source, target);
	}
	public void doubleClick(WebDriver driver,WebElement element)

	{
		Actions a=new Actions(driver);
		a.doubleClick(element).perform();
	}
	/**This method is used to select a value from the drop down based on index
	 * 
	 * @param element
	 * @param index
	 */
	public void selectElement(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method is used to select a value from the drop down based on text
	 * @param element
	 * @param text
	 */
	public void selectElement(WebElement element,String value)
	{
		Select s=new Select(element);
		s.selectByVisibleText(value);
	}
	
	/**this method is used to take screenshot with webpage name
	 * 
	 * @param driver
	 * @param title
	 * @throws Exception
	 */
	public void takeScreenShot(WebDriver driver,String title) throws Exception
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File f=new File("./Screenshot/"+title+".png");
	    FileUtils.copyFile(source, f);
	}
}

