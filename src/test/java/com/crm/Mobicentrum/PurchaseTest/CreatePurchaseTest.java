package com.crm.Mobicentrum.PurchaseTest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.Mobicentrum.GenericUtility.BaseClass;
import com.crm.Mobicentrum.GenericUtility.ExcelUtility;
import com.crm.Mobicentrum.GenericUtility.FileUtility;
import com.crm.Mobicentrum.GenericUtility.JavaUtility;
import com.crm.Mobicentrum.GenericUtility.WebDriverUtility;
import com.crm.Mobicentrum.PomRepository.ContactPage;
import com.crm.Mobicentrum.PomRepository.CreateNewContactPage;
import com.crm.Mobicentrum.PomRepository.CreateNewProductPage;
import com.crm.Mobicentrum.PomRepository.CreateNewPurchaseOrderPage;
import com.crm.Mobicentrum.PomRepository.CreateNewVendorPage;
import com.crm.Mobicentrum.PomRepository.HomePage;
import com.crm.Mobicentrum.PomRepository.ProductsPage;
import com.crm.Mobicentrum.PomRepository.PurchaseOrderInformation;
import com.crm.Mobicentrum.PomRepository.PurchaseOrderPage;
import com.crm.Mobicentrum.PomRepository.VendorsPage;

public class CreatePurchaseTest extends BaseClass {
	FileUtility fLib=new FileUtility();
	ExcelUtility eLib=new ExcelUtility();
	JavaUtility jLib=new JavaUtility();
	WebDriverUtility wLib=new WebDriverUtility();
	
	@Test(groups = "SmokeTest")
	public void CreatePurchaseOrderWithVendorAndContact() throws Throwable
	{
		HomePage hp=new HomePage(driver);
		VendorsPage vp=new VendorsPage(driver);
		CreateNewVendorPage cvp=new  CreateNewVendorPage(driver);
		ProductsPage p=new ProductsPage(driver);
		CreateNewProductPage cp=new CreateNewProductPage(driver);
		ContactPage cop=new ContactPage(driver);
		CreateNewContactPage conp=new CreateNewContactPage(driver);
		PurchaseOrderPage pp=new PurchaseOrderPage(driver);
		CreateNewPurchaseOrderPage cnp=new CreateNewPurchaseOrderPage(driver);
		PurchaseOrderInformation poi=new PurchaseOrderInformation(driver);
		
		hp.gotoMoreLink();
		hp.getVendor().click();

//create vendor
		vp.getCreateVendorImage().click();
		eLib.setDataToExcel("Vendors", 1, 1, "Soumya");
		int value = jLib.getRandomNumber();
		String vendorName = eLib.getDataFromExcel("Vendors", 1, 1);
		cvp.VendorNameTextManadtory(vendorName, value);
		cvp.getSaveButton().click();

//create product
		hp.getProductLink().click();
		p.getCreateProductImage().click();
		String pdctName = eLib.getDataFromExcel("Product", 1, 1);
		cp.createPrductwithName(pdctName,value);
		cp.getSaveButton().click();
		hp.gotoMoreLink();
//create contact		
		hp.getContactsLink().click();
		cop.getCreateContactImage().click();
		String contactName = eLib.getDataFromExcel("Contacts", 1, 2)+value;
		conp.createContactWithLNameManadatory(contactName);
		conp.getSaveButton().click();
		hp.gotoMoreLink();
//create Purchase
		hp.getPurchaseOrder().click();
		pp.getCreateNewPurchaseImg().click();
		eLib.setDataToExcel("Purchase", 1, 1, "New Purchase");
		String subject = eLib.getDataFromExcel("Purchase", 1,1)+value;
		cnp.subjectData(subject);

//select vendor name
		String purchaseTitle = driver.getTitle();
		cnp.getSelectLookup().click();
		String currentAddr = driver.getWindowHandle();
//storing window address in vendors page
		eLib.setDataToExcel("Vendors", 1, 2, currentAddr);
		String parewindowAddr = eLib.getDataFromExcel("Vendors", 1, 2);

//switch to child window and select vendor
		wLib.swithToWindow(driver, parewindowAddr);  
		cnp.getSearchFieldTxt().sendKeys(vendorName+value);
		cnp.getSearchButton().click();
		cnp.getSearchedVendor().click();

//back to parent window
		wLib.swithToWindow(driver, parewindowAddr);
		wLib.waitForElementTillTitleMatches(driver, purchaseTitle);
		
		cnp.getSelectContactLookup().click();
		wLib.swithToWindow(driver, parewindowAddr);
		
		cnp.getSearchContactTxt().sendKeys(contactName+value);
		cnp.getSearchNowBtn().click();
		
		cnp.getSelectedContact().click();
		wLib.HandleAlertWindowAndAccept(driver);

		
		//back to parent window
		Thread.sleep(5000);
				wLib.swithToWindow(driver, parewindowAddr);
				wLib.waitForElementTillTitleMatches(driver, purchaseTitle);

		//store address information in excel
				eLib.setDataToExcel("Purchase", 1, 2, "24/7 White Field,Bangalore-560007,Karanataka,India");
				String billingAddr = eLib.getDataFromExcel("Purchase", 1, 2);
				cnp.getAddressField().sendKeys(billingAddr);
				cnp.getCopyAddressData().click();

		//collecting item informations
			    cnp.getItemSerachLookup().click();
		        
		//go to child window and select product
				wLib.swithToWindow(driver, parewindowAddr);
				cnp.getItemSerachTxt().sendKeys(pdctName+value);
				cnp.getItemSearchButton().click();
				cnp.getSearchedProduct().click();

		//back to parent window
				wLib.swithToWindow(driver, parewindowAddr);
				wLib.waitForElementTillTitleMatches(driver, purchaseTitle);
				
				cnp.getItemQuantity().sendKeys("2");
				cnp.getSaveButton().click();
				String verificationText =poi.getVerificationText().getText();
				SoftAssert sa=new SoftAssert();
				sa.assertTrue(verificationText.contains(subject));
				System.out.println("purchase order created with vendor & contact successfully");
		
		}
}
	
	/*
	@Test(groups = "RegressionTest")
	public void CreatePurchaseOrderWithVendorNameTest() throws Throwable
	{
		HomePage hp=new HomePage(driver);
		VendorsPage vp=new VendorsPage(driver);
		CreateNewVendorPage cvp=new  CreateNewVendorPage(driver);
		ProductsPage p=new ProductsPage(driver);
		CreateNewProductPage cp=new CreateNewProductPage(driver);
		PurchaseOrderPage pp=new PurchaseOrderPage(driver);
		CreateNewPurchaseOrderPage cnp=new CreateNewPurchaseOrderPage(driver);
		PurchaseOrderInformation poi=new PurchaseOrderInformation(driver);
		
		hp.gotoMoreLink();
		hp.getVendor().click();

//create vendor
		vp.getCreateVendorImage().click();
		eLib.setDataToExcel("Vendors", 1, 1, "Soumya");
		String vendorName = eLib.getDataFromExcel("Vendors", 1, 1);
		int value = jLib.getRandomNumber();
		cvp.VendorNameTextManadtory(vendorName, value);
		cvp.getSaveButton().click();

//create product
		hp.getProductLink().click();
		p.getCreateProductImage().click();
		String pdctName = eLib.getDataFromExcel("Product", 1, 1);
		cp.createPrductwithName(pdctName,value);
		cp.getSaveButton().click();
		hp.gotoMoreLink();
		hp.getPurchaseOrder().click();
		pp.getCreateNewPurchaseImg().click();
		eLib.setDataToExcel("Purchase", 1, 1, "New Purchase");
		String subject = eLib.getDataFromExcel("Purchase", 1,1)+value;
		cnp.subjectData(subject);

//select vendor name
		String purchaseTitle = driver.getTitle();
		cnp.getSelectLookup().click();
		String currentAddr = driver.getWindowHandle();
//storing window address in vendors page
		eLib.setDataToExcel("Vendors", 1, 2, currentAddr);
		String parewindowAddr = eLib.getDataFromExcel("Vendors", 1, 2);

//switch to child window and select vendor
		wLib.swithToWindow(driver, parewindowAddr);
		cnp.getSearchFieldTxt().sendKeys(vendorName+value);
		cnp.getSearchButton().click();
		cnp.getSearchedVendor().click();

//back to parent window
		wLib.swithToWindow(driver, parewindowAddr);
		wLib.waitForElementTillTitleMatches(driver, purchaseTitle);

//store address information in excel
		eLib.setDataToExcel("Purchase", 1, 2, "24/7 White Field,Bangalore-560007,Karanataka,India");
		String billingAddr = eLib.getDataFromExcel("Purchase", 1, 2);
		cnp.getAddressField().sendKeys(billingAddr);
		cnp.getCopyAddressData().click();

//collecting item informations
	    cnp.getItemSerachLookup().click();
        
//go to child window and select product
		wLib.swithToWindow(driver, parewindowAddr);
		cnp.getItemSerachTxt().sendKeys(pdctName+value);
		cnp.getItemSearchButton().click();
		cnp.getSearchedProduct().click();

//back to parent window
		wLib.swithToWindow(driver, parewindowAddr);
		wLib.waitForElementTillTitleMatches(driver, purchaseTitle);
		
		cnp.getItemQuantity().sendKeys("2");
		cnp.getSaveButton().click();
		String verificationText =poi.getVerificationText().getText();
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(verificationText.contains(subject));
		System.out.println("purchase order created with vendor & contact successfully");
	}
	
	}*/
