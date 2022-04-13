package laowoorks;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorExample2 {

	public static void main(String[] args) throws InterruptedException {

		String path = "\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+path);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/V4");
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String domain = jse.executeScript("return document.domain").toString();
		System.out.println("Domain is: "+domain);
		String url = jse.executeScript("return document.URL").toString();
		System.out.println("Url is: "+url);
		String title = jse.executeScript("return document.title").toString();
		System.out.println("Title: "+title);
		jse.executeScript("window.location = 'http://demo.guru99.com/'");
		
		Thread.sleep(3000);
		jse.executeScript("window.location = 'http://www.leafground.com/pages/Edit.html'");
		/*
		 * WebElement uname = driver.findElement(By.name("uid"));
		 * uname.sendKeys("mngr388939"); WebElement pass =
		 * driver.findElement(By.name("password")); pass.sendKeys("huzAgum");
		 * WebElement login = driver.findElement(By.name("btnLogin"));
		 * jse.executeScript("arguments[0].click();", login);
		 */
		WebElement txt1 = driver.findElement(By.id("email"));
		jse.executeScript("document.getElementById('email').value='rbc@xyz.com';");
		//jse.executeScript("alert('Correct login credentials has been entered');");
		Thread.sleep(3000);
	}

}
