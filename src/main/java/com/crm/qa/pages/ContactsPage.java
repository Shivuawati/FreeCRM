package com.crm.qa.pages;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	public ContactsPage() throws IOException {
//		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='selectable ' and text()='Contacts']")
	WebElement contactsLabel;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath="//div[@name='company']/input[@class='search']")
	WebElement companyName;
	
	@FindBy(xpath="//label[.='Status']/../div[@name='status']")
	WebElement status;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement saveButton;
	
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContact(String name) {
		driver.findElement(By.xpath("//a[ text()='"+ name +"']")).click();
	}
	
	public void selectStatusValue(String status) {
		driver.findElement(By.xpath("//div[@name='status']/span[text()='"+ status +"']")).click();
	}
	
	public void createNewContact(String ftName, String ltName, String cpName, String statusVal) {
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		companyName.sendKeys(cpName);
		status.click();
		selectStatusValue(statusVal);
		saveButton.click();
	}

}
