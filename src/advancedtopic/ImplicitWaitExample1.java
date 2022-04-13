package advancedtopic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImplicitWaitExample1 {

	public static void main(String[] args) {

		String path = "\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+path);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://meesho.io/jobs");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement loadMore = wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.xpath("//button[text()='Load more']")));
		loadMore.click();
		
		driver.close();
		
	}

}
