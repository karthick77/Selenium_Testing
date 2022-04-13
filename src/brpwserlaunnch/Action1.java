package brpwserlaunnch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Set;

public class Action1 {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, AWTException{

		String path = "\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		String parentWindow= driver.getWindowHandle();
		
		Actions acc = new Actions(driver);
		WebElement gmail = driver.findElement(By.xpath("//a[text()='Gmail']"));
		acc.contextClick(gmail).build().perform();
		
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_DOWN);
		robo.keyRelease(KeyEvent.VK_DOWN);
		
		robo.keyPress(KeyEvent.VK_DOWN);
		robo.keyRelease(KeyEvent.VK_DOWN);
		
		/*
		 * robo.keyPress(KeyEvent.VK_DOWN); robo.keyRelease(KeyEvent.VK_DOWN);
		 */
		
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyPress(KeyEvent.VK_ENTER);
		
		Thread.sleep(6000);
		
		Set<String> windowHandles = driver.getWindowHandles();
		for(String curWindow : windowHandles){
		    driver.switchTo().window(curWindow);
		}
		
		driver.get("https://www.facebook.com/");
		
		Thread.sleep(6000);
		
		//driver.quit();  - NoSuchSessionException
		driver.close();
		
		driver.switchTo().window(parentWindow);
		
		driver.quit();
	}

}
