package laowoorks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditField2 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\ELCOT\\eclipse-workspace\\Selenium_Testing\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/edit");
		driver.manage().window().maximize();
		
		WebElement name = driver.findElement(By.id("fullName"));
		name.sendKeys("Varun Rahav");
		
		WebElement append = driver.findElement(By.id("join"));
		append.sendKeys(" and talent boy"+Keys.TAB);
		
		WebElement getBox = driver.findElement(By.id("getMe"));
		String text = getBox.getAttribute("value");
		System.out.println(text);
		
		driver.findElement(By.id("clearMe")).clear();
		
		WebElement isenb = driver.findElement(By.id("noEdit"));
		boolean enabled = isenb.isEnabled();
		System.out.println(enabled);
		
		
		WebElement findElement = driver.findElement(By.id("dontwrite"));
		String attribute = findElement.getAttribute("readonly");
		System.out.println(attribute);
		
		driver.quit();
	
	}

}
