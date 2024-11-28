package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testutil;
	ContactsPage contactsPage;
	public HomePageTest() throws IOException {
		super();
	}
	
//	Test Cases should be separated--> Independent with each other
//	Before each Test case --> Launch browser and login
//	@Test --> Execute Test case
//	After each test case close the browser
	
	
	@BeforeMethod
	public void setup() throws IOException {
		Initilization();
		loginPage = new LoginPage(); // Initialize one time and use in further steps
		homePage = new HomePage();  // Initialize one time and use in further steps
		testutil = new TestUtil();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test (priority = 1)
	public void verifyHomePageTitleTest() throws IOException {
//		homePage = new HomePage();
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home Page Title is not Matched.");
	}
	
	@Test (priority = 2)
	public void verifyUsernameTest() throws IOException {
//		homePage = new HomePage();
//		testutil.switchToFrame(locatoor); // If frame is there provide the frame name.
		Assert.assertTrue(homePage.verifyCorrectUsername());
	}
	
	@Test (priority = 3)
	public void verifyContactsLinkTest() throws IOException {
		contactsPage = homePage.clickOnContactsLink();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
