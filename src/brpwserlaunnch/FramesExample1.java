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

public class FramesExample1 {
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

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\ELCOT\\eclipse-workspace\\Selenium_Testing\\Driver\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/frame");
		
		driver.switchTo().frame("firstFr");
		
		WebElement fName = driver.findElement(By.name("fname"));
		fName.sendKeys("Varun");
		
		WebElement lName = driver.findElement(By.name("lname"));
		lName.sendKeys("Rahav");
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("firstFr");
		driver.switchTo().frame(1);
		
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("1190karthick@gmail.com");
		
		driver.switchTo().defaultContent();
		
		screenShots();
		
		Thread.sleep(3000);
		
		driver.close();
		
		
		
	}

}
