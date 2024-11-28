package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testutil;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";
	
	public ContactsPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		Initilization();
		loginPage = new LoginPage(); // Initialize one time and use in further steps
		contactsPage = new ContactsPage();  // Initialize one time and use in further steps
		testutil = new TestUtil();
		homePage = new HomePage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test (priority = 1)  //(invocationCount = 2) To repeat the same test to Run
	public void verifyContactsPage() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts Lable is missing on the Page");
	}
	
	@Test (priority = 2)
	public void selectSingleContact() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("(//*[@class='settings icon'])[1]"))).click(); //write to click some ele
		act.build().perform();
		//Thread.sleep(1000);
		driver.findElement(By.xpath("(//*[@class='settings icon'])[1]")).click(); //Just to have the focus
		contactsPage.selectContact("Shivu S Awati");
	}
	
	@DataProvider
	public Object [][] getCrmTestData() throws EncryptedDocumentException, IOException {
		Object data [][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test (priority = 3, dataProvider = "getCrmTestData")
	public void validateCreateNewContact(String ftName, String ltName, String cpName, String status) throws InterruptedException {
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact(ftName, ltName, cpName, status);
		Thread.sleep(5000);	
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
