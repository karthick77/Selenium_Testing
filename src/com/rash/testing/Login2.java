package com.rash.testing;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login2 {
	
	public static void main(String[] args) throws InterruptedException, IOException {

		
		String path = "\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+path);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String pass = getPassword(driver);
		takeScreenShot(driver);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
		driver.findElement(By.id("inputUsername")).sendKeys("contact@gmail.com");
		driver.findElement(By.name("inputPassword")).sendKeys(pass);
		Thread.sleep(1000);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.className("signInBtn")).click();
		takeScreenShot(driver);
		Thread.sleep(3000);
		driver.quit();
	}
	/*
	 * Launch URL >> click forget password >> Pick generated password
	 * */
	public static String getPassword(WebDriver driver) throws InterruptedException {
		
		driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		String txt = driver.findElement(By.cssSelector("p.infoMsg")).getText();
		String[] spl1 = txt.split("'");
		String pwd = spl1[1].trim();
		return pwd;
		
	}
	/*
	 * Taking Screenshots of web page by passing web driver control
	 * and save it in a folder
	 * */
	public static void takeScreenShot(WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("_yyyyMMdd_hhmmss").format(new Date());
		String fileName = "Login2Img"+timeStamp+".png";
		File des = new File(System.getProperty("user.dir")+"\\Rash_ScreenShots\\"+fileName);
		FileUtils.copyFile(src, des);
	}

}
