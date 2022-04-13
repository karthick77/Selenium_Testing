package com.rash.testing;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCart {

	public static void main(String[] args) throws InterruptedException {

		String Path="\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+Path);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wt = new WebDriverWait(driver, 5);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		String[] veggies = {"Beans","Potato","Brocolli","Cucumber","Carrot"};

		Thread.sleep(2000);
		addItems(driver, veggies);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode")));
		
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		
		String promoCode = driver.findElement(By.cssSelector(".promoInfo")).getText();
		System.out.println(promoCode);
		
		driver.findElement(By.cssSelector(".promoBtn")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		//driver.quit();
	}

	public static void addItems(WebDriver driver, String[] veggiesStr) throws InterruptedException {
		List<WebElement> pName = driver.findElements(By.xpath("//h4[@class='product-name']"));

		List<String> addedVegg = Arrays.asList(veggiesStr);

		System.out.println(veggiesStr.length);

		int j=0;

		for(int i=0; i<pName.size(); i++) {

			String txtAllProd = pName.get(i).getText();
			String[] txtSplit = txtAllProd.split(" ");
			String txtTrim = txtSplit[0].trim();

			if(addedVegg.contains(txtTrim)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				Thread.sleep(1000);
				if(j==veggiesStr.length) {
					break;
				}
			}
		}

		//Thread.sleep(6000);

	}
}
