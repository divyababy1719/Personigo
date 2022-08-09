package com.crm.Mobicentrum.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewPurchaseOrderPage {
	public CreateNewPurchaseOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy (name="subject")
	private WebElement subjectTextField;

	public WebElement getSubjectTextField() {
		return subjectTextField;
	}
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement selectLookup;
	
	@FindBy (xpath="//input[@id='search_txt']")
	private WebElement searchFieldTxt;
	
	@FindBy(name="search")
	private WebElement searchButton;
	
	@FindBy (xpath="//a[@class='listFormHeaderLinks']/../../..//tr[2]//a[@id='1']")
	private WebElement searchedVendor;
	
	@FindBy(xpath="(//img[@title='Select'])[2]")
	private WebElement selectContactLookup;
	
	@FindBy (xpath="//input[@id='search_txt']")
	private WebElement searchContactTxt;
	
	@FindBy(name="search")
	private WebElement searchNowBtn;
	
	@FindBy(xpath="//a[@class='listFormHeaderLinks']/../../..//tr[2]//a")
	private WebElement selectedContact;
	
	public WebElement getSelectedContact() {
		return selectedContact;
	}

	public WebElement getSearchContactTxt() {
		return searchContactTxt;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	public WebElement getSelectContactLookup() {
		return selectContactLookup;
	}
	@FindBy(name="bill_street")
	private WebElement addressField;
	
	@FindBy(xpath="(//input[@name='cpy'])[2]")
	private WebElement copyAddressData;
	
	@FindBy(id="searchIcon1")
	private WebElement itemSerachLookup;
	
	@FindBy (xpath="//input[@id='search_txt']")
	private WebElement itemSerachTxt;
	
	@FindBy(name="search")
	private WebElement itemSearchButton;
	
	@FindBy(xpath="//a[@class='listFormHeaderLinks'][1]/../../..//tr[2]/td[2]//a")
	private WebElement searchedProduct;
	
	@FindBy(id="qty1")
	private WebElement itemQuantity;
	
	@FindBy(name="button")
	private WebElement saveButton;
	
	
	
	
	public void subjectData(String data)
	{
		subjectTextField.sendKeys(data);
	}

	public WebElement getSelectLookup() {
		return selectLookup;
	}

	public WebElement getSearchFieldTxt() {
		return searchFieldTxt;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getSearchedVendor() {
		return searchedVendor;
	}

	public WebElement getAddressField() {
		return addressField;
	}

	public WebElement getCopyAddressData() {
		return copyAddressData;
	}

	public WebElement getItemSerachLookup() {
		return itemSerachLookup;
	}

	public WebElement getItemSerachTxt() {
		return itemSerachTxt;
	}


	public WebElement getItemSearchButton() {
		return itemSearchButton;
	}
	public WebElement getSearchedProduct() {
		return searchedProduct;
	}

	public WebElement getItemQuantity() {
		return itemQuantity;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	
}
