package advancedtopic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.awt.*;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


public class UploadFile {

	public static void main(String[] args) throws AWTException, InterruptedException{

		String path = "\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+path);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("C://Users//ELCOT//Desktop//FileUpload.html");
		String data = "C:\\Users\\ELCOT\\Pictures\\Screenshots\\Screenshot (322).png";
		Thread.sleep(5000);
		WebElement up = driver.findElement(By.xpath("//*[@id='fileToUpload']"));
		up.sendKeys(data);
		
		
		
		  //String data = "C:\\Users\\ELCOT\\Pictures\\Screenshots\\Screenshot (322).png";
			/*
			 * StringSelection sel = new StringSelection(data);
			 * Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
			 * 
			 * Robot rob = new Robot();
			 * 
			 * rob.keyPress(KeyEvent.VK_CONTROL); rob.keyPress(KeyEvent.VK_V);
			 * rob.keyRelease(KeyEvent.VK_V); rob.keyRelease(KeyEvent.VK_CONTROL);
			 * Thread.sleep(3000); rob.keyPress(KeyEvent.VK_ENTER);
			 * rob.keyPress(KeyEvent.VK_ENTER);
			 */
		 
	}

}
