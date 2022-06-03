package com.tests;

import com.pages.*;
import com.helpermethods.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FB_registration_TC {

	public String url = "https://www.facebook.com/reg";
	public String driverpath = "/Users/bhanusurendradeepala/Documents/Selenium_Teaching_Deep/POMExample/utils/chromedriver_V93";
	WebDriver driver;
	RegistrationPage regpageObj ;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test(priority = 0, enabled = true)
	public void registration() {

		// Creating Object of RegistrationPage
		
		try {
			regpageObj = new RegistrationPage(driver);
			
			// Highlighting firstName field element on the page using reusable methods
			WebElement element = driver.findElement(regpageObj.txtBox_firstname);
			ReusableMethods.highlightElement(driver, element);
			
			regpageObj.setFirstName("Bhanu");
			regpageObj.selectRadiobutton();

			regpageObj.selectMonthDrpdown("Jan");
			regpageObj.selectDayDrpdown("10");
			regpageObj.selectYearDrpdown("2000");

			regpageObj.clickButton();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterTest
	public void quitBrowser() {
		driver.close();
		driver.quit();
	}

}
