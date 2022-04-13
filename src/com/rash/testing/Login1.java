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

public class Login1 {

	static WebDriver driver = null;

	public static void takeScreenShot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("_yyyyMMdd_hhmmss").format(new Date());
		String fileName = "Img"+timeStamp+".png";
		File des = new File(System.getProperty("user.dir")+"\\Rash_ScreenShots\\"+fileName);
		FileUtils.copyFile(src, des);
	}
	public static void main(String[] args) throws IOException, InterruptedException {

		//1.Launches Browser
		String path = "\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+path);
		//2.Handling browser
		driver = new ChromeDriver();
		/*
		 * Implicitly wait - is use to wait for given time if any web element
		 * is taking time to load or display, once a web element appears it wont
		 * wait for further time immediately switch to next executable statement.
		 * If not it will go for raising Exception - NoSuchElement.
		 * */
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//3.Maximize the browser window
		driver.manage().window().maximize();
		//4.Launch URL in browser
		driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
		//5.User name
		driver.findElement(By.id("inputUsername")).sendKeys("contact@gmail.com");
		//6.Password
		driver.findElement(By.name("inputPassword")).sendKeys("123456");
		//7.Check box checked
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();
		//8.Button clicked
		driver.findElement(By.className("signInBtn")).click();
		/*9.CSS Selector - Inspect Element >> Console >> $('p.error')
		 * tagname#id, tagname.class, tagname[attribute='value']
		 */
		String result = driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println("Response from Login page: "+result);
		//10. Forget Password
		driver.findElement(By.linkText("Forgot your password?")).click();
		//11.Reset password name
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
		//12. email
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john.ra@");
		//13.clear email
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		//14.css email
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("1190karthick@gmail.com");
		//15.phone
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9789978998");
		//16. Button clicked
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		//17.text status
		String txt = driver.findElement(By.cssSelector("p.infoMsg")).getText();
		System.out.println(txt);
		takeScreenShot();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
		driver.findElement(By.id("inputUsername")).sendKeys("contact@gmail.com");
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		Thread.sleep(1000);
		
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		//21.Taking Screen Shots
		takeScreenShot();
		
		String txt2 = driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText();
		System.out.println(txt2);
		String txt3 = driver.findElement(By.xpath("//div[@class='login-container']/h1")).getText();
		System.out.println(txt3);
		
		takeScreenShot();
		Thread.sleep(2000);
	
		
		driver.quit();

	}

}
