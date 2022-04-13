package laowoorks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class XpathLearning1 {

	public static void main(String[] args) throws InterruptedException {

		String path = "\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+path);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.demoblaze.com/index.html");
		WebElement pro1 = driver.findElement(By.xpath("//a[contains(text(),'s7')]"));
		pro1.click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement addToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Add to cart']")));
		addToCart.click();
		
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);
		WebElement cart = driver.findElement(By.xpath("//div[@id=\"navbarExample\"]//li[4]/a"));
		cart.click();
		Thread.sleep(5000);
		
		driver.quit();
	}

}
