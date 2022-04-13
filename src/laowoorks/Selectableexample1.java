package laowoorks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Selectableexample1 {

	public static void main(String[] args) throws InterruptedException {

		String path = "\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+path);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/selectable.html");
		
		List<WebElement> sel = driver.findElements(By.xpath("//*[@id='selectable']/li"));
		
		int size = sel.size();
		System.out.println(size);
		
		Actions act = new Actions(driver);
		/*
		 * act.keyDown(Keys.CONTROL).click(sel.get(0)) .click(sel.get(1))
		 * .click(sel.get(2)).build().perform();
		 */
		
		act.clickAndHold(sel.get(0))
		.clickAndHold(sel.get(1))
		.clickAndHold(sel.get(2))
		.build().perform();
		
		Thread.sleep(3000);
		
		driver.get("http://www.leafground.com/pages/sortable.html");
		
		List<WebElement> sor = driver.findElements(By.xpath("//*[@id='sortable']/li"));
		
		WebElement last = sor.get(size-1);
		WebElement first = sor.get(0);
		
		Thread.sleep(3000);
		
		act.clickAndHold(last).moveToElement(first).release(first).build().perform();
		
		Thread.sleep(3000);
		driver.get("https://www.amazon.in/");
		
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("iphone 13");
		
		WebElement sclick = driver.findElement(By.id("nav-search-submit-button"));
		sclick.click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement imgClick = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[8]/div/div/div/div/div/div[1]/div/div[2]/div/span/a/div/img"));
		imgClick.click();
		
	}

}
