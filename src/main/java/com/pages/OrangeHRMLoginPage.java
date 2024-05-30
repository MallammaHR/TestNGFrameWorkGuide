package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMLoginPage
{
	WebDriver driver;
	
	@FindBy(name="username")
	private WebElement enterUserName;
	
	@FindBy(name="password")
	private WebElement enterpassword;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement clickOnLoginBTN;
	
	public OrangeHRMLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validLogintitle()
	{
		return driver.getTitle();
	}
	
	public void ValidLoginDetails(String un,String pw)
	{
		enterUserName.sendKeys(un);
		enterpassword.sendKeys(pw);
	}
	 public void cliOnLoginBTNN()
	 {
		 clickOnLoginBTN.click();
	 }
}
