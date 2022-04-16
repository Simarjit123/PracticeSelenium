package com.simar.practiceSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseActionsPractice {
	WebDriver wd;
	Actions action;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver99\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		action = new Actions(wd);
		wd.get("https://demoqa.com/buttons");
		wd.manage().window().maximize();
	}

	@Test
	public void doubleClick() {
		WebElement dblClick = wd.findElement(By.id("doubleClickBtn"));
		action.doubleClick(dblClick).perform();
	}

	@Test
	public void rightClick() {
		WebElement rightClickBtn = wd.findElement(By.id("rightClickBtn"));
		action.contextClick(rightClickBtn).perform();
	}

	@Test
	public void click() {

		WebElement clickBt = wd.findElement(By.cssSelector("div.mt-4:nth-of-type(3) button"));
		action.click(clickBt).perform();
	}

	@AfterMethod
	public void tearDown() {
		wd.quit();
	}
}