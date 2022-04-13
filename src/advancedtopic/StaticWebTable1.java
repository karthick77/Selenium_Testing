package advancedtopic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTable1 {

	public static void main(String[] args) throws InterruptedException {

		String path = "\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+path);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.leafground.com/pages/table.html");

		//1.Get All details  - //table/tbody/tr/td
		//2.Headers  - //table/tbody/tr/th
		//3.Specific row - //table/tbody/tr[3]/td
		//4.Specific columns - //table/tbody/tr/td[4]

		//1. Get All details
		List<WebElement> all = driver.findElements(By.xpath("//table/tbody/tr/td"));
		for (WebElement w1 : all) {
			System.out.println(w1.getText());
		}

		//2. Headers from table
		System.out.println("********Headers***************");
		List<WebElement> head = driver.findElements(By.xpath("//table/tbody/tr/th"));
		for (WebElement w1 : head) {
			System.out.println(w1.getText());
		}

		//3. Separate Row
		System.out.println("********Specific Rows***************");
		List<WebElement> sRow = driver.findElements(By.xpath("//table/tbody/tr[3]/td"));
		for (WebElement w1 : sRow) {
			System.out.println(w1.getText());
		}

		//4. Separate Column
		System.out.println("********Specific Columns***************");
		List<WebElement> sCol = driver.findElements(By.xpath("//table/tbody/tr/td[5]"));
		for (WebElement w1 : sCol) {
			System.out.println(w1.getText());
		}

		//5.size row
		List<WebElement> rowSize = driver.findElements(By.tagName("tr"));
		int size = rowSize.size();
		System.out.println(size);

		//6.size column
		List<WebElement> colSize = driver.findElements(By.tagName("th"));
		int size1 = colSize.size();
		System.out.println(size1);

		//7.Following
		WebElement foll = driver.findElement(By.xpath("//td[normalize-space()='Learn Locators']//following::td[4]"));
		System.out.println(foll.getText());

		List<WebElement> percent = driver.findElements(By.xpath("//td[2]"));
		ArrayList<Integer> col = new ArrayList<>();
		for (WebElement w1 : percent) {
			String rep = w1.getText().replace("%", "");
			int parseInt = Integer.parseInt(rep);
			col.add(parseInt);
		}

		Integer min = Collections.min(col);
		System.out.println(min);

		//td[normalize-space()='30%']//following::td
		//"td[normalize-space()='"+min+"%']//following::td"
		String s1 = Integer.toString(min);
		System.out.println("//td[normalize-space()=\'"+s1+"%\']//following::td[1]");

		String finalXpath = "//td[normalize-space()=\'"+s1+"%\']//following::td[1]/input";
		WebElement find1 = driver.findElement(By.xpath(finalXpath));
		Thread.sleep(2000); find1.click();

		/*
		 * WebElement check1 =
		 * driver.findElement(By.xpath("//*[@id=\"table_id\"]/tbody/tr[4]/td[3]/input"))
		 * ; check1.click();
		 */

		Thread.sleep(3000);

		driver.quit();
	}
}


