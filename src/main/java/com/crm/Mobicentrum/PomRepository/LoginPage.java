package com.crm.Mobicentrum.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	private WebElement userName;
	
	@FindBy(name="user_password")
	private WebElement password;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	
	public WebElement getUserName() {
		return userName;
	}


	public WebElement getPassword() {
		return password;
	}


	public WebElement getLoginBtn() {
		return loginBtn;
	}

//creating business utility method for login to the vtiger application
	public void loginToVtiger(String url,String un,String pwd)
	{
		driver.get(url);
		userName.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
	}
	
	
}
