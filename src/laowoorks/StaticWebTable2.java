package laowoorks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTable2 {

	public static void main(String[] args) {

		String path = "\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+path);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/table");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//1.Table1
		System.out.println("**************Table1*********************");
		List<WebElement> shop = driver.findElements(By.xpath("//table[@id='shopping']/tbody/tr/td"));
		for (WebElement w1 : shop) {
			System.out.println(w1.getText());
		}
		
		List<WebElement> shopH = driver.findElements(By.xpath("//table[@id='shopping']/thead/tr/th"));
		for (WebElement w2 : shopH) {
			System.out.println(w2.getText());
		}
		
		List<WebElement> shopF = driver.findElements(By.xpath("//table[@id='shopping']/tfoot/td"));
		for (WebElement w3 : shopF) {
			System.out.println(w3.getText());
		}
		
		//Table2
		System.out.println("**************Table2*********************");
		List<WebElement> let1 = driver.findElements(By.xpath("//table[@id='simpletable']/thead/tr/th"));
		for (WebElement l1 : let1) {
			System.out.println(l1.getText());
		}
		
		List<WebElement> let2 = driver.findElements(By.xpath("//table[@id='simpletable']/tbody/tr/td"));
		for (WebElement l2 : let2) {
			System.out.println(l2.getText());
		}
		
		//Table3
		System.out.println("***************Table3****************");
		List<WebElement> sort1 = driver.findElements(By.xpath("//table[contains(@class,'sort')]/thead/th/div"));
		for(WebElement s1:sort1) {
			System.out.println(s1.getText());
		}
		
		List<WebElement> sort2 = driver.findElements(By.xpath("//table[contains(@class,'sort')]/tr/td"));
		for (WebElement s2 : sort2) {
			System.out.println(s2.getText());
		}
	}

}
