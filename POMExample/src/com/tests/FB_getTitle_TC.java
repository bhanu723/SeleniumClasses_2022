package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FB_getTitle_TC {

	public String url = "https://www.facebook.com/reg";

	public WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/bhanusurendradeepala/Downloads/chromedriver_V93");
		driver = new ChromeDriver();

		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test(priority = 0, enabled = true)
	public void getTitle() {

		String title_expected = "Sign Up for Facebook | Facebook";
		try {

			String title_actual = driver.getTitle();
			System.out.println(title_actual);

			Assert.assertEquals(title_expected, title_actual);
//			Assert.assertTrue(false);

		} catch (Exception e) {
			System.out.println("=================================================");
			System.out.println("An exception occured.... please read error below");
			System.out.println(e);
			System.out.println("=================================================");

		}

	}

	@AfterTest
	public void quitBrowser() {
		driver.close();
		driver.quit();
	}

}
