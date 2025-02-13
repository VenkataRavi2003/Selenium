import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class LocatorsEx {
	public static void main(String[] args)throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver wbDriver = new ChromeDriver();
		wbDriver.get("https://facebook.com/login");
		
		Thread.sleep(3000);
		LaunchingTwoApplications.highlightElement(wbDriver,wbDriver.findElement(By.id("email")));
		Thread.sleep(3000);
		LaunchingTwoApplications.highlightElement(wbDriver,wbDriver.findElement(By.name("pass")));
		Thread.sleep(3000);
		LaunchingTwoApplications.highlightElement(wbDriver, wbDriver.findElement(By.className("")));
		Thread.sleep(3000);
		LaunchingTwoApplications.highlightElement(wbDriver, wbDriver.findElement(By.linkText("Forgotten account?")));
		Thread.sleep(3000);
		LaunchingTwoApplications.highlightElement(wbDriver, wbDriver.findElement(By.partialLinkText("Sign up")));
	}
}
