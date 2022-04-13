package brpwserlaunnch;

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

public class ScreenshotWorks {
	
	static WebDriver driver;
	
	public static void screenShots() throws IOException {
		
		//Narrowing - Type cast - double -> float -> long -> int -> char -> short -> byte 
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcVal = ts.getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("_yyyyMMdd_hhmmss").format(new Date());
		String fileName = "Img"+timeStamp+".png";
		File desVal = new File("C:\\Users\\ELCOT\\eclipse-workspace\\Selenium_Testing\\Screenshots\\"+fileName);
		FileUtils.copyFile(srcVal, desVal);
	}

	public static void main(String[] args) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\ELCOT\\eclipse-workspace\\Selenium_Testing\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://zoom.us/signin");
		driver.manage().window().maximize();
		
		//1. Inspecting - Email address 
		WebElement emailEle = driver.findElement(By.id("email"));
		emailEle.sendKeys("1190karthick@gmail.com");
		
		//2. Inspecting - Password
		WebElement passEle = driver.findElement(By.id("password"));
		passEle.sendKeys("123456789");
		
		//3. Inspecting - Click Button
		WebElement btnEle = driver.findElement(By.xpath("//button[contains(@class,'signin')]"));
		btnEle.click();
		Thread.sleep(3000);
		screenShots();
		Thread.sleep(3000);
		driver.close();
	}

}
