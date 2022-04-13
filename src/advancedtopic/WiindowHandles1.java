package advancedtopic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WiindowHandles1 {

	public static void main(String[] args) throws InterruptedException {

		String path = "\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+path);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/Window.html");
		
		String parentW = driver.getWindowHandle();
		
		
		WebElement homePage = driver.findElement(By.xpath("//button[text()='Open Home Page']"));
		homePage.click();
		
		//Control still in parent window
		Set<String> noOfWin = driver.getWindowHandles();
		for(String a: noOfWin) {
			driver.switchTo().window(a);
			String title = driver.getTitle();
			System.out.println(title);
		}
		
		driver.switchTo().window(parentW);
		
		int size = driver.getWindowHandles().size();
		System.out.println(size);
		
		WebElement subTab = driver.findElement(By.xpath("//button[text()='Open Multiple Windows']"));
		subTab.click();
		
		int size2 = driver.getWindowHandles().size();
		System.out.println(size2);
		
		Set<String> w1 = driver.getWindowHandles();
		
		for(String b:w1) {
			
			if(!b.equals(parentW)) {
				driver.switchTo().window(b);
				String t1 = driver.getTitle();
				System.out.println(t1);
				driver.close();
			}
		}
		
		driver.switchTo().window(parentW);
		String title = driver.getTitle();
		System.out.println(title);
		Thread.sleep(5000);
		
		
		driver.get("https://letcode.in/windows");
		
		WebElement k1 = driver.findElement(By.id("home"));
		k1.click();
		
		int size3 = driver.getWindowHandles().size();
		System.out.println(size3);
		
		Set<String> h1 = driver.getWindowHandles();
		List<String> l1 = new ArrayList<String>(h1);
		
		driver.switchTo().window(l1.get(1));
		String t3 = driver.getTitle();
		System.out.println(t3);
		
		driver.close();
		
		driver.switchTo().window(l1.get(0));
		
		driver.quit();
		
		
		
	}

}
