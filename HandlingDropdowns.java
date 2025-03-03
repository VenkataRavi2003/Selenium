package com.testNG;

import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingDropdowns {
	
	WebDriver wbDriver;
	private String url = "https://www.globalsqa.com/demo-site/select-dropdown-menu/";
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		wbDriver = new ChromeDriver();
		wbDriver.manage().window().maximize();
		wbDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("setup completed..");
	}
	
	@Test
	public void launchingSite() {
		wbDriver.navigate().to(url);
	}
	
	@Test
	public void selectingCountry() {
		WebElement dropdown = wbDriver.findElement(By.tagName("select"));
		
		Select select = new Select(dropdown);
		
		List<WebElement> countries = select.getOptions();
		
		System.out.println("List of countries : ");
		
//		for (WebElement we : countries) {
//			System.out.println(we.getText());
//			if(we.getText().equalsIgnoreCase("India")) {
//				we.click();
//				break;
//			}
//		}
		
		ListIterator<WebElement> options = countries.listIterator();
		
		while (options.hasNext()) {
			WebElement webElement = (WebElement) options.next();
			System.out.println(webElement.getText());
			if(webElement.getText().equalsIgnoreCase("china")) {
				select.selectByVisibleText("China");
				System.out.println("/nselected country : china");
				break;
			}
		}
		System.out.println("\nTotal no.of countries listed : "+countries.size());
		
	}
	
	
	
}
