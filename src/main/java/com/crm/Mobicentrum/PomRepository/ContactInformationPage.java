package com.crm.Mobicentrum.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {

	
	public ContactInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement verifyText;
	
	@FindBy(name="Delete")
	private WebElement deleteButton;

	public WebElement getVerifyText() {
		return verifyText;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}
	
	
}
