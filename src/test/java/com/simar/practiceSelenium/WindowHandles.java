package com.simar.practiceSelenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowHandles {
	WebDriver wd;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver99\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		wd.get("https://demoqa.com/browser-windows");
		wd.manage().window().maximize();
	}

	@Test
	public void testWindowHandle() {
		// Opening all the child window
		wd.findElement(By.id("windowButton")).click();
		wd.findElement(By.id("messageWindowButton")).click();

		String MainWindow = wd.getWindowHandle();
		System.out.println("Main window handle is " + MainWindow);

		// To handle all new opened window
		Set<String> allWindowHandles = wd.getWindowHandles();
		System.out.println("Child window handle is" + allWindowHandles);

	}

	
	@AfterMethod
	public void tearDown() {
		wd.quit();
	}
}
