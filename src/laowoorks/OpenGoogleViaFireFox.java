package laowoorks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class OpenGoogleViaFireFox {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", 
				"C:\\Users\\ELCOT\\eclipse-workspace\\Selenium_Testing\\Driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Agni rocket"+Keys.ENTER);
				
		Thread.sleep(3000);
		driver.quit();
		
	}

}
