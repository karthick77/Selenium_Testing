package brpwserlaunnch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AffiliateFiilipkart {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\ELCOT\\eclipse-workspace\\Selenium_Testing\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://affiliate.flipkart.com/updates");
		
		WebElement email = driver.findElement(By.id("inputEmail"));
		email.sendKeys("karthick@gmail.com");
		
		WebElement pass = driver.findElement(By.id("inputPassword"));
		pass.sendKeys("123456");
		
		WebElement myclick = driver.findElement(By.xpath("//div[@class=\"user-details\"]//button"));
		myclick.click();
		
		WebElement res = driver.findElement(By.xpath("//form//p[@id=\"errorMsg\"]"));
		String fres = res.getText();
		System.out.println("Result: "+fres);
		
		
		Thread.sleep(3000);
		driver.close();
	}

}
