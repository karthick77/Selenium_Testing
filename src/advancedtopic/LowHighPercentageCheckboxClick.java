package advancedtopic;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LowHighPercentageCheckboxClick {

	static WebDriver driver=null;

	public static void takeScreenShot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		//File des = new File("C:\\Users\\ELCOT\\eclipse-workspace\\Selenium_Testing\\Screenshots");
		File des = new File(System.getProperty("user.dir")+"\\Screenshots\\lowPercentClick.png");
		FileUtils.copyFile(src, des);
	}

	public static void main(String[] args) throws InterruptedException, IOException {

		String path = "\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<WebElement> percent = driver.findElements(By.xpath("//td[2]"));
		ArrayList<Integer> col = new ArrayList<>();
		for (WebElement w1 : percent) {
			String rep = w1.getText().replace("%", "");
			int parseInt = Integer.parseInt(rep);
			col.add(parseInt);
		}

		Integer min = Collections.min(col);
		System.out.println(min);

		String s1 = Integer.toString(min);
		System.out.println("//td[normalize-space()=\'"+s1+"%\']//following::td[1]/input");

		String finalXpath = "//td[normalize-space()=\'"+s1+"%\']//following::td[1]/input";
		WebElement find1 = driver.findElement(By.xpath(finalXpath));
		Thread.sleep(2000); 
		find1.click();
		
		takeScreenShot();

		driver.quit();
	}

}
