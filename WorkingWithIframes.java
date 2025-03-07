package com.testNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WorkingWithIframes {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/html/html_iframe.asp");
        driver.manage().window().maximize();
    }

    @Test
    public void handleIframe() {
    
        WebElement iframeElement = driver.findElement(By.xpath("//iframe[contains(@title, 'W3Schools Free Online Web Tutorials')]"));
        driver.switchTo().frame(iframeElement);

        WebElement signUpButton = driver.findElement(By.linkText("Sign Up"));
        signUpButton.click();
        System.out.println("Clicked Sign Up inside the iframe.");

        driver.switchTo().defaultContent();
        System.out.println("Switched back to the main content.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
