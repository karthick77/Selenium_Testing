package com.rash.testing;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TableSortedCheck1 {

	public static void main(String[] args) {

		String path = "\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+path);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		getTableElements(driver);
		
		WebElement finalText = driver.findElement(By.xpath("//a[@aria-label='Last']"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(finalText));
	}
	
	public static void getTableElements(WebDriver driver) {
		
		//1.click on heading
		driver.findElement(By.xpath("//tr//th/span[contains(text(),'name')]")).click();
		//2.Get vegetable and fruit name
		List<WebElement> vegFruitItems = driver.findElements(By.xpath("//tr//td[1]"));
		
		List<String> originalList = vegFruitItems.stream().map(s->s.getText()).collect(Collectors.toList());
		
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		
		  if(originalList.equals(sortedList) == true) 
		  {
			  System.out.println("Both list values are same"); 
		  }else {
			  System.out.println("Both list values are not equal"); 
		  }
		 
		Stream<Integer> itemPrice = vegFruitItems.stream().filter(s->s.getText().contains("Beans")).map(s->getPrice(s));
		itemPrice.forEach(s->System.out.println(s));
		
	}
	
	public static int getPrice(WebElement we) {
		
		String price = we.findElement(By.xpath("following-sibling::td[1]")).getText();
		int priceValue = Integer.parseInt(price);
		
		return priceValue;
		
	}

}
