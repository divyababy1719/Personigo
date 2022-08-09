package com.crm.Mobicentrum.CampaignTest;


import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.Mobicentrum.GenericUtility.BaseClass;
import com.crm.Mobicentrum.GenericUtility.ExcelUtility;
import com.crm.Mobicentrum.GenericUtility.FileUtility;
import com.crm.Mobicentrum.GenericUtility.JavaUtility;
import com.crm.Mobicentrum.GenericUtility.WebDriverUtility;
import com.crm.Mobicentrum.PomRepository.CampaignInformationPage;
import com.crm.Mobicentrum.PomRepository.CampaignPage;
import com.crm.Mobicentrum.PomRepository.CreateNewCampaignPage;
import com.crm.Mobicentrum.PomRepository.CreateNewProductPage;
import com.crm.Mobicentrum.PomRepository.HomePage;
import com.crm.Mobicentrum.PomRepository.ProductsPage;
@Listeners(com.crm.Mobicentrum.GenericUtility.ListenerImplementation.class)
public class CreateCampaignTest extends BaseClass {

	FileUtility fLib=new FileUtility();
	WebDriverUtility wLib=new WebDriverUtility();
	ExcelUtility eLib=new ExcelUtility();
	JavaUtility jLib=new JavaUtility();
	
	@Test(groups = "SmokeTest")
	public void CreateCampaignTest() throws Throwable
	{
		HomePage hp=new HomePage(driver);
		CampaignPage cp=new CampaignPage(driver);
		CreateNewCampaignPage cnp=new CreateNewCampaignPage(driver);
		CampaignInformationPage cip =new CampaignInformationPage(driver);

		hp.gotoMoreLink();
		hp.getCampaign().click();
		cp.getCreateCampaignImage().click();
		int value = jLib.getRandomNumber();
		String data = eLib.getDataFromExcel("Campaign", 1, 1)+value;
		cnp.createCampaignWithName(data);
		
		
		cnp.getSaveButton().click();
		//SoftAssert sa=new SoftAssert();
		String text = cip.getVerifyText().getText();
		assertEquals(text, data);
		System.out.println("verification passed");
		//sa.assertAll();
	}


	@Test(groups = "RegressionTest")
	public void CreateCampaignWithProduct() throws Throwable 
	{
		HomePage hp=new HomePage(driver);
		ProductsPage p=new ProductsPage(driver);
		CreateNewProductPage cp=new CreateNewProductPage(driver);
		CampaignInformationPage cip=new CampaignInformationPage(driver);
		hp.getProductLink().click();
		p.getCreateProductImage().click();

		//Step 5: Enter all the manadatory field and click on save button
		int value = jLib.getRandomNumber();
		String data = eLib.getDataFromExcel("Product", 1, 1);
		cp.createPrductwithName(data,value);
		cp.getSaveButton().click();

		//Step 6:  click on "more" dropdown and navigate to "campaign" module
		wLib.wiatForElementimplicitily(driver); 
		hp.gotoMoreLink();
		hp.getCampaign().click();

		//Step 7:  click on "create campaign " image
		CampaignPage cmp=new CampaignPage(driver);
		cmp.getCreateCampaignImage().click();

		//Step 8:  Enter all the manadatory fields and click on "select " lookup it will navigate to product window
		String data1=eLib.getDataFromExcel("Campaign", 1, 1)+value;
		CreateNewCampaignPage crNwPg=new CreateNewCampaignPage(driver);
		crNwPg.createCampaignWithName(data1);
		crNwPg.getSelectProductImg().click();

		//switching windows
		String currentTiltle=driver.getTitle();
		String pwh = driver.getWindowHandle();
		eLib.setDataToExcel("Campaign", 1, 2, pwh);
		String parewindowAddr = eLib.getDataFromExcel("Campaign", 1, 2);
		wLib.swithToWindow(driver, parewindowAddr);

		//Step 9:  search for the created product and and select item and click on "save" button
		crNwPg.searchProductInChild(data1, value);
		crNwPg.getSearchNowBtn().click();
		crNwPg.getSelectedItem().click();
		wLib.swithToWindow(driver, parewindowAddr);
		wLib.waitForElementTillTitleMatches(driver, currentTiltle);
		Thread.sleep(5000);
		crNwPg.getSaveButton().click();

		//SoftAssert ba=new SoftAssert();
		
		String text = cip.getVerifyText().getText();
		assertEquals(text, data1);
		System.out.println("Campaign Created with product successfully");
		
		/*String title = driver.getTitle();
		wLib.takeScreenShot(driver,title);*/

	}
}




