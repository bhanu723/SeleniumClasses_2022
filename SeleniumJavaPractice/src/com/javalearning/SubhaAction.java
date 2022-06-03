package com.javalearning;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SubhaAction {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Selenium\\\\Driver\\\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "/Users/bhanusurendradeepala/Downloads/chromedriver_V93");

		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com/menu/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// driver.close();
		// WHEN I TRIED FOR --> https://www.flipkart.com/
		// **********HANDLE BROWSER POPUP*********
		/*
		 * Steps to Handle Browser Popup To handle Window we need WINDOW ID. every
		 * window generated at runtime has UNIQUE WINDOW ID generated as a String. we
		 * should switch the control from Parent window to Child Window. To do that we
		 * get the help of getWindowHandles() method . Here we are using two windows so
		 * we are using HANDLES method intead of HANDLE method. This getWindowHandles()
		 * method returns a Set Object. A Set Object (JAVA COLLECTIONS concept, one of
		 * the JAVA UTILITIES) has parent window id and child window id stored as
		 * string. But not sequentially. Not using Indexes. To access the window id we
		 * get the help of Iterator (JAVA Utilities) , where we create a ref of string
		 * type and make it point to our Set Object. By default , this iterator will
		 * point to just above our Set Object Since the following position will be of
		 * Parent Window id, we use next() method to iterator ref to make it goto next
		 * position. Now Iterator points towards PArent Window ID we can now use this
		 * ref current position and store it in a PARENT window variable Next we again
		 * use it.next() to make it goto the next position,. ie ,, CHILD WINDOW ID. now
		 * we can store this current iterator ref to Child Window ID variable.
		 * 
		 * Now we use switchTO().window(<pass the window id to shift between parent and
		 * child )
		 */

		// driver.getWindowHandles();// this gives me a Set Object.
		// So we are creating a Set Object Reference and making the set object to point
		// to that reference.
		/*
		 * ************ Set <String> myset = driver.getWindowHandles();
		 * //myset.iterator();// this returns me an Iterator Object. Iterator <String>
		 * myit = myset.iterator();
		 * 
		 * //myit.next();// Now it points to PArent Window ID String myParent =
		 * myit.next();
		 * 
		 * System.out.println(myParent);
		 * 
		 * String myChild = myit.next();
		 * 
		 * System.out.println(myChild);
		 * 
		 * //We got the ID.
		 * 
		 * //Switch from Parent to Child Window. myChild = "PXgNtTli3A";
		 * driver.switchTo().window(myChild); //Give some time until the switch action
		 * is completed....
		 * 
		 * Thread.sleep(1000); driver.close(); //Child window is closed. DONOT USE
		 * .QUIT() method as it will close the entire Browser.
		 * 
		 * driver.switchTo().window(myParent);
		 *************** 
		 */
		// MOUSE OVER
		Actions action = new Actions(driver);

		// driver.switchTo().frame(0);
		// IGNORE--->//Alert mypop = driver.switchTo().alert();
		// IGNORE--->driver.findElement(By.className("_2KpZ6l _2doB4z")).click();
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/a"))).perform();
		// Thread.sleep(3000);
		action.moveToElement(driver.findElement(By.linkText("SUB SUB LIST »"))).perform();
		// Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.linkText("Sub Sub Item 2"))).click().build().perform();
		;
		// Thread.sleep(1000);
		// .build().perform();
		// Thread.sleep(2000);
		// action.moveToElement(driver.findElement(By.linkText("Main Item
		// 2"))).moveToElement(driver.findElement(By.linkText("SUB SUB
		// LIST"))).moveToElement(driver.findElement(By.linkText("Sub Sub Item
		// 1"))).build().perform();
		// .build().perform();

		// Thread.sleep(2000);

		driver.close();

	}

}
