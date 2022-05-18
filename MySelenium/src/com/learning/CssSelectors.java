package com.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CssSelectors {
	
	@Test
	public void cssSelectorsTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-popup-blocking");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://google.com");
		driver.switchTo().frame(0);
		WebElement frame_sign = driver.findElement(By.xpath("//div[@class='WrcADd']"));
//		
//		
//		//driver.switchTo().frame(frame_sign);
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].style.border='2px solid red'",frame_sign);
//		js.executeScript("arguments[0].style.background='yellow'", frame_sign);
		js.executeScript("arguments[0].setAttribute('style','border:2px solid red;background:yellow');", frame_sign);
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[aria-label='No thanks']")).click();
//		driver.get("https://demoqa.com/automation-practice-form");
		
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
//		driver.findElement(By.cssSelector("input#firstName")).sendKeys("Bhanu");
		
		driver.close();
		
		
	}

}
