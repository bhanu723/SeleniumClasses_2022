package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

	WebDriver driver;

	// Objects/Elements on the Facebook Registration page
	public static By txtBox_firstname = By.name("firstname");
	public static By radiobtn_gender = By.xpath("//span/span[2]/label");
	public static By drpdown_year = By.id("year");
	public static By drpdown_month = By.id("month");
	public static By drpdown_day = By.id("day");
	public static By btn_signup = By.name("websubmit");

	// Constructor - instantiation of class variable
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	// Methods that operate on the Registration page WebElements

	public void setFirstName(String strTextvalue) {
		driver.findElement(txtBox_firstname).sendKeys(strTextvalue);
	}

	public void selectRadiobutton() {
		driver.findElement(radiobtn_gender).click();
	}

	public void selectMonthDrpdown(String dropdownValue) {
		Select month = new Select(driver.findElement(drpdown_month));
		month.selectByVisibleText(dropdownValue);
	}

	public void selectDayDrpdown(String dropdownValue) {
			Select day = new Select(driver.findElement(drpdown_day));
			day.selectByVisibleText(dropdownValue);
	}

	public void selectYearDrpdown(String dropdownValue) {
		Select year = new Select(driver.findElement(drpdown_year));
		year.selectByVisibleText(dropdownValue);
	}

	public void clickButton()
	{
		driver.findElement(btn_signup).click();
	}


}
