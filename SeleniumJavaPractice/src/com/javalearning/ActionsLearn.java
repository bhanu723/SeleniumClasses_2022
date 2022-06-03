package com.javalearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActionsLearn {
	
	
	public String url = "https://demoqa.com/menu/";

	public WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/bhanusurendradeepala/Downloads/chromedriver_V93");
		driver = new ChromeDriver();

		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test
	public void menuHover() {

		Actions actions = new Actions(driver);
		WebElement menu = driver.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/a"));
		WebElement submenu = driver.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/ul/li[3]/a"));
		WebElement submenu2 = driver.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/ul/li[3]/ul/li[1]/a"));
		
		actions.moveToElement(menu).perform();
		
		actions.moveToElement(submenu).perform();
		
		actions.moveToElement(submenu2).perform();
		submenu2.click();
		
		
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}

}
