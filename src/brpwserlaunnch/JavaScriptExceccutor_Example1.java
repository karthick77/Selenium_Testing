package brpwserlaunnch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaScriptExceccutor_Example1 {

	public static void main(String[] args) throws InterruptedException {

		String path = "\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+path);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//scroll to specific height
		jse.executeScript("window.scroll(0,1000)");
		//scroll to bottom
		Thread.sleep(3000);
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		//Specific element
		Thread.sleep(3000);
		WebElement popular = driver.findElement(By.xpath("//strong[contains(text(),'100')]"));
		jse.executeScript("arguments[0].scrollIntoView(true);", popular);
		Thread.sleep(3000);
		jse.executeScript("window.scroll(0,0)");
		
	}

}
