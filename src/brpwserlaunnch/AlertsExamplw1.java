package brpwserlaunnch;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsExamplw1 {

	public static void main(String[] args) throws InterruptedException {
		
		String path = "\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+path);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Alerts.html");
		
		Dimension dime = new Dimension(1200, 800);
		driver.manage().window().setSize(dime);
		
		Thread.sleep(2000);
		
		driver.manage().window().maximize();
		
		//1.    click the button to display an  alert box:
		WebElement aOk = driver.findElement(By.xpath("//li[@class='active']/a"));
		aOk.click();
		driver.findElement(By.id("OKTab")).click();
		Alert at1 = driver.switchTo().alert();
		String t1 = at1.getText();
		System.out.println(t1);
		Thread.sleep(2000);
		at1.accept();
		
		//2. click the button to display a confirm box 
		WebElement okC = driver.findElement(By.xpath("//li/a[contains(text(),'OK & Cancel')]"));
		okC.click();
		driver.findElement(By.id("CancelTab")).click();
		Alert at2 = driver.switchTo().alert();
		String t2 = at2.getText();
		System.out.println(t2);
		at2.accept();
		WebElement con = driver.findElement(By.id("demo"));
		String text1 = con.getText();
		System.out.println(text1);
		
		//3. click the button to display a text Box
		WebElement textB = driver.findElement(By.xpath("//li/a[contains(text(),'Textbox ')]"));
		textB.click();
		driver.findElement(By.id("Textbox")).click();
		Alert at3 = driver.switchTo().alert();
		String t3 = at3.getText();
		System.out.println(t3);
		at3.sendKeys("Automating Via selenium");
		Thread.sleep(3000);
		at3.accept();
		WebElement txt = driver.findElement(By.id("demo1"));
		System.out.println(txt.getText());
		
		
		
		driver.close();
	}

}
