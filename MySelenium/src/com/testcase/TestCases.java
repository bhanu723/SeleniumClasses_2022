package com.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.helperclasses.HelperClasses;
import com.objectrepository.DemoWebElementsRepo;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {

	WebDriver driver;
	DemoWebElementsRepo repo;
	HelperClasses helper;
	String url;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		helper = new HelperClasses(driver);
		repo = new DemoWebElementsRepo();
	}

	// This test is to validate whether user is able to do Drag & Drop
	@Test(priority = 1)
	public void dragAndDropTesting() throws InterruptedException {

		url = "https://demo.guru99.com/test/drag_drop.html";
		helper.navigateToUrl(url);
		helper.implicitlyWait();

		WebElement dragMe = driver.findElement(repo.DRAG_ME);
		WebElement dropMe = driver.findElement(repo.DROP_ME);
		helper.dragNdrop(dragMe, dropMe);

		Assert.assertTrue(driver.findElement(repo.TABLE_DEBT_MOVEMENT).isDisplayed());
	}

	// This test is to ensure there is a tool tip and validation of contents of
	// tooltip
	@Test(priority = 2)
	public void TooltipValidation() throws InterruptedException {

		url = "https://demo.guru99.com/test/drag_drop.html";

		String expectedImageUrl = "img/eye.png";
		String actualImageUrl;

		String expectedTableData = "flowplayer-3.2.7.zip";
		String actualTableData;

		helper.navigateToUrl(url);
		helper.implicitlyWait();

		helper.clickAnElement(driver.findElement(repo.SELENIUM_HEADER_LINK));
		helper.clickAnElement(driver.findElement(repo.TOOLTIP));

		try {
			driver.switchTo().alert().dismiss();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No Alerts exists on the page");
		}
		SoftAssert softassert = new SoftAssert();
		//softassert.assertAll(driver.findElement(repo.DOWNLOAD_TOOLTIP));
		softassert.assertTrue(false, "Checking Softassert");
		helper.moveToElementMouse(driver.findElement(repo.DOWNLOAD_TOOLTIP));

		actualImageUrl = driver.findElement(repo.IMAGE).getAttribute("src");
		actualTableData = driver.findElement(repo.IMAGE_CONTENT).getText();

		// Validation of tool tip image
		Assert.assertTrue(actualImageUrl.contains(expectedImageUrl));
		softassert.assertEquals("Hello", "Hell","Not matching");
		
		// Validation of table content within tooltip
		Assert.assertEquals(actualTableData, expectedTableData);
		softassert.assertAll();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
