package laowoorks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Swaglab {
	
	static WebDriver driver = null;
	
	public static void delay() throws InterruptedException {
		Thread.sleep(3000);
	}
	
	public static void screenShots() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("_yyyyMMdd_hhmmss").format(new Date());
		String imgFormat = "Img"+timeStamp+".png";
		File des = new File("C:\\Users\\ELCOT\\eclipse-workspace\\Selenium_Testing\\Screenshots\\"+imgFormat);
		FileUtils.copyFile(src, des);
	}

	public static void main(String[] args) throws InterruptedException, IOException {

		FileInputStream stream = new FileInputStream("config.properties");
		Properties props = new Properties();
		props.load(stream);
		String browser = props.getProperty("browser");
		String driverLocation = props.getProperty("DriverLocation");
		System.out.println(driverLocation);
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverLocation);
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", driverLocation);
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/inventory.html");
		
		//1.User Name
		WebElement uname = driver.findElement(By.id("user-name"));
		uname.sendKeys("standard_user");
		
		//2.Password
		WebElement pass = driver.findElement(By.id("password"));
		pass.sendKeys("secret_sauce");
		
		//3.Login
		WebElement login = driver.findElement(By.id("login-button"));
		login.click();
		
		String tit = driver.getCurrentUrl();
		System.out.println(tit);
		
		//4.select the product
		WebElement pro1 = driver.findElement(By.xpath("//button[contains(@id,'ackpack')]"));
		pro1.click();
		
		//5.select second product
		WebElement pro2 = driver.findElement(By.xpath("//button[contains(@id,'allthethings')]"));
		pro2.click();
		
		//6.click cart button
		WebElement cart = driver.findElement(By.xpath("//a[contains(@class,'shopping')]"));
		cart.click();
		
		String title = driver.getCurrentUrl();
		System.out.println(title);
		
		screenShots();
		delay();
		
		WebElement checkOut = driver.findElement(By.id("checkout"));
		checkOut.click();
		
		delay();
		
		WebElement fname = driver.findElement(By.id("first-name"));
		fname.sendKeys("Karthick");
		
		WebElement lname = driver.findElement(By.id("last-name"));
		lname.sendKeys("Boopa");
		
		WebElement zipCode = driver.findElement(By.id("postal-code"));
		zipCode.sendKeys("123456");
		
		delay();
		
		WebElement con = driver.findElement(By.id("continue"));
		con.click();
		
		String title1 = driver.getCurrentUrl();
		System.out.println(title1);
		
		screenShots();
		delay();
		
		WebElement fin = driver.findElement(By.id("finish"));
		fin.click();
		
		screenShots();
		delay();
		
		WebElement backHome = driver.findElement(By.id("back-to-products"));
		backHome.click();
		
		String title2 = driver.getCurrentUrl();
		System.out.println(title2);
		
		driver.close();
	}

}
