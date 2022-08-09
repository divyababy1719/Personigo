package com.crm.Mobicentrum.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
public OrganizationInformationPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement verifyOrgText;

	public WebElement getVerifyOrgText() {
		return verifyOrgText;
	}
	
}
