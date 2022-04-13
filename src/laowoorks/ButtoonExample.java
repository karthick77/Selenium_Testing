package laowoorks;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ButtoonExample {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\ELCOT\\eclipse-workspace\\Selenium_Testing\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Button.html");
		
		driver.manage().window().maximize();
		
		//1. Get Button position
		WebElement buttonPosition = driver.findElement(By.id("position"));
		Point location = buttonPosition.getLocation();
		int x = location.getX();
		int y = location.getY();
		System.out.println("X position: "+x+"Y Position: "+y);
		
		//2. Find by color
		WebElement btnColor = driver.findElement(By.id("color"));
		String color = btnColor.getCssValue("background-color");
		System.out.println("Button color: "+color);
		
		//3.Size of button
		WebElement btnSize = driver.findElement(By.id("size"));
		int height = btnSize.getSize().getHeight();
		int width = btnSize.getSize().getWidth();
		System.out.println("Height: "+height+"Width: "+width);
		
		//4.Button click
		WebElement home = driver.findElement(By.id("home"));
		home.click();
		
		driver.navigate().back();
		driver.navigate().refresh();
		
		Thread.sleep(4000);
		driver.close();
	}

}
