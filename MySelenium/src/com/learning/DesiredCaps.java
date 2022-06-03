package com.learning;

import java.util.Collections;

import org.bouncycastle.crypto.kems.ECIESKeyEncapsulation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
 * The Chromeoptions Class is a concept in Selenium WebDriver for manipulating various properties 
of the Chrome driver. The Chrome options class is generally used in conjunction 
with Desired Capabilities for customizing Chrome driver sessions. 
It helps you perform various operations like opening Chrome in maximized mode, disable existing extensions, disable pop-ups, etc.
*
*/

public class DesiredCaps {
	
	WebDriver driver;
	DesiredCapabilities caps;
	
	String url= "https://cacert.com";
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "libs\\chromedriver.exe");
		
		caps = new DesiredCapabilities();
		caps.setCapability("ignoreProtectedModeSettings", true);
		caps.setAcceptInsecureCerts(true);

		ChromeOptions options = new ChromeOptions();
		
		options.setAcceptInsecureCerts(true);
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//		options.setAcceptInsecureCerts(true);
		
		options.addArguments("--start-maximized");
		options.setCapability("ignoreProtectedModeSettings", true);											
		options.addArguments("--incognito");
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-popup-blocking");
		
		
		
		//options.addArguments("disable-infobars"); // this is deprecated since chrome 76 version
		
		//Below options will hide informational bar that says ' Controlled by Automation...'
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.setExperimentalOption("useAutomationExtension", false);
				
		/*
		options.setHeadless(true);
		options.addArguments("--headless");
		*/
		
		
//		String browserName = options.getBrowserName();
//		String browserVer  = options.getBrowserVersion();
		
//		System.out.println(browserName);
//		System.out.println(browserVer);
		
//		options.merge(caps);
		
		driver = new ChromeDriver(options);
		
	}
	
	
	@Test
	public void launchInsecure() {
		driver.get(url);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
