package com.rash.testing;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AnchortagCounter {

	public static void main(String[] args) throws InterruptedException {

		String Path="\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+Path);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		String actualUrl = driver.getCurrentUrl();
		System.out.println(actualUrl);
		
		countLink(driver);
		int countFooLink = countFooLink(driver);
		System.out.println(countFooLink);
		int countSubLink = countSubLink(driver);
		System.out.println(countSubLink);
		Thread.sleep(5000);
		Set<String> winHad = driver.getWindowHandles();
		
		Iterator<String> ite = winHad.iterator();
		
		while(ite.hasNext()) {
			String nxt = ite.next();
			String tit = driver.switchTo().window(nxt).getCurrentUrl();
			System.out.println(tit);
			
		}
		driver.quit();
	}
	
	public static void countLink(WebDriver driver) {
		
		int size = driver.findElements(By.tagName("a")).size();
		System.out.println(size);
	}
	
	public static int countFooLink(WebDriver driver) {
		
		WebElement fooDriver = driver.findElement(By.cssSelector("div[id='gf-BIG']"));
		int fooLinkCount = fooDriver.findElements(By.tagName("a")).size();
		
		return fooLinkCount;
	}
	
public static int countSubLink(WebDriver fooDriver) throws InterruptedException {
		
		WebElement subDriver = fooDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		int subLinkCount = subDriver.findElements(By.tagName("a")).size();
		
		Thread.sleep(2000);
		
		for(int i=1; i<subLinkCount; i++) {
			String ch = Keys.chord(Keys.CONTROL, Keys.ENTER);
			Thread.sleep(1000);
			subDriver.findElements(By.tagName("a")).get(i).sendKeys(ch);		
		}
		
		
		
		
		return subLinkCount;
	}

}
