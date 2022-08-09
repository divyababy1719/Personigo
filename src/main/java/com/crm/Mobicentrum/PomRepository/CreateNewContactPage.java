package com.crm.Mobicentrum.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {

	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="lastname")
	private WebElement lastnameTxtField;
	
	@FindBy (xpath="(//img[@title='Select'])[1]")
	private WebElement organizatonSelect;
	
	@FindBy(name="button")
	private WebElement saveButton;

	public WebElement getLastnameTxtField() {
		return lastnameTxtField;
	}

	public WebElement getOrganizatonSelect() {
		return organizatonSelect;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void createContactWithLNameManadatory(String data) 
	{
		lastnameTxtField.sendKeys(data);
	}

	
	
	
	
}
