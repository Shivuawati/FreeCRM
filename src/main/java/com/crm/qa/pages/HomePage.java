package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//span[text()='Shivu S']")
	@CacheLookup //It will store the value "userNameLabel" in Cache memory but some 
	//times pages refreshes or dom elements changed means it give stale and element destroyed error. 
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[@href='/contacts']")
	WebElement contactsPreLink;
	@FindBy(xpath="//span[text()='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[@href='/contacts/new']")
	WebElement newContactsLink;
	
		
	@FindBy(xpath="//a[@href='/deals']")
	WebElement dealsPreLink;
	@FindBy(xpath="//span[text()='Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[@href='/tasks']")
	WebElement tasksPreLink;
	@FindBy(xpath="//span[text()='Tasks']")
	WebElement tasksLink;
	
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUsername() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() throws IOException {
		contactsPreLink.click();
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() throws IOException {
		dealsPreLink.click();
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() throws IOException {
		tasksPreLink.click();
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink() {
		newContactsLink.click();
	}
	

	
}
