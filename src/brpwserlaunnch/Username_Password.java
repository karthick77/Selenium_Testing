package brpwserlaunnch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Username_Password {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\ELCOT\\eclipse-workspace\\Selenium_Testing\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		//load URL
		String url = "https://demo.guru99.com/V4/";
		driver.get(url);
		driver.manage().window().maximize();
		
		//Title, URL and Current page heading
		String title = driver.getTitle();
		System.out.println("Title of the Webpage: "+title);
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current Url of webpage: "+currentUrl);
	
		
		//Login credential
		WebElement name = driver.findElement(By.name("uid"));
		name.sendKeys("mngr366103");
		
		WebElement pass = driver.findElement(By.name("password"));
		pass.sendKeys("sYrehup");
		
		driver.findElement(By.name("btnLogin")).click();
		
		WebElement result = driver.findElement(By.className("heading3"));
		String finRes = result.getText();
		System.out.println("Login details: "+finRes);
		
		driver.navigate().back();
		
		String titleb = driver.getTitle();
		System.out.println("Title of the Webpage: "+titleb);
		
		String currentUrlb = driver.getCurrentUrl();
		System.out.println("Current Url of webpage: "+currentUrlb);
		
		driver.navigate().refresh();
		
		Thread.sleep(3000);
		driver.close();
	}

}
