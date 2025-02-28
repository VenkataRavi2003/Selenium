package com.testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidatingPageTitle {
	public String flipkartURL = "https://flipkart.com/";
	public WebDriver wbDriver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		wbDriver = new ChromeDriver();
		wbDriver.manage().window().maximize();
		wbDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wbDriver.get(flipkartURL);
	}
	
	@Test
	public void testingZeptoHomePageTitle() {
		String expectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		String actualTitle = wbDriver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		
	}
	
	@AfterTest
	public void close() {
		wbDriver.quit();
	}
	
}
