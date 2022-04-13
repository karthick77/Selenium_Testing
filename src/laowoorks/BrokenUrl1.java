package laowoorks;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenUrl1 {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {

		String path = "\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+path);
		WebDriver driver = new ChromeDriver();
		HttpsURLConnection huc = null;
		
		String homePage = "https://www.zlti.com/";
		String url = "";
		
		driver.manage().window().maximize();
		driver.get(homePage);
		
		List<WebElement> fes1 = driver.findElements(By.tagName("a"));
		
		Iterator<WebElement> ite = fes1.iterator();
		
		while(ite.hasNext()) {
			url = ite.next().getAttribute("href");
			
			if(url==null || url.isEmpty()) {
				System.out.println(url+ " - URL is either not configured for anchor tag or it is empty");
				continue;
			}
			
			if(!url.startsWith(homePage)) {
				System.out.println(url+" - URL belongs to another domain, skipping it.");
				continue;
			}
			
			huc = (HttpsURLConnection) (new URL(url).openConnection());
			huc.setRequestMethod("HEAD");
			huc.connect();
			int resCode = huc.getResponseCode();
			
			if(resCode >= 400) {
				System.out.println(url+" is a broken link");
			}else {
				System.out.println(url+" is a valid link");
			}
			
		}
		
		Thread.sleep(10000);
		driver.quit();
	}

}
