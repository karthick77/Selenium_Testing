package com.rash.testing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ScrollCapture {

	public static void main(String[] args) {
		
		String Path="\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+Path);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)");
		List<WebElement> colValues = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		ArrayList<Integer> values = new ArrayList<Integer>();
		int sum=0;
		for (WebElement w1 : colValues) {
			String txt = w1.getText();
			int num = Integer.parseInt(txt);
			values.add(num);
			sum += num;
		}
		
		Integer max2 = Collections.max(values);
		System.out.println("Maximum:"+max2);
		
		String maxStr2 = max2.toString();
		String subX2 = "//div[@class=\'tableFixHead\']//td[4][text()=\'"+maxStr2+"\']/preceding-sibling::td[position() mod 2=1 and position()>1]";
		//System.out.println(subX2);
		String fftxt = driver.findElement(By.xpath(subX2)).getText();
		System.out.println("Name : "+fftxt);
		
		String checkTxt = driver.findElement(By.cssSelector("[class='totalAmount']")).getText();
		String[] spt = checkTxt.split(":");
		int actual = Integer.parseInt(spt[1].trim());
		
		if(actual==sum) {
			System.out.println("Table values matches");
		}else {
			System.out.println("Table values not matches");
		}
		
		List<WebElement> firstTable = driver.findElements(By.cssSelector("[name='courses'] td:nth-child(3)"));
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		int total=0;
		for (WebElement w2 : firstTable) {
			String txt1 = w2.getText();
			int num1 = Integer.parseInt(txt1);
			numbers.add(num1);
			total += Integer.parseInt(txt1);
		}
		Integer min = Collections.min(numbers);
		String minStr = min.toString();
		
		String subX = "//table[@name=\'courses\']//td[3][text()=\'"+minStr+"\']";
		//System.out.println(subX);
		
		WebElement minv = driver.findElement(By.xpath(subX));
		String ftxt = minv.findElement(By.xpath("//table[@name='courses']//td[3][text()='0']/preceding-sibling::td[position() mod 2=1]")).getText();
		System.out.println("Sub Table: "+min);
		System.out.println("Minimum course details: "+ftxt);
		System.out.println("First Table: "+total);
		
	}

}
