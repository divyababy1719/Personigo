package com.crm.Mobicentrum.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizationPage {

	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy (name="accountname")
	private WebElement orgNameTxtbx;
	
	@FindBy(name="button")
	private WebElement saveButton;

	public WebElement getOrgNameTxtbx() {
		return orgNameTxtbx;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	public void FillOrgNametextBox(String data)
	{
		orgNameTxtbx.sendKeys(data);
	}
}
