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

public class ShoppingCart1 {
	

	public static void main(String[] args) throws InterruptedException, IOException {

		String path = "\\Driver\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+path);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		
		WebElement catW = driver.findElement(By.xpath("//li/a[text()='Women']"));
		catW.click();
		Thread.sleep(5000);;
		WebElement catT = driver.findElement(By.linkText("Tops"));
		catT.click();
		
		WebElement shirt1 = driver.findElement(By.xpath("//div/a[@title='Faded Short Sleeve T-shirts']"));
		shirt1.click();
		
		Thread.sleep(5000);;
		driver.switchTo().frame(0);
		
		WebElement quan1 = driver.findElement(By.xpath("//input[@id='quantity_wanted']"));
		quan1.clear();
		quan1.sendKeys("3");
		
		
		WebElement sizeS = driver.findElement(By.id("group_1"));
		Select sel = new Select(sizeS);
		sel.selectByIndex(0);
		Thread.sleep(5000);;
		
		WebElement addToCart = driver.findElement(By.xpath("//p[@id='add_to_cart']/button"));
		addToCart.click();
		
		driver.switchTo().defaultContent();
		Thread.sleep(5000);;
		
		WebElement proceedToCart = driver.findElement(By.xpath("//*[@id='layer_cart']//a[@title='Proceed to checkout']"));
		proceedToCart.click();
		Thread.sleep(5000);;
		
		WebElement finalCart = driver.findElement(By.xpath("//p[contains(@class,'cart')]//a[contains(@title,'checkout')]"));
		finalCart.click();
		Thread.sleep(5000);;	
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("1190karthick@gmail.com");
		
		
		WebElement pass = driver.findElement(By.id("passwd"));
		pass.sendKeys("Kart@77");
		
		
		WebElement submit = driver.findElement(By.xpath("//button[@id='SubmitLogin']"));
		submit.click();
		
		Thread.sleep(5000);;
		
		WebElement add = driver.findElement(By.xpath("//button[contains(@name,'process')]"));
		add.click();
		Thread.sleep(5000);;
		
		WebElement ship = driver.findElement(By.xpath("//input[@value='1']"));
		ship.click();
		
		WebElement shipbtn = driver.findElement(By.xpath("//button[contains(@name,\"Carrier\")]"));
		shipbtn.click();
		
		Thread.sleep(5000);;
		
		WebElement bankWire = driver.findElement(By.xpath("//a[@class='bankwire']"));
		bankWire.click();
		
		Thread.sleep(5000);
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcVal = ts.getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("_yyyyMMdd_hhmmss").format(new Date());
		String fileName = "Img"+timeStamp+".png";
		File desVal = new File("C:\\Users\\ELCOT\\eclipse-workspace\\Selenium_Testing\\Screenshots\\"+fileName);
		FileUtils.copyFile(srcVal, desVal);
		
		//screenShots();
		WebElement pay = driver.findElement(By.xpath("//p[@id='cart_navigation']//button"));
		pay.click();
		Thread.sleep(5000);;
		
		WebElement back = driver.findElement(By.xpath("//a[contains(@title,'Back')]"));
		back.click();
		
		driver.close();
	}

}
