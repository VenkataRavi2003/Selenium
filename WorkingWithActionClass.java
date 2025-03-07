package com.testNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WorkingWithActionClass {
    WebDriver driver;
    Actions actions;

    @BeforeClass
    public void setUp() {
        // Set up WebDriver
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/");
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }

    @Test(priority = 1)
    public void hoverOverSignOn() {
        WebElement signOn = driver.findElement(By.linkText("SIGN-ON"));
        actions.moveToElement(signOn).perform();
        System.out.println("Hovered over SIGN-ON button.");
    }

    @Test(priority = 2)
    public void clickOnRegister() {
        WebElement register = driver.findElement(By.linkText("REGISTER"));
        register.click();
        System.out.println("Clicked on REGISTER.");
    }

    @Test(priority = 3)
    public void fillRegistrationForm() {
        WebElement username = driver.findElement(By.name("userName"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement confirmPassword = driver.findElement(By.name("confirmPassword"));
        
        username.sendKeys("Y Venkata Ravi");
        password.sendKeys("0000");
        confirmPassword.sendKeys("0000");

        System.out.println("Filled the registration form.");
    }

    @Test(priority = 4)
    public void submitForm() {
        WebElement submitButton = driver.findElement(By.name("submit"));
        actions.moveToElement(submitButton).click().perform();
        System.out.println("Clicked on Submit button.");
    }

    @Test(priority = 5)
    public void verifyRegistration() {
        WebElement confirmationText = driver.findElement(By.xpath("//b[contains(text(),'Dear')]"));
        Assert.assertTrue(confirmationText.isDisplayed(), "Registration failed!");
        System.out.println("Registration successful.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        System.out.println("Closed the browser.");
    }
}
