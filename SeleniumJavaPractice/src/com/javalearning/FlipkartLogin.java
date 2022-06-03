package com.javalearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FlipkartLogin {
	

	public String url = "https://www.flipkart.com/";

	public WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/bhanusurendradeepala/Downloads/chromedriver_V93");
		driver = new ChromeDriver();

		driver.get(url);
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void loginFlipkart() {
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("Hello");
	}

	@AfterTest
	public void closeBr()
	{
		driver.close();
		driver.quit();
	}

}
