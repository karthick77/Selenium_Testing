package com.adactinhotel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC001_adactinhotel1 {
	
	public static void delay(int del) throws InterruptedException {
		Thread.sleep(del);
	}

	public static void main(String[] args) throws InterruptedException {
		String path ="\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+path);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://adactinhotelapp.com/index.php");
		
		//1.New Registration link click
		driver.findElement(By.partialLinkText("User ")).click();
		
		//2.New Registration page
		WebElement uNameR = driver.findElement(By.id("username"));
		uNameR.sendKeys("VarunkaJa");
		
		WebElement passR = driver.findElement(By.id("password"));
		passR.sendKeys("password1234");
		
		WebElement retypePR = driver.findElement(By.id("re_password"));
		retypePR.sendKeys("password1234");
		
		WebElement fullName = driver.findElement(By.id("full_name"));
		fullName.sendKeys("Varun Rahav Karthick");
		
		WebElement emailR = driver.findElement(By.id("email_add"));
		emailR.sendKeys("mail2bkarthick@gmail.com");
		
		//For Captcha  entry manually done
		delay(10000);
		
		WebElement termCon = driver.findElement(By.id("tnc_box"));
		termCon.click();
		
		WebElement regR = driver.findElement(By.id("Submit"));
		regR.click();
		
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.close();
	}

}
