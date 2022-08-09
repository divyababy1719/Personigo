package com.crm.Mobicentrum.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCampaignPage {
	WebDriver driver;
public CreateNewCampaignPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}
	
@FindBy (name="campaignname")
private WebElement campaignNameTxt;

@FindBy(xpath="//img[@title='Select']")
private WebElement selectProductImg;

@FindBy (xpath="//input[@id='search_txt']")
private WebElement searchPdctTxt;

@FindBy(name="search")
private WebElement searchNowBtn;

@FindBy(xpath="//a[@class='listFormHeaderLinks'][1]/../../..//tr[2]//td[1]//a")
private WebElement selectedItem;

@FindBy(name="button")
private WebElement saveButton;

public WebElement getCampaignNameTxt() {
	return campaignNameTxt;
}

public WebElement getSelectProductImg() {
	return selectProductImg;
}

public WebElement getSearchPdctTxt() {
	return searchPdctTxt;
}

public WebElement getSearchNowBtn() {
	return searchNowBtn;
}

public WebElement getSelectedItem() {
	return selectedItem;
}

public WebElement getSaveButton() {
	return saveButton;
}
public void createCampaignWithName(String data)
{
	campaignNameTxt.sendKeys(data);
}
public void searchProductInChild(String data,int value)
{
	searchPdctTxt.sendKeys(data+value);
	
}


}
