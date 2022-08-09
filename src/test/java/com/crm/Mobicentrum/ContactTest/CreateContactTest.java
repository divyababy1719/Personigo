package com.crm.Mobicentrum.ContactTest;



import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.Mobicentrum.GenericUtility.BaseClass;
import com.crm.Mobicentrum.GenericUtility.ExcelUtility;
import com.crm.Mobicentrum.GenericUtility.FileUtility;
import com.crm.Mobicentrum.GenericUtility.JavaUtility;
import com.crm.Mobicentrum.GenericUtility.WebDriverUtility;
import com.crm.Mobicentrum.PomRepository.ContactInformationPage;
import com.crm.Mobicentrum.PomRepository.ContactPage;
import com.crm.Mobicentrum.PomRepository.CreateNewContactPage;
import com.crm.Mobicentrum.PomRepository.HomePage;

@Listeners(com.crm.Mobicentrum.GenericUtility.ListenerImplementation.class)
public class CreateContactTest extends BaseClass
{
	FileUtility fLib=new FileUtility();
	ExcelUtility eLib=new ExcelUtility();
	JavaUtility jLib=new JavaUtility();
	WebDriverUtility wLib=new WebDriverUtility();
	
	@Test(groups = "SmokeTest")
	public void CreateContactTest() throws Throwable
	{
		
		HomePage hp=new HomePage(driver);
		ContactPage cp=new ContactPage(driver);
		CreateNewContactPage cnp=new CreateNewContactPage(driver);
		ContactInformationPage cip=new ContactInformationPage(driver);
		hp.getContactsLink().click();
		cp.getCreateContactImage().click();
		int value = jLib.getRandomNumber();
		String data = eLib.getDataFromExcel("Contacts", 1, 2)+value;
		cnp.createContactWithLNameManadatory(data);
		cnp.getSaveButton().click();
		String text=cip.getVerifyText().getText();
		
		//SoftAssert sa=new SoftAssert();
	    assertTrue(text.contains(data));
		String title = driver.getTitle();
		wLib.takeScreenShot(driver,title);

	}


	@Test(groups = "RegressionTest")
	public void CreateAndDeleteContactTest() throws Throwable
	{
		HomePage hp=new HomePage(driver);
		ContactPage cp=new ContactPage(driver);
		CreateNewContactPage cnp=new CreateNewContactPage(driver);
		ContactInformationPage cip=new ContactInformationPage(driver);
        hp.getContactsLink().click();
		cp.getCreateContactImage().click();
		int value = jLib.getRandomNumber();
		String data=eLib.getDataFromExcel("Contacts", 1, 2)+value;
		
		cnp.createContactWithLNameManadatory(data);
		cnp.getSaveButton().click();
//delete created contact
		cip.getDeleteButton().click();
		wLib.HandleAlertWindowAndAccept(driver);
//verify contact deleted or not
	    cp.getSearchContactTxtbx().sendKeys(data+value);
	    WebElement textfield = cp.getSearchInDropdown();
		wLib.selectElement(textfield, "Last Name");
		cp.getSearchNowButton().click();
		
		boolean text = cp.getVerifyText().isDisplayed();
		//SoftAssert sa=new SoftAssert();
		assertTrue(text);
		System.out.println("contact created and deleted successfully");

	}
	
}
