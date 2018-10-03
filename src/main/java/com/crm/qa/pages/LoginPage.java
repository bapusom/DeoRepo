package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//PageFactory - OR
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submitbtn;
	
	@FindBy(xpath="//img[contains(@class, 'img-responsive')]")
	WebElement crmlogo;
	
	
	//initialize the page objects
	public LoginPage() {
		PageFactory.initElements(d, this);
		
	}
	
	//Actions
	public String validateLoginPageTitle() {
		return d.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmlogo.isDisplayed();
	}
	
	public HomePage login(String UN, String PWD) {
		username.clear();
		username.sendKeys(UN);
		password.clear();
		password.sendKeys(PWD);
		loginbtn.click();
		
		return new HomePage();
	}
}
