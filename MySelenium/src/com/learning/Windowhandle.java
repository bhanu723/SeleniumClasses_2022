package com.learning;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windowhandle {
	
	String url = "https://demoqa.com/browser-windows";
	
	
	@Test
	public void switch2newWindow() {
		
	WebDriverManager.firefoxdriver().setup();
	
	WebDriver driver = new FirefoxDriver();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.manage().deleteAllCookies();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	
	driver.get(url);
	
	WebElement WINDOWLINK = driver.findElement(By.id("windowButton"));
	WINDOWLINK.click();
	
	wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	
	String originalWindowhandle = driver.getWindowHandle(); 
	
	for(String windowHandle: driver.getWindowHandles()) {
		if(!originalWindowhandle.contentEquals(windowHandle)) {
			driver.switchTo().window(windowHandle);
			break;
		}
			
	}
	
//	WebElement h2Text = driver.findElement(By.id("sampleHeading"));
//	wait.until(ExpectedConditions.visibilityOf(h2Text));
	
	By h2 = By.id("sampleHeading");
	wait.until(ExpectedConditions.visibilityOfElementLocated(h2)); // This will check whether element is present in DOM and Length & Width of element is >0
	
	String pageSource = driver.getPageSource();
	System.out.println(pageSource);
	driver.close();
	driver.switchTo().window(originalWindowhandle);
	driver.close();
	
	//driver.quit();
	
	}

	//@Test
	public void createNewTab() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(url);
		String originalwindow = driver.getWindowHandle();
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(originalwindow);
		System.out.println(driver.getTitle());
		driver.close();
	}
	
	@Test
	public void createNewWindow() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(url);
		String originalwindow = driver.getWindowHandle();
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.navigate().to("https://amazon.com");
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(originalwindow);
		System.out.println(driver.getTitle());
		driver.close();
	}
	
	
	//@Test
	public void switch2newTab() {
		WebDriverManager.edgedriver().setup();
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		
		driver.get(url);
		String originalWindow = driver.getWindowHandle();
		
		WebElement NEWTAB = driver.findElement(By.id("tabButton"));
		
		NEWTAB.click();
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		for(String windowhandle: driver.getWindowHandles()) {
			if(!windowhandle.contentEquals(originalWindow)) {
				driver.switchTo().window(windowhandle);
				break;
			}
		}
		
		System.out.println(driver.getPageSource());
		driver.close();
		
		driver.switchTo().window(originalWindow);
		driver.close();
		
		
	}
}
