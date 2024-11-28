package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;




public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
//	public static EventFiringWebDriver e_driver;
//	public static WebEventListener eventListener;  // Since these are deprecated, implement new class for this
	
	
	public TestBase() throws IOException
	{
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\shivu\\eclipse-workspace\\HybridFramework\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e){
			e.printStackTrace();
		}	
	}


	public static void Initilization() {
		 String browserName = prop.getProperty("browser");
		 if(browserName.equals("chrome")) {
			 WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		     
		 } else if (browserName.equals("FF")) {
			 //WebDriverManager
			 //driver = new geckodriver();  
		 }
		 
//		 e_driver = new EventFiringDecorator().decorate(driver);
//		 //Now create Object of EventListenerHandle to register it with EventFiringWebDriver
//		 eventListener = new WebEventListerner();
//		 e_driver.register(eventListener);
//		 driver = e_driver;
		 
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICICT_WAIT));
		 
		 driver.get(prop.getProperty("url"));
		 
	}


}
 
