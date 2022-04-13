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
import org.openqa.selenium.support.ui.Select;

public class FacebookNewAccount {
	
	static WebDriver driver;
	
	public static void delay() throws InterruptedException {
		Thread.sleep(3000);
	}
	
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
		driver.get("https://www.facebook.com/");
		
		WebElement newAcc = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		newAcc.click();
		
		delay();
		
		WebElement fname = driver.findElement(By.name("firstname"));
		fname.sendKeys("karthick");
		delay();
		
		WebElement lname = driver.findElement(By.name("lastname"));
		lname.sendKeys("boopathy");
		delay();
		
		WebElement email = driver.findElement(By.xpath("//input[contains(@name,'reg_email')]"));
		email.sendKeys("1190karthick@gmail.com");
		delay();
		
		WebElement newPass = driver.findElement(By.xpath("//input[contains(@name,'reg_passwd')]"));
		newPass.sendKeys("123456789");
		delay();
		
		WebElement day = driver.findElement(By.id("day"));
		Select sc1 = new Select(day);
		sc1.selectByVisibleText("25");
		
		WebElement mon = driver.findElement(By.id("month"));
		Select sc2 = new Select(mon);
		sc2.selectByVisibleText("Mar");
		
		WebElement yer = driver.findElement(By.id("year"));
		Select sc3 = new Select(yer);
		sc3.selectByVisibleText("2000");
		
		WebElement gen = driver.findElement(By.xpath("//input[@value='2']"));
		gen.click();
		
		
		screenShots();
		delay();
		
		driver.close();
		
		
	}

}
