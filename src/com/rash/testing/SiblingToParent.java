package com.rash.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SiblingToParent {

	/*
	 * 
	 *1. Same level traversing
	 * //header/div/button[1]/following-sibling::button[1]
	 * 
	 * 2. Child to parent
	 * //header/div/button[1]/parent::div
	 * 
	 * 	 * */
	public static void main(String[] args) {

		String path = "\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+path);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String txt1 = driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();
		System.out.println(txt1);
		
		String txt2 = driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[2]")).getText();
		System.out.println(txt2);
		
		driver.quit();
	}

}
