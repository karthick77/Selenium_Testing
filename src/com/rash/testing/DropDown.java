package com.rash.testing;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {

		String path = "\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+path);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement currency = driver.findElement(By.xpath("//select[contains(@id,'Currency')]"));
		Select curDropDown = new Select(currency);
		
		curDropDown.selectByIndex(3);
		System.out.println(curDropDown.getFirstSelectedOption().getText());
		
		Thread.sleep(2000);
		
		curDropDown.selectByValue("AED");
		System.out.println(curDropDown.getFirstSelectedOption().getText());
		
		Thread.sleep(2000);
		
		curDropDown.selectByVisibleText("INR");
		System.out.println(curDropDown.getFirstSelectedOption().getText());
		
		Thread.sleep(2000);
		
		List<WebElement> op1 = curDropDown.getOptions();
		for (WebElement web1 : op1) {
			System.out.println(web1.getText());
		}
		
		driver.quit();
	}

}
