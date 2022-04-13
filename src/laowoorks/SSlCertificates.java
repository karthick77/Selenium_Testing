package laowoorks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSlCertificates {

	public static void main(String[] args) {

		String path = "\\Driver\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+path);
		
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://expired.badssl.com/");
		String text = driver.findElement(By.cssSelector("#content h1")).getText();
		System.out.println(text);
	}

}
