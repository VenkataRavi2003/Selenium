import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class LaunchingTwoApplications {
	public static void main(String[] args) throws InterruptedException{
		
		WebDriverManager.chromedriver().setup();
		WebDriver wbDriver = new ChromeDriver();
		wbDriver.get("https://amazon.com");
		
		Thread.sleep(4000);
		
		wbDriver.get("https://flipkart.com");	
	}
}
