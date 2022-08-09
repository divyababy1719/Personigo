package com.crm.Mobicentrum.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
WebDriver driver;
	public ContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
@FindBy(xpath="//img[@title='Create Contact...']")
private WebElement createContactImage;

//search for item deleted or not
@FindBy(name="search_text")
private WebElement searchContactTxtbx;

//element for dropdown
@FindBy (id="bas_searchfield")
private WebElement searchInDropdown;

//element for searchnow button
@FindBy (name="submit")
private WebElement searchNowButton;

//element for text verification
@FindBy (xpath="//span[contains(text(),'No Contact Found')]")
private WebElement verifyText;


public WebElement getCreateContactImage() {
	return createContactImage;
	
}

public WebElement getSearchContactTxtbx() {
	return searchContactTxtbx;
}

public WebElement getSearchInDropdown() {
	return searchInDropdown;
}

public WebElement getSearchNowButton() {
	return searchNowButton;
}

public WebElement getVerifyText() {
	return verifyText;
}




}
