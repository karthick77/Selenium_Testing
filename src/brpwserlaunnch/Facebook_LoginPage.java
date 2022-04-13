package brpwserlaunnch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook_LoginPage {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\ELCOT\\eclipse-workspace\\Selenium_Testing\\Driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		//Web driver methods
		driver.get("https://www.facebook.com/");
		
		//manage
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		System.out.println("Url Title: "+title);
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL: "+currentUrl);
		
		String pageSource = driver.getPageSource();
		System.out.println("Source is: "+pageSource);
		
		//Navigation methods
		driver.navigate().to("https://www.amazon.in/");
		
		driver.navigate().back();
		
		driver.navigate().forward();
	
		driver.navigate().refresh();
		
		Thread.sleep(3000);
		
		driver.close();
	}

}
