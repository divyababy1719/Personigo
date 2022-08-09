package com.crm.Mobicentrum.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage {
public VendorsPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}
	@FindBy(xpath="//img[@title='Create Vendor...']")
	private WebElement createVendorImage;

	public WebElement getCreateVendorImage() {
		return createVendorImage;
	}
	
	
	
	
}
