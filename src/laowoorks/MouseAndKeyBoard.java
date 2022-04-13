package laowoorks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;


import java.awt.event.KeyEvent;
import java.awt.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;



public class MouseAndKeyBoard {

	public static void main(String[] args) throws IOException, FileNotFoundException, AWTException, InterruptedException {

		WebDriver driver=null;
		FileReader fr = new FileReader("config.properties");
		BufferedReader br = new BufferedReader(fr);

		Properties props = new Properties();

		props.load(br);

		String browser = props.getProperty("browser");
		String DriverLocation = props.getProperty("DriverLocation");

		System.out.println(DriverLocation);

		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", DriverLocation);
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", DriverLocation);
			driver = new FirefoxDriver();
		}

		String parent = driver.getWindowHandle();

		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

		//1. Inspect Gmail link:
		Actions mos = new Actions(driver);
		WebElement gmailLink = driver.findElement(By.xpath("//a[text()='Gmail']"));
		mos.contextClick(gmailLink).build().perform();

		Robot kyb = new Robot();

		kyb.keyPress(KeyEvent.VK_DOWN);
		kyb.keyRelease(KeyEvent.VK_DOWN);

		kyb.keyPress(KeyEvent.VK_DOWN);
		kyb.keyRelease(KeyEvent.VK_DOWN);


		kyb.keyPress(KeyEvent.VK_DOWN); 
		kyb.keyRelease(KeyEvent.VK_DOWN);


		Thread.sleep(3000);

		kyb.keyPress(KeyEvent.VK_ENTER);
		kyb.keyRelease(KeyEvent.VK_ENTER);

		Set<String> wh1 = driver.getWindowHandles();
		for(String a:wh1) {
			driver.switchTo().window(a);
		}

		driver.get("https://www.facebook.com/");

		Thread.sleep(5000);

		String t1 = driver.getTitle();
		System.out.println(t1);

		//1.driver.quit();

		driver.switchTo().window(parent);

		String t2 = driver.getTitle();
		System.out.println(t2);

		Thread.sleep(3000);
		driver.close();

		Set<String> wh2 = driver.getWindowHandles();
		for(String a:wh2) {
			driver.switchTo().window(a);
		}
		
		Thread.sleep(3000);
		driver.quit();
		//1.driver.close();
	}

}
