package com.learning;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Waits {
	
	
/*
 * Learning: 
 * Implicitwait in selenium4
 * Explicitwait in selenium4
 * Fluientwait in selenium4
 *  
 * 
 * resource: https://www.seleniumeasy.com/selenium-tutorials/waits-and-timeout-selenium-4
 */
	//@Test
	public void implicitwaitsTest()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(50));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String url = "https://google.com";
		driver.get(url);
		
		System.out.println(driver.getTitle());
		driver.quit();
		
	}
	
	@Test
	public void explicitwaitTest() {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String url="https://google.com";
		
		driver.get(url);
		WebElement search = driver.findElement(By.name("q"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(search));
		search.sendKeys("Automation Testing");
		
		//WebElement x = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[3]/div/span/svg/path"));
		//wait.until((ExpectedConditions.visibilityOf(x)));
		//x.click();
		
		
	}
	
}
