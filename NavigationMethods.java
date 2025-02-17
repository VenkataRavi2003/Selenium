import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class NavigationMethods {
	public static void main(String[] args)throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver wbDriver = new ChromeDriver();
		
		wbDriver.get("https://google.com/");
		wbDriver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		//to();
		wbDriver.navigate().to("https://github.com/login");
		Thread.sleep(3000);
		
		wbDriver.findElement(By.id("login_field")).sendKeys("ramu22@gamil.com");
		Thread.sleep(3000);
		
		wbDriver.findElement(By.id("password")).sendKeys("xyz123");
		Thread.sleep(3000);
		
		wbDriver.findElement(By.name("commit")).click();
		Thread.sleep(3000);
		
		//reload();
		wbDriver.navigate().refresh();
		Thread.sleep(3000);
		
		//back();
		wbDriver.navigate().back();
		
		//forward();
		wbDriver.navigate().forward();
		Thread.sleep(3000);
		
		//to
		wbDriver.navigate().to("https://google.com/");
		
		
	}
}
