package laowoorks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Remove_Automation_Text {

	public static void main(String[] args) {

		String path = "\\Driver\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+path);

		
		  ChromeOptions options = new ChromeOptions();
		  options.setExperimentalOption("excludeSwitches", new String[]
		  {"enable-automation"});
		  
		  WebDriver driver = new ChromeDriver(options);
		 
		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.manage().window().maximize();

	}

}
