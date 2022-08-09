package com.crm.Mobicentrum.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CampaignInformationPage {
	WebDriver driver;
public   CampaignInformationPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}
	/*@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement verifyText;*/
@FindBy(id="dtlview_Campaign Name")
private WebElement verifyText;
	
	public WebElement getVerifyText() 
	{
		return verifyText;
	}	
}
	

	
	
	
	
	

