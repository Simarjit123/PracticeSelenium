package com.simar.practiceSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectDropDown {
	WebDriver wd;
	Select select;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver99\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		wd.get("https://demoqa.com/select-menu");
		wd.manage().window().maximize();
	}

	@Test
	public void dropDownSelect() {
		WebElement selectOption = wd.findElement(By.cssSelector("#oldSelectMenu"));
		Select select = new Select(selectOption);
		select.selectByVisibleText("Green");

	}


	@AfterMethod
	public void tearDown() {
		wd.quit();
	}
}
