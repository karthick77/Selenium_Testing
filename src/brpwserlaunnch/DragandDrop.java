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
import org.openqa.selenium.interactions.Actions;

public class DragandDrop {
	
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

		String path = "\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/drop.html");
		
		Actions acc = new Actions(driver);
		
		WebElement src = driver.findElement(By.id("draggable"));
		WebElement des = driver.findElement(By.id("droppable"));
		Thread.sleep(3000);
		
		acc.clickAndHold(src).moveToElement(des).build().perform();
		screenShots();
		Thread.sleep(3000);
		
		driver.get("https://letcode.in/dropable");
		WebElement src1 = driver.findElement(By.id("draggable"));
		WebElement des1 = driver.findElement(By.id("droppable"));
		Thread.sleep(3000);
		
		acc.dragAndDrop(src1, des1).build().perform();
		screenShots();
		Thread.sleep(3000);
		
		driver.close();
		
	}

}
