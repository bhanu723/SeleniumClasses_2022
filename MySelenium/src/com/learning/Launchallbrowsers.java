package com.learning;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/* Learnings:-
 * 
 * Add external jars or Junit to classpath not modulepath
 * 2 different ways of launching browser
 * 		1.Use of setProperty with key(webdriver.chrome.driver) and value(driver path)
 * 		2.Use of WebDriverManager().chromedriver().set() - need to add webdrivermanager jars
 * How to do detailed Console logging using verboseLogging using setProperty 
 * ChromeOptions
 * 
 * resource for WebDriverManager: https://www.toolsqa.com/selenium-webdriver/webdrivermanager/
 * 
 * Created 4 Tests for all browsers:
 * 1.Chrome
 * 2.Firefox
 * 3.Edge
 * 4.Chrome-Headless mode
 * 
 */

public class Launchallbrowsers {

	@Test
	public void launch_chromebrowser_using_setproperty() {
		
		System.setProperty("webdriver.chrome.driver", "libs\\chromedriver.exe");
		
		// System.setProperty("webdriver.chrome.verboseLogging", "true"); 
		// This is for detailed logging in console
		
		// One way of running browser in headless mode calling setHeadless method
		ChromeOptions co = new ChromeOptions();
		co.setHeadless(true);
		
		WebDriver driver = new ChromeDriver(co);//launch chrome browser
		driver.manage().window().maximize(); //Maximize window
		driver.manage().deleteAllCookies(); // Delete all cookies
		
		String url = "https://www.google.com/"; // enter url in the address bar of browser
		driver.get(url);
		String title = driver.getTitle();
		System.out.println(title);
		driver.quit();
		
	}
	
	
	@Test
	public void launch_firefoxbrowser_using_setproperty() {
		
		System.setProperty("webdriver.gecko.driver", "libs\\geckodriver.exe");
		
		//System.setProperty("webdriver.chrome.verboseLogging", "true"); 
		// This is for detailed logging in console
		
				
		WebDriver driver = new FirefoxDriver();//launch chrome browser
		driver.manage().window().maximize(); //Maximize window
		driver.manage().deleteAllCookies(); // Delete all cookies
		
		String url = "https://www.google.com/"; // enter url in the address bar of browser
		driver.get(url);
		String title = driver.getTitle();
		System.out.println(title);
		driver.quit();
		
	}
	
	@Test
		public void launch_edgebrowser_using_setproperty() {
			
			System.setProperty("webdriver.edge.driver", "libs\\msedgedriver.exe");
			
			//System.setProperty("webdriver.chrome.verboseLogging", "true"); 
			// This is for detailed logging in console
			
					
			WebDriver driver = new EdgeDriver();//launch chrome browser
			driver.manage().window().maximize(); //Maximize window
			driver.manage().deleteAllCookies(); // Delete all cookies
			
			//driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS); // deprecated
			//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);  // deprecated
			
			String url = "https://www.google.com/"; // enter url in the address bar of browser
			driver.get(url);
			String title = driver.getTitle();
			System.out.println(title);
			driver.quit();
			
		}
		
		
	@Test
	public void launchbrowser_using_webdrivermanager() {
		WebDriverManager.chromedriver().setup();
		
		// One way of running browser in headless mode calling addArguments method
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--headless");
		
		WebDriver driver = new ChromeDriver(co);
		driver.manage().window().maximize(); //Maximize window
		driver.manage().deleteAllCookies(); // Delete all cookies
		
		
		String url = "https://www.google.com/";
		driver.get(url);
		String title = driver.getTitle();
		System.out.println(title);
		driver.quit();
		
	}



}
