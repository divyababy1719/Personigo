package com.crm.Mobicentrum.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendorPage {

	public CreateNewVendorPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy (name="vendorname")
	private WebElement vendorNameTxt;

	public WebElement getVendorNameTxt() {
		return vendorNameTxt;
	}
	@FindBy(name="button")
	private WebElement saveButton;
	
	public void VendorNameTextManadtory(String data,int value)
	{
		vendorNameTxt.sendKeys(data+value);
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
}
