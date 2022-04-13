package laowoorks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hyperlink {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\ELCOT\\eclipse-workspace\\Selenium_Testing\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Link.html");
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Go to Home Page")).click();
		
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.navigate().back();
		

		String title2 = driver.getTitle();
		System.out.println(title2);
		
		Thread.sleep(2000);
		
		driver.close();
		
	}

}
