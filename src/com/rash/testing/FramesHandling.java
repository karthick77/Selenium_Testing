package com.rash.testing;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesHandling {

	public static void main(String[] args) {

		String Path="\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+Path);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/droppable/");
		String actualUrl = driver.getCurrentUrl();
		System.out.println(actualUrl);
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
		WebElement src = driver.findElement(By.cssSelector("div[id='draggable']"));
		WebElement des = driver.findElement(By.cssSelector("div[id='droppable']"));
		
		Actions action = new Actions(driver);
		action.dragAndDrop(src, des).build().perform();
		
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()='Autocomplete']")).click();
		String changedUrl = driver.getCurrentUrl();
		System.out.println(changedUrl);
		
		driver.quit();
	}

}
