import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class ImplicitTimeOut {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver wbDriver = new ChromeDriver();
		wbDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wbDriver.manage().window().setSize(new Dimension(1000,1000));
		wbDriver.get("https://www.hyrtutorials.com/p/waits-demo.html");
		wbDriver.findElement(By.cssSelector("button#btn1")).click();
		wbDriver.findElement(By.xpath("(//input[@id = 'txt1'])[1]")).sendKeys("Venkata Ravi");
		wbDriver.findElement(By.xpath("//button[contains(text(),'Add Textbox2')]")).click();
		wbDriver.findElement(By.xpath("(//input[@id = 'txt2'])[1]")).sendKeys("Yerragadda");
	}
}
