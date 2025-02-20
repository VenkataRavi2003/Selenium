package selenium;

import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementsMethodEx {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver wbDriver = new ChromeDriver();
		wbDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wbDriver.get("file:///C:/Users/guruv/OneDrive/Desktop/GITHUB%20UPLOADS/Form.html?username=");
		wbDriver.manage().window().maximize();
		wbDriver.findElement(By.xpath("//input[@id='username']")).sendKeys("venkat");
		wbDriver.findElement(By.xpath("//input[@id='male']")).click();
		
		List<WebElement> checkBoxListItems = wbDriver.findElements(By.xpath("//input[@type = 'checkbox']"));
		
//		for (WebElement webElement : checkBoxListItems) {
//			String value = webElement.getDomProperty("value");
//			System.out.println(value);
//		}
		
		ListIterator<WebElement> litr = checkBoxListItems.listIterator();
		while(litr.hasNext()) {
			WebElement checkBox = litr.next();
			String value = checkBox.getDomProperty("value");
			System.out.println(value);
			checkBox.click();
		}
	}
}
