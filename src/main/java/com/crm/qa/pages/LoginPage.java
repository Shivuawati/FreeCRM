package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory
	@FindBy(name="email")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginButton;
	
	@FindBy(xpath="//span[.=' sign up']")
	WebElement signUpButton;
	
	@FindBy(xpath="//span[.='Start Here']")
	WebElement startHereButton;
	
	@FindBy(xpath="//b[.='Coforge']")
	WebElement logoText;
	
	//Initialization of Page Objects
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	} 
	
	public boolean validateCRMLogo() {
		return logoText.isDisplayed();
	}

	public HomePage login(String un, String pwd) throws IOException {
//		startHereButton.click();
		userName.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		return new HomePage();
	}
	
	
	
	
}
