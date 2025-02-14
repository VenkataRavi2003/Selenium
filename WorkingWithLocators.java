package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithLocators {
	public static void main(String[] args)throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver wbDriver = new ChromeDriver();
		wbDriver.get("file:///C:/Users/guruv/OneDrive/Desktop/GITHUB%20UPLOADS/test.html");
		
		WebElement genderRadioBtn = wbDriver.findElement(By.name("gender"));
		genderRadioBtn.click();
		Thread.sleep(2000);
		
		WebElement firstNameTextBox = wbDriver.findElement(By.id("fname"));
		firstNameTextBox.clear();
		firstNameTextBox.sendKeys("Venkata Ravi");
		Thread.sleep(2000);
		
		WebElement lastNameTextBox = wbDriver.findElement(By.id("lname"));
		lastNameTextBox.clear();
		lastNameTextBox.sendKeys("Yerragadda");
		
	}
}
