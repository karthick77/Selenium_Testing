package laowoorks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditField {

	public static void main(String[] args)  throws InterruptedException{

		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\ELCOT\\eclipse-workspace\\Selenium_Testing\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("1190karthickgmail.com");
		
		WebElement append = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/input"));
		append.sendKeys("To Selenium");
		
		String text2 = driver.findElement(By.name("username")).getAttribute("value");
		System.out.println("Text from Work with Edit  value attribute "+text2);
		
		WebElement clearText = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/div/div/input"));
		clearText.clear();
		
		WebElement enableCheck = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[5]/div/div/input"));
		boolean isEnable = enableCheck.isEnabled();
		System.out.println("Text field status: "+isEnable);
		
		Thread.sleep(3500);
		
		driver.close();
		
		
	}

}
