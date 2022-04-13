package laowoorks;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ButtoonExample2 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\ELCOT\\eclipse-workspace\\Selenium_Testing\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/buttons");
		
		driver.manage().window().maximize();
		
		//1.Button click
		WebElement home = driver.findElement(By.id("home"));
		home.click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Page Url: "+currentUrl);
		
		driver.navigate().back();
		driver.navigate().refresh();
		
		String currentUrl2 = driver.getCurrentUrl();
		System.out.println("Page Url: "+currentUrl2);
		
		//2.Button Position
		WebElement ele2 = driver.findElement(By.id("position"));
		Point location = ele2.getLocation();
		int x = location.getX();
		int y = location.getY();
		System.out.println("X => "+x+"Y => "+y);
		
		//3.color
		WebElement ele3 = driver.findElement(By.id("color"));
		String color = ele3.getCssValue("background-color");
		System.out.println("Button color: "+color);
		
		//4.Button Size
		WebElement ele4 = driver.findElement(By.id("property"));
		Rectangle rect = ele4.getRect();
		Dimension dime = rect.getDimension();
		int height = dime.getHeight();
		int width = dime.getWidth();
		System.out.println("Height: "+height+"Width: "+width);
		
		
		//5.isDisabled
		WebElement ele5 = driver.findElement(By.id("isDisabled"));
		boolean enabled = ele5.isEnabled();
		System.out.println("Button status: "+enabled);
		
		//6.
		
		
		
				
	}

}
