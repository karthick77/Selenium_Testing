package com.testngworks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SwagLogin {

	@Test(dataProvider = "getData")
	public void login(String user, String pwd) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS); 
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/inventory.html");
		WebElement uname = driver.findElement(By.id("user-name"));
		uname.sendKeys(user);

		WebElement pass = driver.findElement(By.id("password"));
		pass.sendKeys(pwd);

		WebElement login = driver.findElement(By.id("login-button"));
		login.click();
		
		screenShots(driver);
		
		Thread.sleep(3000);
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData() throws IOException{
		
		String path = "C:\\Users\\ELCOT\\eclipse-workspace\\Selenium_Testing\\DataFile\\mydata.xls";
		FileInputStream fis = new FileInputStream(path);
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		HSSFSheet sheet = workbook.getSheet("Sheet1");
		int rowCount = sheet.getPhysicalNumberOfRows();	
		Object[][] data = new Object[rowCount][2];
		
		for (int i = 0; i < rowCount; i++) {
			
			HSSFRow row = sheet.getRow(i);
			
			HSSFCell username = row.getCell(0);
			data[i][0] = username.toString().trim();
			
			HSSFCell password = row.getCell(1);
			data[i][1] = password.toString().trim();
		}
		
		return data;
		
	}
	
	
	  public static void screenShots(WebDriver driver) throws IOException {
	  TakesScreenshot ts = (TakesScreenshot) driver; 
	  File src = ts.getScreenshotAs(OutputType.FILE); 
	  String timeStamp = new SimpleDateFormat("_yyyyMMdd_hhmmss").format(new Date()); 
	  String imgFormat ="Img"+timeStamp+".png"; 
	  File des = new
	  File("C:\\Users\\ELCOT\\eclipse-workspace\\Selenium_Testing\\Screenshots\\"+
	  imgFormat); FileUtils.copyFile(src, des); 
	  }
	 

}
