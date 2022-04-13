package com.rash.testing;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {

		String Path="\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+Path);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		String actualUrl = driver.getCurrentUrl();
		System.out.println(actualUrl);
		
		driver.findElement(By.cssSelector("a[class='blinkingText']")).click();
		Set<String> wHandles = driver.getWindowHandles();
		Iterator<String> it = wHandles.iterator();
		String parent = it.next();
		String child1 = it.next();
		
		driver.switchTo().window(child1);
		
		
		String clickedUrl = driver.getCurrentUrl();
		System.out.println(clickedUrl);
		
		Thread.sleep(2000);
		
		String txt = driver.findElement(By.cssSelector("p[class='im-para red']")).getText();
		String[] spt = txt.split(" ");
		
		String email=null;
		for (String st : spt) {
			if(st.contains(".com"))
			{
				email = st.trim();
				break;
			}
		}
		
		driver.switchTo().window(parent);
		
		driver.findElement(By.cssSelector("input[id='username']")).sendKeys(email);
		
	}

}
