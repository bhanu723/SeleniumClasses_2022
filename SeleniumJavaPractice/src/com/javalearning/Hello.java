package com.javalearning;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hello {

	public static void main(String[] args) {
		
		//System.out.println("Hello!!!");
		
		System.setProperty("webdriver.chrome.driver", "/Users/bhanusurendradeepala/Downloads/chromedriver_V92");
		WebDriver driver = new ChromeDriver();
		
		try{
			String url = "https://www.facebook.com/reg";
			String title_expected = "Sign Up for Facebook | Facebook";
	
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			
			driver.get(url);
			driver.manage().window().maximize();
			String title_actual=driver.getTitle();
			System.out.println(title_actual);
			if(title_expected.contentEquals(title_actual))
				System.out.println("TC is Passed, Facebook Page is successfully launched");
			
			WebElement txtBox_name = driver.findElement(By.name("firstname"));
//			WebElement txtBox_name = driver.findElement(By.xpath("//*[@name='firstname']"));
			txtBox_name.sendKeys("Bhanu");
//			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", txtBox_name);
			WebElement button_gender = driver.findElement(By.xpath("//span/span[2]/label"));
			button_gender.click();
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", button_gender);
			
			}
		catch(Exception e){
			System.out.println("=================================================");
			System.out.println("An exception occured.... please read error below");
			System.out.println(e);
			System.out.println("=================================================");
			
			}
		
		finally{
			driver.close();
			driver.quit();
			}
		
	}

}
