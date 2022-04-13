package com.rash.testing;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableSortedCheck3 {

	public static void main(String[] args) {
		
		String path = "\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+path);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.cssSelector("[id='search-field']")).sendKeys("Rice");
		List<WebElement> nameList = driver.findElements(By.xpath("//tr/td[position()=1]"));
		List<WebElement> collectedList = nameList.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
		
		if(nameList.size() == collectedList.size()) {
			System.out.println("Both list are same");
		}else {
			System.out.println("Both produced invalid list");
		}
		

	}

}
