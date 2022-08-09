package com.crm.Mobicentrum.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Mobicentrum.GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "Products")
	private WebElement productLink;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(name="Purchase Order")
	private WebElement purchaseOrder;
	
	@FindBy(name="Vendors")
	private WebElement vendor;
	
	@FindBy(name="Campaigns")
	private WebElement campaign;
	
	@FindBy (xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administartorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signout;
	

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getPurchaseOrder() {
		return purchaseOrder;
	}

	public WebElement getVendor() {
		return vendor;
	}

	public WebElement getCampaign() {
		return campaign;
	}
	public WebElement getSignout() {
		return signout;
	}
	
	
	public WebElement getAdministartorImg() {
		return administartorImg;
	}
	public void gotoMoreLink()
	{
		moveToElemet(driver, moreLink);
	}

	public void logoutFromVtiger()
	{
		
		moveToElemet(driver, administartorImg);
		signout.click();
	}
	
	
	
}
