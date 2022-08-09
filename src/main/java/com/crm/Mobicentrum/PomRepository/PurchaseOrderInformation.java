package com.crm.Mobicentrum.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderInformation {
 
	public PurchaseOrderInformation(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement verificationText;

	public WebElement getVerificationText() {
		return verificationText;
	}
	
}
