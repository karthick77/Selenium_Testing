package advancedtopic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WindoeHandling2 {

	public static void main(String[] args) throws InterruptedException, AWTException {

		String path = "\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+path);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		String parentWindow = driver.getWindowHandle();
		//WebElement topLink = driver.findElement(By.cssSelector("div[id='nav-xshop'] a[href*='bestsellers']"));
		////div[@id='nav-xshop']//a[position() <5]
		//List<WebElement> topLinks = driver.findElements(By.cssSelector("div[id='nav-xshop'] a[href]"));
		List<WebElement> topLinks = driver.findElements(By.xpath("//div[@id='nav-xshop']//a[position() <=5]"));
		
		
		 int tpl = topLinks.size(); 
		 System.out.println(tpl);
		
		
		Actions act = new Actions(driver);
		Robot robo = new Robot();
		
		/*
		 * act.contextClick(topLink).build().perform(); topLink.sendKeys(Keys.DOWN);
		 * String chd = Keys.chord(Keys.CONTROL, Keys.ENTER); topLink.sendKeys(chd);
		 */
		
		for (WebElement webe : topLinks) {
			
			act.contextClick(webe).build().perform();
			robo.keyPress(KeyEvent.VK_DOWN);
			robo.keyRelease(KeyEvent.VK_DOWN);
			
			robo.keyPress(KeyEvent.VK_ENTER);
			robo.keyPress(KeyEvent.VK_ENTER);
			
			Thread.sleep(3000);	
		}
		
		
		Set<String> windowHandles = driver.getWindowHandles();
		for (String s : windowHandles) {
			driver.switchTo().window(s);
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
			System.out.println();
			System.out.println("============================");
			System.out.println();
			//Thread.sleep(2000);
		}
		
		driver.switchTo().window(parentWindow);
	}

}
