package com.adactinhotel;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC002_adactinhotel1{

	static WebDriver driver;

	public static void delay(int del) throws InterruptedException {
		Thread.sleep(del);
	}

	public static void takeScreenShots() throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String myDate = new SimpleDateFormat("_yyyyMMdd_hhmmss").format(new Date());
		String fileFormat = "Hotel"+myDate+".png";
		File des = new File("C:\\Users\\ELCOT\\eclipse-workspace\\Selenium_Testing\\Screenshots\\"+fileFormat);
		FileUtils.copyFile(src, des);
	}

	public static void main(String[] args) throws InterruptedException, IOException {

		String path = "\\Driver\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://adactinhotelapp.com/index.php");

		//1.Existing User Login - Build 1
		WebElement unameL = driver.findElement(By.id("username"));
		unameL.sendKeys("KarthickBoo");

		WebElement passL = driver.findElement(By.id("password"));
		passL.sendKeys("Bookhotel@77");
		
		takeScreenShots();
		delay(3000);
		
		driver.findElement(By.id("login")).click();

		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);

		String title = driver.getTitle();
		System.out.println(title);

		//driver.navigate().back();

		String currentUrl2 = driver.getCurrentUrl();
		System.out.println(currentUrl2);

		delay(3000);

		//Select Hotel
		WebElement Location = driver.findElement(By.id("location"));
		Select loc = new Select(Location);
		loc.selectByVisibleText("Sydney");

		WebElement hotel = driver.findElement(By.id("hotels"));
		Select ho = new Select(hotel);
		ho.selectByVisibleText("Hotel Cornice");

		WebElement roomT = driver.findElement(By.id("room_type"));
		Select rt = new Select(roomT);
		rt.selectByVisibleText("Standard");

		WebElement roomN = driver.findElement(By.id("room_nos"));
		Select rn = new Select(roomN);
		rn.selectByVisibleText("1 - One");

		WebElement dateIn = driver.findElement(By.id("datepick_in"));
		dateIn.sendKeys("20/02/2022");


		WebElement dateOut = driver.findElement(By.id("datepick_out"));
		dateOut.sendKeys("21/02/2022");

		WebElement adultPR = driver.findElement(By.id("adult_room"));
		Select apr = new Select(adultPR);
		apr.selectByValue("2");

		WebElement childPR = driver.findElement(By.id("child_room"));
		Select cpr = new Select(childPR);
		cpr.selectByValue("2");

		takeScreenShots();
		delay(3000);
		
		WebElement sub = driver.findElement(By.id("Submit"));
		sub.click();

		
		delay(2000);

		String title3 = driver.getTitle();
		System.out.println(title3);

		String url1 = driver.getCurrentUrl();
		System.out.println(url1);

		//Web table
		/* driver.navigate().back(); driver.navigate().refresh(); */
		WebElement radio1 = driver.findElement(By.id("radiobutton_0"));
		radio1.click();

		takeScreenShots();
		delay(3000);
		
		WebElement con1 = driver.findElement(By.id("continue"));
		con1.click();
		
		delay(2000);

		//Payment details
		WebElement fname = driver.findElement(By.id("first_name"));
		fname.sendKeys("Karthick");

		WebElement lname = driver.findElement(By.id("last_name"));
		lname.sendKeys("Tarak");

		WebElement add = driver.findElement(By.id("address"));
		add.sendKeys("4 ssss street, Chennai, India");

		WebElement ccno = driver.findElement(By.id("cc_num"));
		ccno.sendKeys("1234567898745612");

		WebElement cct = driver.findElement(By.id("cc_type"));
		Select cc = new Select(cct);
		cc.selectByVisibleText("American Express");

		WebElement expMonth = driver.findElement(By.id("cc_exp_month"));
		Select em = new Select(expMonth);
		em.selectByIndex(2);

		WebElement selYear = driver.findElement(By.id("cc_exp_year"));
		Select sy = new Select(selYear);
		sy.selectByVisibleText("2022");

		WebElement cvv = driver.findElement(By.id("cc_cvv"));
		cvv.sendKeys("723");

		takeScreenShots();
		delay(3000);

		WebElement can = driver.findElement(By.id("cancel"));
		can.click();

		driver.quit();


	}

}
