package com.crm.Mobicentrum.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage{
	WebDriver driver;
	public CreateNewProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="productname")
	private WebElement productNameTxt;
	
	@FindBy(name="button")
	private WebElement saveButton;

	public WebElement getProductNameTxt() {
		return productNameTxt;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void createPrductwithName(String data,int value)
	{
		productNameTxt.sendKeys(data+value);
	}
}
