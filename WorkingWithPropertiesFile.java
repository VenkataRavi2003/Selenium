package com.testNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithPropertiesFile {
	
	WebDriver wbDriver;
	File file;
	Properties properties;
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		wbDriver = new ChromeDriver();
		wbDriver.manage().window().maximize();
		wbDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test(description="loading Data To Properties" , priority = 1 , enabled = true)
	public void loadingDataToProperties() {
		file = new File("C:\\Users\\guruv\\eclipse-workspace\\com.testNG\\Github.properties");
		properties = new Properties();
		try(FileInputStream fis = new FileInputStream(file)){
			properties.load(fis);
		}catch(IOException ie) {
			ie.printStackTrace();
		}
	}
	@Test(description="Opening Application" , priority = 2 , enabled = true)
	public void openingApplication() {
		wbDriver.get(properties.getProperty("url"));
	}
	@Test(description="Entering Credentials" , priority = 3 , enabled = true)
	public void enteringCredentials() {
		wbDriver.findElement(By.xpath(properties.getProperty("usernameLocation"))).sendKeys(properties.getProperty("username"));
		wbDriver.findElement(By.xpath(properties.getProperty("passwordLocation"))).sendKeys(properties.getProperty("password"));
		wbDriver.findElement(By.xpath(properties.getProperty("submitButtonLocation"))).click();
	}
}
