package laowoorks;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Handle Alerts
public class AlertExample {
	
public static void  delay() throws InterruptedException {
		
		Thread.sleep(3000);
	}

	public static void main(String[] args) throws InterruptedException {
		
		String path = "\\Driver\\chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+path);
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.manage().window().maximize();
		
		//1.Click the button to display a alert box.
		WebElement ale1 = driver.findElement(By.xpath("//button[text()='Alert Box']"));
		ale1.click();
		delay();
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		
		//2.Click the button to display a confirm box.
		WebElement ale2 = driver.findElement(By.xpath("//button[text()='Confirm Box']"));
		ale2.click();
		delay();
		Alert alert2 = driver.switchTo().alert();
		alert2.dismiss();
		
		//3.Click the button to display a prompt box
		WebElement ale3 = driver.findElement(By.xpath("//button[text()='Prompt Box']"));
		ale3.click();
		delay();
		Alert alert3 = driver.switchTo().alert();
		alert3.sendKeys("My Alert Works");
		alert3.accept();
		
		//4. Seems like alert nut not
		WebElement ale4 = driver.findElement(By.xpath("//button[text()='Sweet Alert']"));
		ale4.click();
		delay();
		driver.findElement(By.className("swal-text")).click();
		
		driver.close();
	}

}
