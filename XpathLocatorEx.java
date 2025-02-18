package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathLocatorEx {
	public static void main(String[] args)throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver wbDriver = new ChromeDriver();
		wbDriver.get("https://instagram.com/");
		wbDriver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		wbDriver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("7788559966");
		
		Thread.sleep(2000);
		
		wbDriver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("venky006!");
		
		Thread.sleep(2000);
		
		wbDriver.findElement(By.xpath("//button[@class = ' _acan _acap _acas _aj1- _ap30']")).submit();
	}
}
