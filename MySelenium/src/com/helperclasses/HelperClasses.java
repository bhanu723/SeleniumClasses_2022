package com.helperclasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HelperClasses {

	WebDriver driver;
	
	public HelperClasses(WebDriver driver) {
		//super();
		this.driver = driver;
	}

	// This method is to explicitly wait for an element
	public void waitForElementtobeVisible(WebElement element) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Element not visible");
		}
	}

	

	// This method is to switch to window
	public void switchToWindow(String originalHandle) {
		// List<String> handles = (List<String>) driver.getWindowHandles();

		try {
			for (String handle : driver.getWindowHandles())
				if (!handle.contentEquals(originalHandle)) {
					driver.switchTo().window(handle);
					break;
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// This method is to split a string seperated by commas to an Array of Strings
	public String[] splitPipe(String str) {
		String[] strArray = null;
		if (str != null) {
			strArray = str.split(",");
		} else
			System.out.println("String is Empty");

		return strArray;

	}

	// This method is to move mouse to element
	public void moveToElementMouse(WebElement element) {
		Actions action = new Actions(driver);
		if (element.isDisplayed()) {
			action.moveToElement(element).perform();
		} else
			System.out.println("Element not visible");

	}

	// This method is to select a checkbox by visible text from the multi selection
	public void selectCheckboxByVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);

		try {
			if (element.isDisplayed()) {
				select.selectByVisibleText(visibleText);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// This method is to select a checkbox by index from the multi selection
	public void selectCheckboxbyIndex(WebElement element, int index) {
		Select select = new Select(element);

		try {
			if (element.isDisplayed()) {
				select.selectByIndex(index);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// This method is to select a checkbox by value from the multi selection
		public void selectCheckbox(WebElement element, String value) {
			Select select = new Select(element);
			
			try {
				if(element.isDisplayed()) {
					select.selectByValue(value);;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	// This method is to do drag & drop
		public void dragNdrop(WebElement dragMe, WebElement dropMe) {
			Actions action = new Actions(driver);
			try {
				if(dragMe.isEnabled() && dropMe.isEnabled()) {
					action.dragAndDrop(dragMe, dropMe).perform();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		// This method is to click any webelement
		public void clickAnElement(WebElement element) {
			try {
				if(element.isEnabled()) {
					element.click();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		//This method is to navigate to any url
		public void navigateToUrl(String url) {
			driver.navigate().to(url);
		}
		
		
		//This method is to select a radio button
		public void selectRadioButton(WebElement element) {
			try {
				if(!element.isSelected()) {
					element.click();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//This method is to select a checkbox
		public void selectCheckBox(WebElement element) {
			try {
				if(!element.isSelected()) {
					element.click();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//This method is to enter text in a textbox/areabox
		public void enterText(WebElement element, String text) {
			try {
				if(element.isEnabled()) {
					element.sendKeys(text);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		// This method is to Implicitly wait for 20sec
		public void implicitlyWait() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
		
}
