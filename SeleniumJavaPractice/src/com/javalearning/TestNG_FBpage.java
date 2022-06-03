package com.javalearning;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_FBpage {

	public String url = "https://www.facebook.com/reg";

	public WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/bhanusurendradeepala/Downloads/chromedriver_V92");
		driver = new ChromeDriver();

		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test(priority=0,enabled=true)
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

	@Test(priority=1, dependsOnMethods = {"getTitle"},enabled=true)
	public void registration() {
		WebElement txtBox_name = driver.findElement(By.name("firstname"));
		txtBox_name.sendKeys("Bhanu");
		highlightElement(driver, txtBox_name);
		WebElement button_gender = driver.findElement(By.xpath("//span/span[2]/label"));
		button_gender.click();
		highlightElement(driver, button_gender);
		
		WebElement drpdown_year = driver.findElement(By.id("year"));
		WebElement drpdown_month = driver.findElement(By.id("month"));
		WebElement drpdown_day = driver.findElement(By.id("day"));
		
		Select month = new Select(drpdown_month);
		month.selectByVisibleText("Jan");
		Select day = new Select(drpdown_day);
		day.selectByVisibleText("11");
		Select year = new Select(drpdown_year);
		year.selectByVisibleText("1980");
		
		WebElement btn_signup = driver.findElement(By.name("websubmit"));
		btn_signup.click();
		

	}

	@AfterTest
	public void quitBrowser() {
		driver.close();
		driver.quit();
	}

// This function is to highlight Webelement 
	public void highlightElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
	}

}
